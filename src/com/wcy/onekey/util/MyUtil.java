package com.wcy.onekey.util;

import a.This;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class MyUtil extends Activity {
	
	
	public final static String TAG="tag";
	public static void ShowTag(String message){
		Log.v(TAG, message);
		
	}

	public static void ShowToast(Context context,String str){
		Toast.makeText(context, str, 0).show();
	
	}
	
	/** ����Ƿ������� */
	public static boolean isNetworkAvailable(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if (info != null) {
			return info.isAvailable();
		}
		return false;
	}
	private static NetworkInfo getNetworkInfo(Context context) {

		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo();
	}
	 /** 
     * �����µ�activity ���ҹرյ��Լ� 
     */ 
	public static void startActivityAndFinish(Activity context, Class<?> cls){  
        Intent intent = new Intent(context,cls);  
        context.startActivity(intent);  
        context.finish();  
    }  
       
       
    /** 
     * �����µ�activity  
     */ 
    public static void startActivity(Activity context, Class<?> cls){  
        Intent intent = new Intent(context,cls);  
        context.startActivity(intent);  
    }  
    
    public static Bitmap drawableToBitamp(Drawable drawable) {
		BitmapDrawable bd = (BitmapDrawable) drawable;
		Bitmap bitmap = bd.getBitmap();
		return bitmap;
	}
   


}
