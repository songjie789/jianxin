package com.ecanal_mail.tools;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	public static String uploadFile(HttpServletRequest request, MultipartFile[] file)
			throws IllegalStateException, IOException {
		// 图片显示地址
		String saveUrl = "";
		// 如果文件不为空，写入上传路径
		for (int i = 0; i < file.length; i++) {
			String url = null;
			if (!file[i].isEmpty()) {
				url = BasePage.getBasePage(request) + request.getContextPath() + "/upload/";
				// 定义允许上传的文件扩展名
				HashMap<String, String> extMap = new HashMap<String, String>();
				extMap.put("image", "gif,jpg,jpeg,png,bmp,ico");
				extMap.put("flash", "swf,flv");
				extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
				extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
				extMap.put("software", "apk,exe");
				// 获取文件名
				String fileName = file[i].getOriginalFilename();
				// 获取文件扩展名
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				// 上传文件问图片
				if (extMap.get("image").contains(fileExt)) { // 图片
					// 上传路径
					String path = request.getServletContext().getRealPath("/upload/images");
					url = url + "images";
					File filePath = new File(path, fileName);
					// 判断路径是否存在，如果不存在就创建一个
					if (!filePath.getParentFile().exists()) {
						filePath.getParentFile().mkdirs();
					}
					// 文件重命名
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					fileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
					// 将上传文件保存到目录中
					file[i].transferTo(new File(path + File.separator + fileName));
					path = path + File.separator + fileName;
					url = url + File.separator + fileName + ",";
				} else if (extMap.get("flash").contains(fileExt)) { // flash
					// 上传路径
					String path = request.getServletContext().getRealPath("/upload");
					path = path + "/flash";
					url = url + "flash";
					File filePath = new File(path, fileName);
					// 判断路径是否存在，如果不存在就创建一个
					if (!filePath.getParentFile().exists()) {
						filePath.getParentFile().mkdirs();
					}
					// 将上传文件保存到目录中
					file[i].transferTo(new File(path + File.separator + fileName));
					path = path + File.separator + fileName;
					url = url + File.separator + fileName + ",";
				} else if (extMap.get("media").contains(fileExt)) { // 视频
					// 上传路径
					String path = request.getServletContext().getRealPath("/upload");
					path = path + "/media";
					url = url + "media";
					File filePath = new File(path, fileName);
					// 判断路径是否存在，如果不存在就创建一个
					if (!filePath.getParentFile().exists()) {
						filePath.getParentFile().mkdirs();
					}
					// 文件重命名
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					fileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
					// 将上传文件保存到目录中
					file[i].transferTo(new File(path + File.separator + fileName));
					path = path + File.separator + fileName;
					url = url + File.separator + fileName + ",";
				} else if (extMap.get("file").contains(fileExt)) { // 文件
					// 上传路径
					String path = request.getServletContext().getRealPath("/upload");
					path = path + "/file";
					url = url + "file";
					File filePath = new File(path, fileName);
					// 判断路径是否存在，如果不存在就创建一个
					if (!filePath.getParentFile().exists()) {
						filePath.getParentFile().mkdirs();
					}
					// 将上传文件保存到目录中
					file[i].transferTo(new File(path + File.separator + fileName));
					path = path + File.separator + fileName;
					url = url + File.separator + fileName + ",";
				} else if (extMap.get("software").contains(fileExt)) { // 安装包
					// 上传路径
					String path = request.getServletContext().getRealPath("/upload");
					path = path + "/software";
					url = url + "software";
					File filePath = new File(path, fileName);
					// 判断路径是否存在，如果不存在就创建一个
					if (!filePath.getParentFile().exists()) {
						filePath.getParentFile().mkdirs();
					}
					// 将上传文件保存到目录中
					file[i].transferTo(new File(path + File.separator + fileName));
					path = path + File.separator + fileName;
					url = url + File.separator + fileName + ",";
				}
			}else{ 
				continue;
			}
			url = url.replaceAll("\\\\", "/");
			saveUrl = saveUrl + url;
		}
		if(saveUrl.length()>0)
			saveUrl = saveUrl.substring(0, saveUrl.length() - 1);
		return saveUrl;
	}

	// 上传apk安装包
	public static String uploadAPKFile(HttpServletRequest request, MultipartFile file,
			String versionName)
			throws IllegalStateException, IOException {
		String saveUrl = "";
		// 如果文件不为空，写入上传路径
		String url = null;
		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp,ico");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		extMap.put("software", "apk,exe");
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 获取文件扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		url = BasePage.getBasePage(request) + request.getContextPath() + "/upload/";
		if (extMap.get("software").contains(fileExt)) { // 安装包
			// 上传路径
			String path = request.getServletContext().getRealPath("/upload");
			path = path + "/software";
			url = url + "software";
			File filePath = new File(path, fileName);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdirs();
			}
			// 将上传文件保存到目录中
			fileName = fileName.replace(".apk", "");
			fileName = fileName+".apk";
			file.transferTo(new File(path + File.separator + fileName));
			path = path + File.separator + fileName;
			url = url + File.separator + fileName + ",";
		}
		url = url.replaceAll("\\\\", "/");
		saveUrl = saveUrl + url;
		saveUrl = saveUrl.substring(0, saveUrl.length() - 1);
		return saveUrl;
	}

	// 删除文件
	public static void deleteFile(String fileName,String rpath){
		File file = new File(rpath);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
		}
	}
}
