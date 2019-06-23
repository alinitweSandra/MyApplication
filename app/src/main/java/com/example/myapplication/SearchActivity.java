package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity{

        // Declare Variables
        GridView list;
        ListViewAdapater adapter;
        SearchView editsearch;
        String[] animalNameList;
        Integer[] logo;
        ArrayList<AnimalNames> arraylist = new ArrayList<AnimalNames>();

@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Generate sample data

        animalNameList = new String[]{"Toyota", "Lexus", "Mercedes",
        "Ford", "Jeep", "Vox Wagen", "Mazda", "Audi",
        "Nissan","Subaru","Mitsubishi", "BMW"};

        logo = new Integer[]{R.drawable.totyoya,R.drawable.lexux,R.drawable.test,R.drawable.test,R.drawable.jeep,R.drawable.test,R.drawable.mazda,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test};

        // Locate the ListView in listview_main.xml
        list = (GridView) findViewById(R.id.listview);

        CustomAdapte adapter = new CustomAdapte(this,animalNameList,logo);
        list.setAdapter(adapter);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Integer position = i;
                        String itemValue = (String)list.getItemAtPosition(position);

                        //Toast.makeText(getApplicationContext(),"Position:"+position+" ItemCliked "+itemValue,Toast.LENGTH_LONG).show();
                        Intent registerInt = new Intent(SearchActivity.this,ToyotaModel.class);
                        String pos = Integer.toString(position);
                        registerInt.putExtra("position",pos);
                        registerInt.putExtra("itemName",itemValue);
                        startActivity(registerInt);









                }
        });

        }

}

class CustomAdapte extends ArrayAdapter<String>{
        private final Context context;
        private final String[] items;
        private final Integer[] logo;

        public CustomAdapte(Context context, String [] items, Integer[] logo) {
                super(context, R.layout.activity_custom_adapter,items);
                this.context = context;
                this.items = items;
                this.logo = logo;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View rawView = inflater.inflate(R.layout.activity_custom_adapter,null,true);
                TextView title = (TextView) rawView.findViewById(R.id.textView);
                ImageView image = (ImageView)rawView.findViewById(R.id.imageView);
                title.setText(items[position]);
                image.setImageResource(logo[position]);
                return rawView;
        }
}