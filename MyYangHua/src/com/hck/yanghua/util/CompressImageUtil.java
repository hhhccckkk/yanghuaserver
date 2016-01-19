package com.hck.yanghua.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/*******************************************************************************
 * ����ͼ�ࣨͨ�ã� ��java���ܽ�jpg��bmp��png��gifͼƬ�ļ������еȱȻ�ǵȱȵĴ�Сת���� ����ʹ�÷���
 * compressPic(��ͼƬ·��,����СͼƬ·��,��ͼƬ�ļ���,����СͼƬ����,����СͼƬ���,����СͼƬ�߶�,�Ƿ�ȱ�����(Ĭ��Ϊtrue))
 */
 public class CompressImageUtil { 
	 private File file = null; // �ļ����� 
	 private String inputDir; // ����ͼ·��
	 private String outputDir; // ���ͼ·��
	 private String inputFileName; // ����ͼ�ļ���
	 private String outputFileName; // ���ͼ�ļ���
	 private int outputWidth = 100; // Ĭ�����ͼƬ��
	 private int outputHeight = 100; // Ĭ�����ͼƬ��
	 private boolean proportion = true; // �Ƿ�ȱ����ű��(Ĭ��Ϊ�ȱ�����)
	 public void setInputDir(String inputDir) { 
		 this.inputDir = inputDir; 
	 } 
	 public void setOutputDir(String outputDir) { 
		 this.outputDir = outputDir; 
	 } 
	 public void setInputFileName(String inputFileName) { 
		 this.inputFileName = inputFileName;
	 } 
	 public void setOutputFileName(String outputFileName) { 
		 this.outputFileName = outputFileName; 
	 } 
	 public void setOutputWidth(int outputWidth) {
		 this.outputWidth = outputWidth; 
	 } 
	 public void setOutputHeight(int outputHeight) { 
		 this.outputHeight = outputHeight; 
	 } 
	 public void setWidthAndHeight(int width, int height) { 
		 this.outputWidth = width;
		 this.outputHeight = height; 
	 } 
	 
	 /* 
	  * ���ͼƬ��С 
	  * ������� String path ��ͼƬ·�� 
	  */ 
	 public long getPicSize(String path) { 
		 file = new File(path); 
		 return file.length(); 
	 }
	 
	 // ͼƬ���� 
	 public boolean compressPic() { 
		 try { 
			 //���Դ�ļ� 
			 file = new File(inputDir + inputFileName); 
			 if (!file.exists()) { 
				 return false;
			 } 
			 Image img = ImageIO.read(file); 
			 // �ж�ͼƬ��ʽ�Ƿ���ȷ 
			 if (img.getWidth(null) == -1) {
				 System.out.println(" can't read,retry!" + "<BR>"); 
				 return false;
			 } else { 
				 int newWidth; int newHeight; 
				 // �ж��Ƿ��ǵȱ����� 
				 if (this.proportion == true) { 
					 // Ϊ�ȱ����ż��������ͼƬ��ȼ��߶� 
					 double rate1 = ((double) img.getWidth(null)) / (double) outputWidth + 0.1; 
					 double rate2 = ((double) img.getHeight(null)) / (double) outputHeight + 0.1; 
					 // �������ű��ʴ�Ľ������ſ��� 
					 double rate = rate1 > rate2 ? rate1 : rate2; 
					 newWidth = (int) (((double) img.getWidth(null)) / rate); 
					 newHeight = (int) (((double) img.getHeight(null)) / rate); 
				 } else { 
					 newWidth = outputWidth; // �����ͼƬ��� 
					 newHeight = outputHeight; // �����ͼƬ�߶� 
				 } 
			 	BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB); 
			 	
			 	/*
				 * Image.SCALE_SMOOTH �������㷨 ��������ͼƬ��ƽ���ȵ�
				 * ���ȼ����ٶȸ� ���ɵ�ͼƬ�����ȽϺ� ���ٶ���
				 */ 
			 	tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
			 	FileOutputStream out = new FileOutputStream(outputDir + outputFileName);
			 	// JPEGImageEncoder������������ͼƬ���͵�ת�� 
			 	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			 	encoder.encode(tag); 
			 	out.close(); 
			 } 
		 } catch (IOException ex) { 
			 ex.printStackTrace(); 
			 return false;
		 } 
		 return true;
	} 
 	public boolean compressPic (String inputDir, String outputDir, String inputFileName, String outputFileName) { 
 		// ����ͼ·�� 
 		this.inputDir = inputDir; 
 		// ���ͼ·�� 
 		this.outputDir = outputDir; 
 		// ����ͼ�ļ��� 
 		this.inputFileName = inputFileName; 
 		// ���ͼ�ļ���
 		this.outputFileName = outputFileName; 
 		return compressPic(); 
 	} 
 	public boolean compressPic(String inputDir, String outputDir, String inputFileName, String outputFileName, int width, int height, boolean gp) { 
 		// ����ͼ·�� 
 		this.inputDir = inputDir; 
 		// ���ͼ·�� 
 		this.outputDir = outputDir; 
 		// ����ͼ�ļ��� 
 		this.inputFileName = inputFileName; 
 		// ���ͼ�ļ��� 
 		this.outputFileName = outputFileName; 
 		// ����ͼƬ����
 		setWidthAndHeight(width, height); 
 		// �Ƿ��ǵȱ����� ��� 
 		this.proportion = gp; 
 		return compressPic(); 
 	} 
 	
 	
 }
