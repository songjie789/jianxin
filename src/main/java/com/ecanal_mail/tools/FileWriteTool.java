package com.ecanal_mail.tools;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.security.Key;
import java.security.interfaces.RSAPrivateKey;

public class FileWriteTool {

	public static void writeFile(HttpServletRequest request,RSAPrivateKey privateKey) throws IOException{
		String url = BasePage.getBasePage(request)+request.getContextPath() + "/upload/file";
		String path = request.getServletContext().getRealPath("/upload/file");
		FileWriter fw = null;
		File filePath = new File(path,"test.txt");
		if(!filePath.getParentFile().exists()){	//如果文件为空就新建一个
			filePath.getParentFile().mkdirs();
		}
		fw = new FileWriter(path+"/test.txt");
		fw.write(privateKey.toString());
		fw.close(); 
		System.out.println(url);
	}
	public static void readFile(HttpServletRequest request) throws FileNotFoundException, IOException, ClassNotFoundException{
		String path = request.getServletContext().getRealPath("/upload/file");
        File file = new File(path+"/test.txt");
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(path+"/test.txt"));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
	
	public static void main(String[] args) {   

        FileWriter fw = null;   

        int count=1000;//写文件行数   

        try {   
            fw = new FileWriter("E:/add2.txt");   

            long begin3 = System.currentTimeMillis();   

            for (int i = 0; i < count; i++) {   

                fw.write("测试java 文件操作\r\n");   

            }   

                        fw.close();   

            long end3 = System.currentTimeMillis();   

            System.out.println("FileWriter执行耗时:" + (end3 - begin3) + "豪秒");   

        } catch (Exception e) {   

            e.printStackTrace();   

        }   
        finally {   

            try {   

                fw.close();   

            } catch (Exception e) {   

                e.printStackTrace();   

            }   

        }   

    }
}