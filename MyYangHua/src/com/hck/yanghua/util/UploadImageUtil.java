package com.hck.yanghua.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Tiezi;
import com.mchange.v2.log.LogUtils;

public class UploadImageUtil {
	private static final int MAX_IMAGE_SIZE = 31457280;
	private static final int XIAOTU_SIZE = 2; // 缩略图只需要2张
	private static UpLoadImageCallBack uCallBack;

	public interface UpLoadImageCallBack {
		void onSuccess(Object data, List<String> datueList);

		void onError(int type);
	}

	private static List<String> imagePaths;
	private static List<String> xiaotuImagePaths;

	public static void uploadImage(HttpServletRequest request,
			HttpServletResponse response, UpLoadImageCallBack callBack,
			Object tiezi) {
		imagePaths = new ArrayList<String>();
		xiaotuImagePaths = new ArrayList<String>();
		uCallBack = callBack;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(Contans.image_Path));
		factory.setSizeThreshold(1024 * 1024 * 100);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String fileName = null;
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.getSize() > MAX_IMAGE_SIZE) {
					System.out.println("getSize: "+item.getSize() );
					uCallBack.onError(Contans.ADD_IMAGE_ERROR_OUT_MAX_SIZE);
					return;
				}
			}
			for (FileItem item : list) {
				if (item.getName() == null) {
					continue;
				}
				String name = System.currentTimeMillis() + item.getName();
				name=name.replaceAll("%", "").trim();
				fileName = name.substring(name.lastIndexOf("\\") + 1);
				InputStream is = item.getInputStream();
				String filePath = Contans.image_Path + fileName;
				File f = new File(filePath);
				FileOutputStream fos = new FileOutputStream(f);
				int hasRead = 0;
				byte[] buf = new byte[1024];
				while ((hasRead = is.read(buf)) > 0) {
					fos.write(buf, 0, hasRead);
				}
				fos.flush();
				fos.close();
				is.close();
				imagePaths.add(fileName);
				ImageUtil.pressText(filePath);
			}
			uCallBack.onSuccess(tiezi, imagePaths);

		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.print("上传图片: "+e1.toString());
			uCallBack.onError(Contans.ADD_IMAGE_ERROR_UNKNOW);
		}

	}

}
