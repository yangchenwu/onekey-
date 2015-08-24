package com.wcy.onekey;

import cn.bmob.v3.listener.SaveListener;

import com.wcy.onekey.bean.User;
import com.wcy.onekey.util.MyUtil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends Activity implements OnClickListener {
	private Button bt_login, bt_register;
	private EditText et_password, et_username;

	private ImageView iv_login_exit;

	@Override
	protected void onDestroy() {

		super.onDestroy();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_view);
		initview();

		bt_login.setOnClickListener(this);

		iv_login_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				LoginActivity.this.finish();

			}
		});
		bt_register.setOnClickListener(this);

	}

	private void initview() {
		et_password = (EditText) findViewById(R.id.et_login_password);
		et_username = (EditText) findViewById(R.id.et_login_usernama);
		bt_register = (Button) findViewById(R.id.btn_register);
		iv_login_exit = (ImageView) findViewById(R.id.iv_login_exit);
		bt_login = (Button) findViewById(R.id.btn_login);
	}

	@Override
	public void onClick(View v) {
		if (v == bt_register) {
			Intent intent = new Intent(LoginActivity.this,
					RegisterActivity.class);
			startActivity(intent);
		} else {
			boolean isNetConnected = MyUtil.isNetworkAvailable(this);
			if (!isNetConnected) {
				MyUtil.ShowToast(LoginActivity.this, "网络连接不可用");
				return;
			}
			login();

		}
	}

	private void login() {
		String username = et_username.getText().toString();
		String password = et_password.getText().toString();

		if (TextUtils.isEmpty(username)) {
			MyUtil.ShowToast(LoginActivity.this, "用户名不能为空");
			return;
		}

		if (TextUtils.isEmpty(password)) {
			MyUtil.ShowToast(LoginActivity.this, "密码不能为空");
			return;
		}

		final ProgressDialog progress = new ProgressDialog(LoginActivity.this);
		progress.setMessage("登录中...");
		progress.setCanceledOnTouchOutside(false);
		progress.show();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		user.login(this, new SaveListener() {

			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				MyUtil.ShowToast(LoginActivity.this, "登录成功");
				progress.dismiss();
				Intent intent = new Intent(LoginActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();

			}

			@Override
			public void onFailure(int arg0, String arg1) {
				MyUtil.ShowToast(LoginActivity.this, "登录失败");
				progress.dismiss();

			}
		});

	}

}
