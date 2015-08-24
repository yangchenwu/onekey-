package com.wcy.onekey;

import com.wcy.onekey.constant.MyConstants;
import com.wcy.onekey.ui.ConfirmDialog;
import com.wcy.onekey.ui.ConfirmDialog.ClickListenerInterface;
import com.wcy.onekey.util.MyUtil;

import android.R.bool;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	private final static int GO_HOME = 100;

	private static final int GO_WELCOME = 200;
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GO_HOME:
				MyUtil.startActivityAndFinish(SplashActivity.this,
						MainActivity.class);

				break;
			case GO_WELCOME:
				MyUtil.startActivityAndFinish(SplashActivity.this,
						welcomeActivity.class);

			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_view);
		SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
		boolean firstIn = sp.getBoolean("firstIn", true);
		if (firstIn) {
			
			handler.sendEmptyMessageDelayed(GO_HOME, 2000);
		} else {
			handler.sendEmptyMessageDelayed(GO_WELCOME, 2000);
		}

	}
}
