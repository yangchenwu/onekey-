package com.wcy.onekey;

import cn.bmob.v3.listener.SaveListener;

import com.wcy.onekey.R;
import com.wcy.onekey.bean.User;
import com.wcy.onekey.util.MyUtil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends Activity {
	private EditText et_register_username;
	private EditText et_register_password;
	private EditText et_register_repassword;
	private Button bt_complete_register;
	private ImageView iv_register_exit;
	public static String ACTION_REGISTER_SUCCESS_FINISH = "register.success.finish";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_view);
		initview();
		iv_register_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});
		bt_complete_register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String username = et_register_username.getText().toString();
				String password = et_register_password.getText().toString();
				String repassword = et_register_repassword.getText().toString();

				MyUtil.ShowTag("username=" + username);

				if (TextUtils.isEmpty(username)) {
					MyUtil.ShowToast(RegisterActivity.this, "用户名不能为空");
					return;

				}
				if (TextUtils.isEmpty(password)) {
					MyUtil.ShowToast(RegisterActivity.this, "密码不能为空");
					return;
				}
				if (!password.equals(repassword)) {
					MyUtil.ShowToast(RegisterActivity.this, "两次输入的密码不一致！请重新输入");
					return;

				}

				boolean isNetConnected = MyUtil
						.isNetworkAvailable(RegisterActivity.this);
				if (!isNetConnected) {
					MyUtil.ShowToast(RegisterActivity.this, "当前网络连接不可用");
					return;
				}

				final ProgressDialog progress = new ProgressDialog(
						RegisterActivity.this);
				progress.setMessage("注册中...");
				progress.setCanceledOnTouchOutside(false);
				progress.show();
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);

				user.signUp(RegisterActivity.this, new SaveListener() {

					@Override
					public void onSuccess() {
						progress.dismiss();
						MyUtil.ShowToast(RegisterActivity.this, "注册成功");
						sendBroadcast(new Intent(ACTION_REGISTER_SUCCESS_FINISH));
						Intent intent = new Intent(RegisterActivity.this,
								MainActivity.class);
						startActivity(intent);
						finish();

					}

					@Override
					public void onFailure(int arg0, String arg1) {
						// TODO Auto-generated method stub
						MyUtil.ShowToast(RegisterActivity.this, "注册失败，换个用户名试试~");
						progress.dismiss();

					}
				});
			}
		});

	}

	private void initview() {
		et_register_username = (EditText) findViewById(R.id.et_register_username);
		et_register_password = (EditText) findViewById(R.id.et_register_password);
		et_register_repassword = (EditText) findViewById(R.id.et_register_repassword);
		bt_complete_register = (Button) findViewById(R.id.btn_complete_register);
		iv_register_exit = (ImageView) findViewById(R.id.iv_register_exit);
	}

}
