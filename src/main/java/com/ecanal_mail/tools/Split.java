package com.ecanal_mail.tools;

public class Split {
	
	public static void main(String[] args) {
		String str = "2017-08-12/2017-09-34";
		String a[] = str.split("/");
		String startTime = a[0];
		String endTime = a[1];
		System.out.println("startTime:"+startTime+"  endTime:"+endTime);
	}
}
