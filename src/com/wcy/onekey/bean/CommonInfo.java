package com.wcy.onekey.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class CommonInfo  extends BmobObject{
	BmobFile imageIcon;
	String iconName;
	public BmobFile getImageIcon() {
		return imageIcon;
	}
	public void setImageIcon(BmobFile imageIcon) {
		this.imageIcon = imageIcon;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

}
