package com.example.myapplication;

public class Manufacturer {
     public Integer id;
     public String title,model;
     public Integer logo;

     public Manufacturer(Integer id, String title,String model,Integer logo){
         this.id =id;
         this.title = title;
         this.model = model;
         this.logo = logo;
     }
}
