package com.wcy.onekey.bean;

import android.R.integer;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Info extends BmobObject{
	private String imageName;
	private String infoName;
	private String infoPsw;
	private User owner;
	private  BmobFile infoImage;
	private int imageId;
	
	

	
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	private byte[] image;
	
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Info(int id,String infoname,String infopassword,String imagename, byte[] images) {
		imageName=imagename;
		infoName=infoname;
		infoPsw=infopassword;
		this.image=images;
		this.imageId=id;
	}
	
	public Info() {
	
	}
    
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public BmobFile getInfoImage() {
		return infoImage;
	}
	public void setInfoImage(BmobFile infoImage) {
		this.infoImage = infoImage;
	}
	
	public BmobFile getInfoImageBmobFile() {
		return infoImage;
	}
	public void setInfoImageBmobFile(BmobFile infoImageBmobFile) {
		this.infoImage = infoImageBmobFile;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getInfoPsw() {
		return infoPsw;
	}
	public void setInfoPsw(String infoPsw) {
		this.infoPsw = infoPsw;
	}
	

}
