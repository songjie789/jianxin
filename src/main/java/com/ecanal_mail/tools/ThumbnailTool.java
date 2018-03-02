package com.ecanal_mail.tools;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

//缩略图生成类
public class ThumbnailTool {
	
	public static String getThumbnail(HttpServletRequest request,String picture) throws IOException{
		//获取服务器网址
		String path = BasePage.getBasePage(request);
		String basepath = request.getServletContext().getRealPath("");	//获取系统运行路径
		basepath = basepath.replaceAll("\\\\", "/");					//字符转换
		basepath = basepath.replace("/e_canal/", "");					//去掉项目名
		picture = picture.replace(path, "");
		if(!(picture.contains("/e_canal"))){
			picture = "/e_canal"+picture;
		}
		File file = new File(basepath + picture);						//打开图片文件
		String picturename = file.getName();
		String thpicture = "thum" + picturename;						//给缩略图加上前缀
		String picture2 = picture.replace(picturename, "");
		picture2 = picture2 + thpicture;
		Thumbnails.of(file).size(320,320).toFile(basepath + picture2);
		return path+picture2;
	}
	
	public static String getThumbnailByWidthAndHeighr(HttpServletRequest request,String picture,int width,int height) throws IOException{
		//获取服务器网址
		String path = BasePage.getBasePage(request);
		System.out.println(path);
		String basepath = request.getServletContext().getRealPath("");	//获取系统运行路径
		basepath = basepath.replaceAll("\\\\", "/");					//字符转换
		basepath = basepath.replace("/e_canal/", "");					//去掉项目名
		picture = picture.replace(path, "");
		if(!(picture.contains("/e_canal"))){
			picture = "/e_canal"+picture;
		}
		File file = new File(basepath + picture);						//打开图片文件
		String picturename = file.getName();
		String thpicture = "thum" + picturename;						//给缩略图加上前缀
		String picture2 = picture.replace(picturename, "");
		picture2 = picture2 + thpicture;
		Thumbnails.of(file).size(width,height).toFile(basepath + picture2);
		return path+picture2;
	}
}
