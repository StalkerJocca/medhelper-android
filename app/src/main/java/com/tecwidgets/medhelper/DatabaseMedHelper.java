package com.tecwidgets.medhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by João Costa on 07/02/2017.
 */

public class DatabaseMedHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "pacientes.db";
    public static final String TABLE_NAME = "pacientes_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "FOTO";
    public static final String COL_3 = "NOME";
    public static final String COL_4 = "IDADE";
    public static final String COL_5 = "DATANASCIMENTO";
    public static final String COL_6 = "GENERO";
    public static final String COL_7 = "NACIONALIDADE";
    public static final String COL_8 = "ALTURA";
    public static final String COL_9 = "PESO";
    public static final String COL_10 = "DESCRICAO";

    public DatabaseMedHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table \" + TABLE_NAME +\" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FOTO BLOB, NOME TEXT, IDADE INTEGER, DATANASCIMENTO INTEGER, GENERO TEXT, NACIONALIDADE TEXT, ALTURA INTEGER, PESO INTEGER, DESCRICAO TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
