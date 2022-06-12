package com.example.calculator

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class dbhelper( val context: Context? ) : SQLiteOpenHelper(context, "history", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {

        var q = "CREATE TABLE history(id INTEGER PRIMARY KEY AUTOINCREMENT,inputtext TEXT,output TEXT)"
        p0!!.execSQL(q)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertdata(inputtext: String, output: Double){
        var p0 = writableDatabase
        var contant = ContentValues()
        contant.put("inputtext", inputtext)
        contant.put("output", output)

        var res = p0.insert("history",null,contant)
        Toast.makeText(context,"$res",Toast.LENGTH_LONG).show()
    }

    @SuppressLint("Range")
    fun readdata() : List<datamodel>{

        var l1 = arrayListOf<datamodel>()
        val p0 = writableDatabase
        var que = "SELECT * FROM history"
        var cursor = p0.rawQuery(que, null)
        if (cursor.moveToFirst()){
            do {
                 var id = cursor.getString(cursor.getColumnIndex("id"))
                 var input = cursor.getString(cursor.getColumnIndex("inputtext"))
                 var output = cursor.getString(cursor.getColumnIndex("output"))

                var data = datamodel(id,input,output)
                l1.add(data)
            }while (cursor.moveToNext())
        }


        return l1
    }
}