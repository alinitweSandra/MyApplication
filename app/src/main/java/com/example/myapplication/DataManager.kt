package com.example.myapplication

import java.util.*

class DataManager {
init {
    initialiseBrands()


}
    val brands = ArrayList<Brand>()
    val types = ArrayList<Type>()
    val models = ArrayList<Model>()

    fun initialiseBrands(){
        var brand1  = Brand(1,"Toyota", R.drawable.tsap)
        brands.set(1,brand1)
        var brand2 = Brand(1,"Mazda", R.drawable.tsap)
        brands.set(2,brand2)


        var type1 = Type(1,"Spacio",44,brand1.title)
        types.set(1,type1)
        var type2 = Type(1,"Wish",44,brand1.title)
        types.set(2,type2)

        var type3 = Type(1,"harrier",44,brand2.title)
        types.set(1,type1)
        var type4 = Type(1,"premio",44,brand2.title)
        types.set(2,type2)

        var model1 = Model(1,"spacio1",1,type1.title)
        var model2 = Model(1,"spacio2",1,type1.title)

        var model3 = Model(1,"wish1",1,type2.title)
        var model4 = Model(1,"wish2",1,type2.title)


    }
}