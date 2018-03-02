package com.ecanal_mail.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

public class SendMessage {
	//发送注册验证码
	public static String sendMessage(String message,String phone) throws IOException {
		URL url = new URL("http://dxjk.51lanz.com/LANZGateway/DirectSendSMSs.asp");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "GB2312");
//		String urlString = "UserID=841086&Account=yuyixinxi&Password=B361C414812B919270749646C45F9A38D2B68BF3&Content="
//				+message+"&Phones="+phone+"&ReturnXJ=1";
		String urlString = "UserID=870449&Account=sdyyxx&Password=91B5D3CB787C319006C8297CC1876011D2826670&Content="
				+message+"&Phones="+phone+"&ReturnXJ=1";
		urlString = urlString.replace("%", "％");
		urlString = urlString.replace("+", "＋");
		urlString = urlString.replace(" ", "+");
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
		while ((sCurrentLine = l_reader.readLine()) != null) {
			sTotalString += sCurrentLine + "\r\n";
		}
		JSONObject json = JSONObject.fromObject(sTotalString);
		JSONObject json2 = JSONObject.fromObject(json.get("LANZ_ROOT"));
		return json2.get("ErrorNum").toString();
	}
}
