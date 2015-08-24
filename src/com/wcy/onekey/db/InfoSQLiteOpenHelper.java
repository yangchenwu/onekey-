package com.wcy.onekey.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * 创建数据库
 */

public class InfoSQLiteOpenHelper extends SQLiteOpenHelper {
	InfoSQLiteOpenHelper helper;
	
	
/**
 * 构造方法
 * @param context
 */
	public InfoSQLiteOpenHelper(Context context) {
		super(context, "info.db", null, 3);
	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	//初始化表结构 
		db.execSQL("create table info (id integer primary key autoincrement, username varchar(20), password varchar(20), imagename varchar(20) ,image blob(100))");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("create table info (id integer primary key autoincrement, username varchar(20), password varchar(20), imagename varchar(20) ,image blob(100))");

	}

}
