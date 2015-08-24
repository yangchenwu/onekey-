package com.wcy.onekey.db;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wcy.onekey.bean.Info;

/*
 * 数据库的增删改查
 */
public class Infodao {
	private InfoSQLiteOpenHelper helper;

	public Infodao(Context context) {
		helper = new InfoSQLiteOpenHelper(context);

	}

	public long add(String username, String password, String imageName,
			byte[] img) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("username", username);
		cv.put("password", password);
		cv.put("imagename", imageName);
		cv.put("image", img);

		long id = db.insert("info", null, cv);
		db.close();
		return id;

	}
	
	public void updata(CharSequence id,String username,String password, String imageName){
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("username", username);
		cv.put("password", password);
		cv.put("imagename", imageName);
		db.update("info", cv, "id=?", new String[]{id.toString()});
	}

	public boolean find(String imageName) {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query("info", null, "imagename=?",
				new String[] { imageName }, null, null, null);
		boolean result = cursor.moveToNext();
		cursor.close();
		db.close();
		return result;

	}

	public int delete(CharSequence id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		int number = db.delete("info", "id=?", new String[] { id.toString() });
		db.close();
		return number;

	}

	public List<Info> findAll() {
		SQLiteDatabase db = helper.getReadableDatabase();
		List<Info> infos = new ArrayList<Info>();
		Cursor cursor = db.query("info", new String[] { "id", "username",
				"password", "imagename", "image" }, null, null, null, null,
				null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));

			String username = cursor.getString(cursor
					.getColumnIndex("username"));
			String password = cursor.getString(cursor
					.getColumnIndex("password"));
			String imagename = cursor.getString(cursor
					.getColumnIndex("imagename"));

			byte[] in = cursor.getBlob(cursor.getColumnIndex("image"));
			Info info = new Info(id, username, password, imagename, in);
			infos.add(info);
		}
		cursor.close();
		db.close();
		return infos;
	}

}
