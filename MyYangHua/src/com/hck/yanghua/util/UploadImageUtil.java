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

public class UploadImageUtil {
	private List<String> imagePaths=new ArrayList<String>();
	public List<String> uploadImage(HttpServletRequest request,
			HttpServletResponse response) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(Contans.image_Path));
		factory.setSizeThreshold(1024 * 1024 * 100);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String fileName=null;
		try {
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			for (FileItem item : list) {
				String name = System.currentTimeMillis() + item.getName();
				fileName= name.substring(name.lastIndexOf("\\") + 1);
				InputStream is = item.getInputStream();
				File f = new File(Contans.image_Path + fileName);
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
			}
			
			return imagePaths;

		} catch (Exception e1) {
			e1.printStackTrace();
			return imagePaths;
		}

	}

}
