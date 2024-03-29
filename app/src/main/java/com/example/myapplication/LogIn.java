package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private TextView sign_up_button;
    private Button btnLogin;
    private ProgressDialog PD;

@Override    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_log_in);

    PD = new ProgressDialog(this);
    PD.setMessage("Loading...");
    PD.setCancelable(true);
    PD.setCanceledOnTouchOutside(false);
    auth = FirebaseAuth.getInstance();

    inputEmail = (EditText) findViewById(R.id.email);
    inputPassword = (EditText) findViewById(R.id.password);
    sign_up_button = (TextView) findViewById(R.id.sign_up_button);
    btnLogin = (Button) findViewById(R.id.sign_in_button);

    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override            public void onClick(View view) {
            final String email = inputEmail.getText().toString();
            final String password = inputPassword.getText().toString();

            try {

                if (password.length() > 0 && email.length() > 0) {
                    PD.show();
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(
                                                LogIn.this,
                                                "Authentication Failed",
                                                Toast.LENGTH_LONG).show();
                                        Log.v("error", task.getResult().toString());
                                    } else {
                                        Intent intent = new Intent(LogIn.this, Register.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    PD.dismiss();
                                }
                            });
                } else {
                    Toast.makeText(
                            LogIn.this,
                            "Fill All Fields",
                            Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

    sign_up_button                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          .setOnClickListener(new View.OnClickListener() {
        @Override            public void onClick(View view) {
            Intent intent = new Intent(LogIn.this, Register.class);
            startActivity(intent);
        }
    });

    findViewById(R.id.forget_password_button).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(), Register.class).putExtra("Mode", 0));
        }
    });

}

    @Override    protected void onResume() {
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LogIn.this, Register.class));
            finish();
        }
        super.onResume();
    }
}
