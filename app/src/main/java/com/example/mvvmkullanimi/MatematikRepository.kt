package com.example.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikRepository {
    var matematikDataSource = MatematikDataSource() //ynetmek istediğimiz classın bir nesnesi olsun ki erişebilelim

    suspend fun topla(alinanSayi1:String, alinanSayi2:String) : String {
        return matematikDataSource.topla(alinanSayi1,alinanSayi2)
    }

    //bu kullanım daha tavsiye edilir
    suspend fun carp(alinanSayi1:String, alinanSayi2:String) : String = matematikDataSource.carp(alinanSayi1,alinanSayi2)
}