package com.canbayazit.sozlukuygulamasi

import android.annotation.SuppressLint

class Kelimelerdao {


    @SuppressLint("Range")
    fun tumKelimeler(vt:VeriTabaniYardimcisi): ArrayList<Kelimeler>{

        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler",null)

        while (c.moveToNext()){


            val kelime = Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("ingilizce")),
                c.getString(c.getColumnIndex("turkce")))
            kelimelerListe.add(kelime)

        }
return kelimelerListe
    }


    @SuppressLint("Range")
    fun aramaYap(vt:VeriTabaniYardimcisi,aramaKelime:String): ArrayList<Kelimeler>{

        val kelimelerListe = ArrayList<Kelimeler>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$aramaKelime%'",null)

        while (c.moveToNext()){


            val kelime = Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("ingilizce")),
                c.getString(c.getColumnIndex("turkce")))
            kelimelerListe.add(kelime)

        }
        return kelimelerListe
    }



}