package com.wcy.onekey.adapter;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobQuery.CachePolicy;
import cn.bmob.v3.listener.GetListener;

import com.wcy.onekey.InfoActivity;
import com.wcy.onekey.R;
import com.wcy.onekey.bean.CommonInfo;
import com.wcy.onekey.bean.Info;
import com.wcy.onekey.util.MyUtil;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter implements OnItemClickListener {
	private Context context;
	private List<Info> textlist;

	public ListViewAdapter() {

	}

	public ListViewAdapter(Context context, List<Info> list) {
		this.context = context;
		this.textlist = list;

	}

	@Override
	public int getCount() {

		return textlist.size();
	}

	@Override
	public Object getItem(int position) {

		return null;
	}

	@Override
	public long getItemId(int position) {

		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_view, null);
			holder = new ViewHolder();
			holder.tv_main_name = (TextView) convertView
					.findViewById(R.id.tv_item_username);
			holder.tv_main_psw = (TextView) convertView
					.findViewById(R.id.tv_item_password);
			holder.iv_main_image = (ImageView) convertView
					.findViewById(R.id.iv_item_image);
			holder.tv_main_imageName = (TextView) convertView
					.findViewById(R.id.tv_item_imagename);
			holder.tv_main_objectId = (TextView) convertView
					.findViewById(R.id.tv_objectId);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_main_imageName.setText(textlist.get(position).getImageName());
		holder.tv_main_name.setText(textlist.get(position).getInfoName());
		holder.tv_main_psw.setText(textlist.get(position).getInfoPsw());
		holder.tv_main_objectId.setText(textlist.get(position).getImageId()+"");
		Drawable db1 = context.getResources().getDrawable(
				R.drawable.login_icon_account);
		db1.setBounds(0, 0, 40, 40);
		holder.tv_main_name.setCompoundDrawables(db1, null, null, null);
		Drawable db2 = context.getResources().getDrawable(
				R.drawable.login_icon_password);
		db2.setBounds(0, 0, 40, 40);
		holder.tv_main_psw.setCompoundDrawables(db2, null, null, null);

		holder.iv_main_image.setImageResource(R.drawable.loading);
		byte[] in=textlist.get(position).getImage();
		Bitmap bmpout = BitmapFactory.decodeByteArray(in, 0, in.length);
		holder.iv_main_image.setImageBitmap(bmpout);
		

		return convertView;
	}

	class ViewHolder {
		TextView tv_main_name;
		TextView tv_main_psw;
		ImageView iv_main_image;
		TextView tv_main_imageName;
		TextView tv_main_objectId;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position,
			long arg3) {

		TextView tv_username = (TextView) view
				.findViewById(R.id.tv_item_username);
		TextView tv_password = (TextView) view
				.findViewById(R.id.tv_item_password);
		TextView tv_imageName = (TextView) view
				.findViewById(R.id.tv_item_imagename);
		ImageView iv_image = (ImageView) view.findViewById(R.id.iv_item_image);
		TextView tv_objectId = (TextView) view.findViewById(R.id.tv_objectId);
		Intent intent = new Intent(context, InfoActivity.class);
		CharSequence cs1 = tv_username.getText();
		CharSequence cs2 = tv_password.getText();
		CharSequence cs0 = tv_imageName.getText();
		CharSequence cs3 = tv_objectId.getText();
		Bundle bundle = new Bundle();
		bundle.putCharSequence("cs0", cs0);
		bundle.putCharSequence("cs1", cs1);
		bundle.putCharSequence("cs2", cs2);
		bundle.putCharSequence("cs3", cs3);
		Drawable db3 = iv_image.getDrawable();
		Bitmap btmap3 = MyUtil.drawableToBitamp(db3); // 将Drawable转化成bitmap;
		bundle.putParcelable("bitmap3", btmap3);
		intent.putExtras(bundle);
		context.startActivity(intent);

	}

}
