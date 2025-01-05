package com.example.mvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    //var sonuc = "0" //okuma işlemi için gerekli olacak olan değişken: sonucu alan taraf
    var sonuc = MutableLiveData("0")

    var matematikRepository = MatematikRepository() //yönetmek istiyorsak bu classdan veri oluştuurlur

    fun topla(alinanSayi1:String, alinanSayi2:String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = matematikRepository.topla(alinanSayi1,alinanSayi2)
        } //işlemi yazıp sonra sonuc.value ile de livedataya aktarıyoruz
    }

    fun carp(alinanSayi1:String, alinanSayi2:String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = matematikRepository.carp(alinanSayi1,alinanSayi2)
        }
    }


    /*BURASI SADECE LİVEDATA VE VİEWMOEL OLDUĞUNDAKİ HALİ
    fun topla(alinanSayi1:String, alinanSayi2:String){ //işlemi yapan taraf
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplam = sayi1 + sayi2
        sonuc.value = toplam.toString()//Tetikleme
    }

    fun carp(alinanSayi1:String, alinanSayi2:String){ //işlemi yapan taraf
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val carpma = sayi1 * sayi2
        sonuc.value = carpma.toString()
    }*/
}



//buradaki mantık xml tarafındaki mvvc denilen yapı ile aynı, biz compose ile uygun şeklde yapıyoruz
//okuma işlemi için livedata ile yaptıktan sonra compose yapısına uygun bir alt yapı oluşturulmalı

//her sayfanın bi viewmodeli olmalı, yaşam döngüsü ile çalışan bir yapı, farklı bir class gibi değil başka bir alt yapı ile bağlanılıyor
//her sayfayı yönetecek olan katman: viewmodeldir

//okuma işlemlerini kolaylaştırmak adına livedata kullanılacak: değer değişimi yaptığımız zaman onu okuduğumuz yere deer gönderebilir ve o değeri arayüzde göstererek çalıştırabiliriz
//livedata direkt arayüze entegre edebilecek bir okuma sağlar bize
//sadece viewmodel değil istediğn her yerde kullanabilirsin
//katmanlar arsı iletişim için tercih edilir özellikle internet taanlı işlemler içn çok yarar sağlar