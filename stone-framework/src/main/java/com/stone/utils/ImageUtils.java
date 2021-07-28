package com.stone.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 图片工具类
 */
public class ImageUtils {
	

	/**判断文件是否为图片格式
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static boolean isImgFile(MultipartFile file) {
		BufferedImage bi=null;
		try {
			bi = ImageIO.read(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return bi==null?false:true;

	}

	public static byte[] image2byte(String path){
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		}
		catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		}
		catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}

	//byte数组到图片
	public static void byte2image(byte[] data,String path){
		if(data.length<3||path.equals("")) return;
		try{
			FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			System.out.println("Make Picture success,Please find image in " + path);
		} catch(Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		}
	}

	/**
	 * 将图片写入到磁盘
	 * @param img 图片数据流
	 * @param fileName 文件保存时的名称
	 */
	public static void writeImageToDisk(byte[] img, String fileName){
		try {
			File file = new File(fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
			System.out.println("图片已经写入到本地，文件名:"+fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据地址获得数据的字节流
	 * @param strUrl 网络连接地址
	 * @return
	 */
	public static byte[] getImageFromNetByUrl(String strUrl){
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
			return btImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将图片从网上下载下来保存到磁盘
	 * @param strUrl 网络图片地址
	 * @param fileName 本地图片全路径
	 */
	public static void writePicToDiskFromWeb(String strUrl,String fileName){
		writeImageToDisk(getImageFromNetByUrl(strUrl),fileName);
	}

	/**
	 * 从输入流中获取数据
	 * @param inStream 输入流
	 * @return
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while( (len=inStream.read(buffer)) != -1 ){
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}
