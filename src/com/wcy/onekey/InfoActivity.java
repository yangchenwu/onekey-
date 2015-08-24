package com.wcy.onekey;

import com.wcy.onekey.db.Infodao;
import com.wcy.onekey.util.MyUtil;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends Activity {
	private ImageView iv_info_image,iv_info_exit;
	private EditText et_info_username,et_info_password,et_info_iconName;
	private TextView tv_info_delete,tv_info_updata;
	private Bitmap bitmap;
	private CharSequence cs3 ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_view);
		initView();
		iv_info_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});
		Intent intent = getIntent();
		if (intent != null) {
			Bundle bundle = intent.getExtras();
			CharSequence cs0 = bundle.getCharSequence("cs0");
			CharSequence cs1 = bundle.getCharSequence("cs1");
			CharSequence cs2 = bundle.getCharSequence("cs2");
			cs3	= bundle.getCharSequence("cs3");
			bitmap = bundle.getParcelable("bitmap3");
			et_info_username.setText(cs1);
			et_info_password.setText(cs2);
			et_info_iconName.setText(cs0);
			iv_info_image.setImageBitmap(bitmap);

		}
		tv_info_updata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Infodao infodao=new Infodao(InfoActivity.this);
				infodao.updata(cs3,et_info_username.getText().toString(), et_info_password.getText().toString(), et_info_iconName.getText().toString());
				MyUtil.ShowToast(InfoActivity.this, "修改成功");
				InfoActivity.this.finish();
			}
		});

		tv_info_delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Infodao infodao = new Infodao(InfoActivity.this);
				int id = infodao.delete(cs3);
				if (id > 0) {

					InfoActivity.this.finish();
				}

			}
		});
	}

	private void initView() {
		tv_info_updata=(TextView) findViewById(R.id.tv_info_sava);
		iv_info_exit = (ImageView) findViewById(R.id.iv_info_exit);
		iv_info_image = (ImageView) findViewById(R.id.iv_info_image);
		et_info_username = (EditText) findViewById(R.id.et_info_username);
		et_info_password = (EditText) findViewById(R.id.et_info_password);
		tv_info_delete = (TextView) findViewById(R.id.tv_info_delete);
		et_info_iconName = (EditText) findViewById(R.id.et_info_iconName);
	}
}
