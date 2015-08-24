package com.wcy.onekey;

import com.wcy.onekey.constant.MyConstants;
import com.wcy.onekey.ui.ConfirmDialog;
import com.wcy.onekey.ui.ConfirmDialog.ClickListenerInterface;
import com.wcy.onekey.util.MyUtil;

import cn.bmob.v3.BmobUser;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class SettingActivity extends Activity {
	private Button bt_setting_exit_longinButton,bt_setting_about,bt_setting_commit;
	private ImageView iv_setting_exit;
	private ToggleButton tb;

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_view);
		initview();
		
		
		tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				SharedPreferences spPreferences;
				if(isChecked){
					startActivity(new Intent(SettingActivity.this,welcomeActivity.class));
					buttonView.setClickable(isChecked);
					  spPreferences= getSharedPreferences("config", MODE_PRIVATE);
					Editor editor = spPreferences.edit();
					editor.putBoolean("ischeked", isChecked);
					editor.commit();
				}if(!isChecked){
					MyUtil.ShowToast(SettingActivity.this, "您关闭了数字密码");
					 spPreferences= getSharedPreferences("config", MODE_PRIVATE);
					 Editor editor = spPreferences.edit();
					
					 editor.clear();
					 editor.commit();
				}
				
			}
		});
		
		bt_setting_commit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MyUtil.ShowToast(SettingActivity.this, "暂时无更新");

			}
		});
		iv_setting_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				SettingActivity.this.finish();

			}
		});
		bt_setting_about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			final ConfirmDialog confirmDialog=new ConfirmDialog(SettingActivity.this, MyConstants.ABOUT, "确定","取消");
			confirmDialog.show();
			confirmDialog.setClicklistener(new ClickListenerInterface() {
				
				@Override
				public void doConfirm() {
					confirmDialog.dismiss();
					
				}
				
				@Override
				public void doCancel() {
					confirmDialog.dismiss();
					
				}
			});
			}
		});
			
		
		bt_setting_exit_longinButton
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						final ConfirmDialog cDialog = new ConfirmDialog(
								SettingActivity.this, "确定退出登录吗", "确定", "取消");
						cDialog.show();
						cDialog.setClicklistener(new ClickListenerInterface() {

							@Override
							public void doConfirm() {
								BmobUser.logOut(SettingActivity.this);

								MyUtil.startActivityAndFinish(
										SettingActivity.this,
										LoginActivity.class);

							}

							@Override
							public void doCancel() {
								cDialog.dismiss();

							}
						});

					}
				});
	}

	private void initview() {
		tb=(ToggleButton) findViewById(R.id.toggleButton1);
		bt_setting_about=(Button) findViewById(R.id.bt_setting_about);
		iv_setting_exit = (ImageView) findViewById(R.id.iv_setting_exit);
		bt_setting_commit = (Button) findViewById(R.id.bt_setting_commit);
		bt_setting_exit_longinButton = (Button) findViewById(R.id.bt_setting_exit_login);
	 SharedPreferences spPreferences= getSharedPreferences("config", MODE_PRIVATE);
		tb.setChecked(spPreferences.getBoolean("ischeked", false));
	}

}
