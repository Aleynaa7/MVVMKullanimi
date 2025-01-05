package com.example.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikDataSource {
    //suspend: coroutine özelliği olduğunu ve yani asenkron çalışma yaptığını belirtmek için
    suspend fun topla(alinanSayi1:String, alinanSayi2:String) : String = withContext(Dispatchers.IO){ //:String fonksiyonun return özelliği olacağını belitmrek için, coroutine ile return etmeyi belirtmek içn de şu ıo vs şeyi,, ıo yani inputoutput data kısmında kullanılan yapı yani veritabanına yakın olan kısımlarda (main ise viewmodeldeki kullanımda olduğu gibi uı'a yakın olan kısımlarda kullanlan yapı
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplam = sayi1 + sayi2
        return@withContext toplam.toString()
    }

    suspend fun carp(alinanSayi1:String, alinanSayi2:String) : String = withContext(Dispatchers.IO){
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val carpma = sayi1 * sayi2
       return@withContext carpma.toString()
    }
}





//finalde işlem datasource yaptırılır:
//viewmodel ve livedata uı katmanındaki işlemlerdi, şimdi data katmanına ihtiyaç duyulduğu analrda olacak olanlar şunlar: viewmodelde yapılan finaldeki işlemler yani toplama çarpma datasource'da yapılacak, buradan da repository bu işlemleri viewmodele iletecek, repositoryinin tek işi bu
//viewmodel de sayfadan aldığı direktifi repositorye iletir o da datasource'a ve işlem yapar
//return işlemleri de livedata ile değil coroutine ile olur (katmanlar arası geçim sağlar ve asenkron özelliği sağlar, ayrıca rum gibi kütüphanelere direkt entegre edilebilir: kayıf ve slyatta var bunlar)


//datasource yapılan işlemin sonucu arayüzde gösterilemk istenmiyorsa livedata ya da coroutşnea gerek yok

//slaytta var entity:
//entity bir katman değil sadece viewmodele repositorry ve datasource destek olan bir sınıf, yani datasource'a vs veri aktarılmayacağız: bir yapı onlar içinde kullanılabilen yardımcı yapı, livedata gibi içlerinde kullanılan bir yapı