package com.wcy.onekey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wcy.onekey.ui.ConfirmDialog;
import com.wcy.onekey.ui.ConfirmDialog.ClickListenerInterface;
import com.wcy.onekey.util.MyUtil;

import e.i;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class welcomeActivity extends Activity {
	private boolean firstIn;
	private Button bt_welcome_savaButton;
	private EditText et1, et2, et3, et4, et5, et6;
	private String reallyPSW, current,onekeyString;
	private CharSequence temp;
	private TextView tv_welcome_title;
	private GridView gv_keyboard;
	private SimpleAdapter simpleAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
		firstIn = sp.getBoolean("firstIn", true);
		reallyPSW = sp.getString("onekeyPSA", "");

		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("number", i);
			datas.add(data);
		}
		// 没有设置密码第一次进入 直接进入Mainactivity
		if (firstIn) {
			setContentView(R.layout.welocme_view);
			initView();

			simpleAdapter = new SimpleAdapter(this, datas,
					R.layout.keyboard_item, new String[] { "number" },
					new int[] { R.id.bt_keyboard });
			gv_keyboard.setAdapter(simpleAdapter);
			gv_keyboard.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					if (TextUtils.isEmpty(et1.getText())) {
						et1.setText(position + "");
					} else if (TextUtils.isEmpty(et2.getText())) {
						et2.setText(position + "");
					} else if (TextUtils.isEmpty(et3.getText())) {
						et3.setText(position + "");
					} else if (TextUtils.isEmpty(et4.getText())) {
						et4.setText(position + "");
					} else if (TextUtils.isEmpty(et5.getText())) {
						et5.setText(position + "");
					} else if (TextUtils.isEmpty(et6.getText())) {
						et6.setText(position + "");
					}

				}
			});

			tv_welcome_title.setText("请设置6位纯数字密码并妥善保管");
			// 设置过密码 直接进入密码输入的界面
		} else {
			setContentView(R.layout.welocme_view);
			initView();
			simpleAdapter = new SimpleAdapter(this, datas,
					R.layout.keyboard_item, new String[] { "number" },
					new int[] { R.id.bt_keyboard });
			gv_keyboard.setAdapter(simpleAdapter);
			gv_keyboard.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					if (TextUtils.isEmpty(et1.getText())) {
						et1.setText(position + "");
					} else if (TextUtils.isEmpty(et2.getText())) {
						et2.setText(position + "");
					} else if (TextUtils.isEmpty(et3.getText())) {
						et3.setText(position + "");
					} else if (TextUtils.isEmpty(et4.getText())) {
						et4.setText(position + "");
					} else if (TextUtils.isEmpty(et5.getText())) {
						et5.setText(position + "");
					} else if (TextUtils.isEmpty(et6.getText())) {
						et6.setText(position + "");
					}


				}
			});
			bt_welcome_savaButton.setVisibility(View.INVISIBLE);

		}
	}

	private void initView() {
		bt_welcome_savaButton = (Button) findViewById(R.id.bt_welcome_sava);
		et1 = (EditText) findViewById(R.id.et_welcome_onekey1);
		et2 = (EditText) findViewById(R.id.et_welcome_onekey2);
		et3 = (EditText) findViewById(R.id.et_welcome_onekey3);
		et4 = (EditText) findViewById(R.id.et_welcome_onekey4);
		et5 = (EditText) findViewById(R.id.et_welcome_onekey5);
		et6 = (EditText) findViewById(R.id.et_welcome_onekey6);
		tv_welcome_title = (TextView) findViewById(R.id.tv_welcome_title);
		gv_keyboard = (GridView) findViewById(R.id.gv_keyboard);
		et6.addTextChangedListener(watcher6);
		et5.addTextChangedListener(watcher5);
		et4.addTextChangedListener(watcher4);
		et3.addTextChangedListener(watcher3);
		et2.addTextChangedListener(watcher2);
		et1.addTextChangedListener(watcher1);
	}

	private TextWatcher watcher1 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

			temp = s;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (s.length() == 1) {

				et1.clearFocus();
				et2.setFocusable(true);
				et2.requestFocus();
			}

			String e1 = et1.getText().toString();
			String e2 = et2.getText().toString();
			String e3 = et3.getText().toString();
			String e4 = et4.getText().toString();
			String e5 = et5.getText().toString();
			String e6 = et6.getText().toString();

			current = e1 + e2 + e3 + e4 + e5 + e6;

		}
	};
	private TextWatcher watcher2 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

			temp = s;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (s.length() == 1) {

				et2.clearFocus();
				et3.setFocusable(true);
				et3.requestFocus();
				
			}

			String e1 = et1.getText().toString();
			String e2 = et2.getText().toString();
			String e3 = et3.getText().toString();
			String e4 = et4.getText().toString();
			String e5 = et5.getText().toString();
			String e6 = et6.getText().toString();

			current = e1 + e2 + e3 + e4 + e5 + e6;

		}
	};

	private TextWatcher watcher3 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

			temp = s;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (s.length() == 1) {

				et3.clearFocus();
				et4.setFocusable(true);
				et4.requestFocus();

			}

			String e1 = et1.getText().toString();
			String e2 = et2.getText().toString();
			String e3 = et3.getText().toString();
			String e4 = et4.getText().toString();
			String e5 = et5.getText().toString();
			String e6 = et6.getText().toString();

			current = e1 + e2 + e3 + e4 + e5 + e6;

		}
	};

	private TextWatcher watcher4 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

			temp = s;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (s.length() == 1) {

				et4.clearFocus();
				et5.setFocusable(true);
				et5.requestFocus();
			}

			String e1 = et1.getText().toString();
			String e2 = et2.getText().toString();
			String e3 = et3.getText().toString();
			String e4 = et4.getText().toString();
			String e5 = et5.getText().toString();
			String e6 = et6.getText().toString();

			current = e1 + e2 + e3 + e4 + e5 + e6;

		}
	};

	private TextWatcher watcher5 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

			temp = s;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (s.length() == 1) {

				et5.clearFocus();
				et6.setFocusable(true);
				et6.requestFocus();
			}

			String e1 = et1.getText().toString();
			String e2 = et2.getText().toString();
			String e3 = et3.getText().toString();
			String e4 = et4.getText().toString();
			String e5 = et5.getText().toString();
			String e6 = et6.getText().toString();

			current = e1 + e2 + e3 + e4 + e5 + e6;

		}
	};

	private TextWatcher watcher6 = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {

			temp = s;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (s.length() == 1) {

				et6.clearFocus();
			}

			String e1 = et1.getText().toString();
			String e2 = et2.getText().toString();
			String e3 = et3.getText().toString();
			String e4 = et4.getText().toString();
			String e5 = et5.getText().toString();
			String e6 = et6.getText().toString();

			current = e1 + e2 + e3 + e4 + e5 + e6;
			if (firstIn) {
				bt_welcome_savaButton
						.setOnClickListener(new View.OnClickListener() {

							@Override
							public void onClick(View v) {
								final ConfirmDialog confirmDialog=new ConfirmDialog(welcomeActivity.this, "确定保存密码？", "是","否");
								confirmDialog.show();
								confirmDialog.setClicklistener(new ClickListenerInterface() {
									
									@Override
									public void doConfirm() {

										confirmDialog.dismiss();
										String e1 = et1.getText().toString();
										String e2 = et2.getText().toString();
										String e3 = et3.getText().toString();
										String e4 = et4.getText().toString();
										String e5 = et5.getText().toString();
										String e6 = et6.getText().toString();
										onekeyString = e1 + e2 + e3 + e4 + e5 + e6;
										firstIn = false;
										SharedPreferences sp = getSharedPreferences(
												"config", MODE_PRIVATE);
										Editor et = sp.edit();
										et.putString("onekeyPSA", onekeyString);
										et.putBoolean("firstIn", firstIn);
										et.commit();
										MyUtil.ShowToast(welcomeActivity.this, "密码设置成功");
										MyUtil.startActivityAndFinish(
												welcomeActivity.this,
												welcomeActivity.class);
									
										
									}
									
									@Override
									public void doCancel() {
										et1.setText("");
										et2.setText("");
										et3.setText("");
										et4.setText("");
										et5.setText("");
										et6.setText("");
										et1.setFocusable(true);
										et1.setFocusableInTouchMode(true); 
										et1.requestFocus();
										confirmDialog.dismiss();
										
									}
								});
							}
						});
			}
			// 检查密码
			else if (current.length() == 6) {
				checkCurrentPSW(current);
			}
		}
	};

	/*
	 * 检查密码
	 */
	protected void checkCurrentPSW(String key) {
		if (!TextUtils.isEmpty(key)) {
			if (key.equals(reallyPSW)) {

				MyUtil.startActivityAndFinish(welcomeActivity.this,
						MainActivity.class);
			} else {
				MyUtil.ShowToast(welcomeActivity.this, "密码错误,亲重新输入");
				et1.setText("");
				et2.setText("");
				et3.setText("");
				et4.setText("");
				et5.setText("");
				et6.setText("");
			}
		}
		et1.setFocusable(true);
		et1.setFocusableInTouchMode(true);
		et1.requestFocus();

	}

}
