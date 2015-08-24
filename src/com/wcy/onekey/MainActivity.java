package com.wcy.onekey;

import java.util.ArrayList;
import java.util.List;
import com.wcy.onekey.R;
import com.wcy.onekey.adapter.ListViewAdapter;
import com.wcy.onekey.bean.Info;
import com.wcy.onekey.constant.MyConstants;
import com.wcy.onekey.db.Infodao;
import com.wcy.onekey.ui.ConfirmDialog;
import com.wcy.onekey.ui.ConfirmDialog.ClickListenerInterface;
import com.wcy.onekey.ui.MyGridView;
import com.wcy.onekey.util.MyUtil;

import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ImageView iv_main_settingImageView, iv_main_exit;
	private TextView tv_main_add;
	private ListView mlistView;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		Infodao in=new Infodao(MainActivity.this);
		List<Info> ins= in.findAll();
        if(ins.size()==0){
        	final ConfirmDialog confirmDialog=new ConfirmDialog(MainActivity.this, MyConstants.ABOUT, "确定","取消");
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
		initView();
		getData();
		iv_main_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final ConfirmDialog dialog = new ConfirmDialog(
						MainActivity.this, "确定退出吗？", "确定", "取消");
				dialog.show();
				dialog.setClicklistener(new ClickListenerInterface() {

					@Override
					public void doConfirm() {
						MainActivity.this.finish();

					}

					@Override
					public void doCancel() {
						dialog.dismiss();

					}
				});
			}
		});

		tv_main_add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddActivity.class);
				startActivity(intent);

			}
		});

		iv_main_settingImageView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SettingActivity.class);
				startActivity(intent);

			}
		});

	}

	/**
	 * 从数据库获取数据
	 */
	private void getData() {
		Infodao infodao = new Infodao(MainActivity.this);
		List<Info> infos = infodao.findAll();
		
		if (infos != null) {
			ListViewAdapter listViewAdapter = new ListViewAdapter(
					MainActivity.this, infos);

			mlistView.setAdapter(listViewAdapter);
			mlistView.setOnItemClickListener(listViewAdapter);
		}

	}

	private void initView() {
		tv_main_add = (TextView) findViewById(R.id.tv_main_add);
		iv_main_settingImageView = (ImageView) findViewById(R.id.iv_main_setting);
		mlistView = (ListView) findViewById(R.id.main_listview);
		iv_main_exit = (ImageView) findViewById(R.id.iv_main_exit);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		getData();

	}

}
