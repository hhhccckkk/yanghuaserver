package com.hck.yanghua.phoneaction;

import java.util.List;

import com.hck.yanghua.util.UploadImageUtil;

public class ImageTest extends BaseAction {
	private UploadImageUtil uploadImageUtil;
	private List<String> imagePath;

	public void addImage() {
		init();
		uploadImageUtil = new UploadImageUtil();
		imagePath = uploadImageUtil.uploadImage(request, response);
		if (imagePath != null) {
             
		}

	}

}





