package com.wcy.onekey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wcy.onekey.adapter.GridAdapter;
import com.wcy.onekey.util.MyUtil;

public class AddActivity extends Activity implements OnItemClickListener {

	private GridView mGridView;

	private ImageView iv_add_exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_view);
		initview();
		 List<HashMap<String, Object>> mlist=initData();
		 mGridView.setAdapter(new GridAdapter(this, mlist));
		iv_add_exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});
		mGridView.setOnItemClickListener(this);
		// GetGridVeiwData();

	}

	private List<HashMap<String, Object>> initData() {
		List<HashMap<String, Object>>  list=new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> map0=new HashMap<String, Object>();
		map0.put("ItemImage", R.drawable._baidu);
		map0.put("Itemname", "百度帐号");
		list.add(map0);
		
		HashMap<String, Object> map1=new HashMap<String, Object>();
		map1.put("ItemImage", R.drawable._birthday);
		map1.put("Itemname", "亲朋生日");
		list.add(map1);
		
		HashMap<String, Object> map2=new HashMap<String, Object>();
		map2.put("ItemImage", R.drawable._google);
		map2.put("Itemname", "谷歌账号");
		list.add(map2);
		
		HashMap<String, Object> map3=new HashMap<String, Object>();
		map3.put("ItemImage", R.drawable._phone);
		map3.put("Itemname", "私密联系人");
		list.add(map3);
		
		HashMap<String, Object> map4=new HashMap<String, Object>();
		map4.put("ItemImage", R.drawable._phonenumber);
		map4.put("Itemname", "手机账户");
		list.add(map4);
		
		HashMap<String, Object> map5=new HashMap<String, Object>();
		map5.put("ItemImage", R.drawable._riji);
		map5.put("Itemname", "日志密码");
		list.add(map5);
		
		HashMap<String, Object> map13=new HashMap<String, Object>();
		map13.put("ItemImage", R.drawable._photo);
		map13.put("Itemname", "相册密码");
		list.add(map13);
		
		HashMap<String, Object> map6=new HashMap<String, Object>();
		map6.put("ItemImage", R.drawable._schoolcard);
		map6.put("Itemname", "校园卡");
		list.add(map6);
		
		HashMap<String, Object> map7=new HashMap<String, Object>();
		map7.put("ItemImage", R.drawable._studentcard);
		map7.put("Itemname", "学生证");
		list.add(map7);
		
		HashMap<String, Object> map8=new HashMap<String, Object>();
		map8.put("ItemImage", R.drawable._wifi);
		map8.put("Itemname", "wifi帐号");
		list.add(map8);
		
		HashMap<String, Object> map9=new HashMap<String, Object>();
		map9.put("ItemImage", R.drawable._youxiang);
		map9.put("Itemname", "邮箱");
		list.add(map9);
		
		HashMap<String, Object> map10=new HashMap<String, Object>();
		map10.put("ItemImage", R.drawable._game);
		map10.put("Itemname", "游戏帐号");
		list.add(map10);
		
		HashMap<String, Object> map11=new HashMap<String, Object>();
		map11.put("ItemImage", R.drawable._yingyong);
		map11.put("Itemname", "软件帐号");
		list.add(map11);
		
		HashMap<String, Object> map12=new HashMap<String, Object>();
		map12.put("ItemImage", R.drawable._talk);
		map12.put("Itemname", "社交帐号");
		list.add(map12);
		
		return  list;
		
	}

	private void initview() {
		mGridView = (GridView) findViewById(R.id.gv_add_content);
		iv_add_exit = (ImageView) findViewById(R.id.iv_add_exit);
	}

	// public void GetGridVeiwData() {
	//
	// query = new BmobQuery<CommonInfo>();
	// query.order("-createdAt");
	// // boolean isCache = query.hasCachedResult(AddActivity.this,
	// // CommonInfo.class);
	// // if (isCache) {
	// // // 先从缓存读取数据，如果没有，再从网络获取。
	// // query.setCachePolicy(CachePolicy.CACHE_ELSE_NETWORK);
	// // // 如果有缓存的话，则设置策略为CACHE_ELSE_NETWORK
	// //
	// // } else {
	// // // 先从网络读取数据，如果没有，再从缓存中获取
	// // query.setCachePolicy(CachePolicy.NETWORK_ELSE_CACHE);
	// // // 如果没有缓存的话，则设置策略为NETWORK_ELSE_CACHE
	// // }
	// // query.setMaxCacheAge(TimeUnit.DAYS.toMillis(360));
	// query.findObjects(AddActivity.this, new FindListener<CommonInfo>() {
	//
	// @Override
	// public void onError(int arg0, String arg1) {
	//
	// MyUtil.ShowToast(AddActivity.this, "没查到");
	//
	// }

	// @Override
	// public void onSuccess(List<CommonInfo> arg0) {
	//
	// arg = new ArrayList<CommonInfo>();
	// arg = arg0;
	// mGridView.setAdapter(new GridAdapter(AddActivity.this, arg0));
	// }
	// });
	//
	// }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		if (position == parent.getCount() - 1) {
			Intent intent = new Intent(AddActivity.this, EditActivity.class);
			
			ImageView iv = (ImageView) view.findViewById(R.id.img_grid_item);
			Bundle bundle = new Bundle();
			Drawable db2 = iv.getDrawable();
			Bitmap btmap = MyUtil.drawableToBitamp(db2); // 将Drawable转化成bitmap;
			bundle.putParcelable("bitmap", btmap);
			intent.putExtras(bundle);
			startActivity(intent);

		} else {

			Intent intent = new Intent(AddActivity.this, EditActivity.class);
			ImageView iv = (ImageView) view.findViewById(R.id.img_grid_item);
			TextView tv = (TextView) view.findViewById(R.id.tv_grid_item);
			Bundle bundle = new Bundle();

			CharSequence cs = tv.getText();

			bundle.putCharSequence("cs", cs);
			Drawable db2 = iv.getDrawable();
			Bitmap btmap = MyUtil.drawableToBitamp(db2); // 将Drawable转化成bitmap;
			bundle.putParcelable("bitmap", btmap);
			intent.putExtras(bundle);
			startActivity(intent);
		}

	}

}
