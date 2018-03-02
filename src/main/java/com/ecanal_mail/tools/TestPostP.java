package com.ecanal_mail.tools;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.HttpURLConnection;

public class TestPostP
{
	public static void testPost() throws IOException 
	{
		URL url = new URL("http://dxjk.51lanz.com/LANZGateway/DirectSendSMSs.asp");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
		connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");              
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "GB2312");
		  String urlString = "UserID=841086&Account=yuyixinxi&Password=B361C414812B919270749646C45F9A38D2B68BF3"+
				  "&Content=您的注册验证码为8268，该验证码10分钟内有效。如非本人操作请忽略此短信！【宇易信息】"+
				  "&Phones=15253165511&ReturnXJ=1";
		urlString = urlString.replace("%","％");
		urlString = urlString.replace("+","＋");
		urlString = urlString.replace(" ","+");
		out.write(urlString);
		out.flush();
		out.close();
		String sCurrentLine;
		String sTotalString;
		sCurrentLine = "";
		sTotalString = "";
		InputStream l_urlStream;
		l_urlStream = connection.getInputStream();

		BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
		while ((sCurrentLine = l_reader.readLine()) != null) 
		{
			sTotalString += sCurrentLine + "\r\n";
		}
		System.out.println(sTotalString);
	}
	public static void main(String[] args) throws IOException
	 {
         testPost();
	 }
}