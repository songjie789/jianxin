package com.yuyi.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
public class getIP {
	public String IP() throws UnknownHostException{
		InetAddress ia=null;
		String ip =null;
			ia=ia.getLocalHost();
			ip=ia.getHostAddress();
		return ip;
	}
}
