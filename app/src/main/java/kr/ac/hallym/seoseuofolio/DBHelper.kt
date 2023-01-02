package kr.ac.hallym.seoseuofolio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kr.ac.hallym.seoseuofolio.databinding.ActivityDmAddBinding
import kr.ac.hallym.seoseuofolio.databinding.ActivityMainBinding

class DBHelper(context: Context) : SQLiteOpenHelper(context,"test.db",null,1) {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("create table if not exists TODO_TB(" +
                "_id integer primary key autoincrement, " +
                "title not null, " +
                "detail)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}


class ProjectDBHelper(context: Context) : SQLiteOpenHelper(context,"PROJECT.db",null,1) {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("create table if not exists PRO_TB(" +
                "_id integer primary key autoincrement, " +
                "image ," +
                "title not null, " +
                "detail ," +
                "link)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}