package com.wcy.onekey;

import java.io.ByteArrayOutputStream;

import com.wcy.onekey.db.Infodao;
import com.wcy.onekey.util.MyUtil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditActivity extends Activity {
	private ImageView iv_deit_image, iv_edit_exit;
	private EditText et_edit_imageName, et_edit_username, et_edit_password;
	private TextView tv_edit_savaInfo;
	private Bitmap bitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_view);

		InitView(); // 初始化View
		savainfoBySQL(); // 点击保存按钮 保存信息
		iv_edit_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();// 从AddActivit获得的Bundle；

		if (bundle != null) {
			bitmap = bundle.getParcelable("bitmap");
			CharSequence Name = bundle.getCharSequence("cs");
			iv_deit_image.setImageBitmap(bitmap);
			et_edit_imageName.setText(Name);
			bundle.clear();
		}
	}

	private void savainfoBySQL() {
		tv_edit_savaInfo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Infodao infodao = new Infodao(EditActivity.this);
				String username = et_edit_username.getText().toString();
				String password = et_edit_password.getText().toString();
				String name = et_edit_imageName.getText().toString();

				byte[] in = img(bitmap);
				long id = infodao.add(username, password, name, in);
				if (id > 0) {
					MyUtil.ShowToast(EditActivity.this, "保存成功");
				}
				EditActivity.this.finish();

			}
		});

	}

	private void InitView() {
		iv_edit_exit = (ImageView) findViewById(R.id.iv_edit_exit);
		iv_deit_image = (ImageView) findViewById(R.id.iv_edit_image);
		et_edit_imageName = (EditText) findViewById(R.id.et_edit_iconName);
		et_edit_username = (EditText) findViewById(R.id.et_edit_username);
		et_edit_password = (EditText) findViewById(R.id.et_edit_password);
		tv_edit_savaInfo = (TextView) findViewById(R.id.tv_edit_sava);

	}

	public byte[] img(Bitmap bitmap) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
		return baos.toByteArray();

	}
}
