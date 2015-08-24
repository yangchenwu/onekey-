package com.wcy.onekey.adapter;

import java.util.HashMap;
import java.util.List;
import com.wcy.onekey.R;
import com.wcy.onekey.bean.CommonInfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

	private Context mContext;
	private List<HashMap<String, Object>> mlist;

	public GridAdapter(Context context, List<HashMap<String, Object>> list) {
		this.mContext = context;
		this.mlist = list;
	}

	@Override
	public int getCount() {
		return mlist.size() + 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.grid_item, null);
			holder = new ViewHolder();
			holder.iconName = (TextView) convertView
					.findViewById(R.id.tv_grid_item);
			holder.imageIcon = (ImageView) convertView
					.findViewById(R.id.img_grid_item);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (position < mlist.size()) {
			HashMap<String, Object> itemHashMap = mlist.get(position);
			holder.iconName.setText(itemHashMap.get("Itemname").toString());
			holder.imageIcon.setImageResource(Integer.parseInt(itemHashMap.get(
					"ItemImage").toString()));
		} else {
			holder.iconName.setText("更多");
			holder.imageIcon.setImageResource(R.drawable.add_image);
		}

		return convertView;
	}

	public class ViewHolder {
		private ImageView imageIcon;
		private TextView iconName;
	}

}
