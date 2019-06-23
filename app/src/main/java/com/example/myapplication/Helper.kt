package com.example.myapplication

class Brand(var id:Int, var title:String, var logo:Int)

class Type(var id:Int, var title:String, var logo: Int, var brand: String)

class Model(var id:Int, var title: String, var logo: Int, var type: String)