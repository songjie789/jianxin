package com.ecanal_mail.tools;

import java.security.MessageDigest;

public class MD5Util2{  
    
    public static void main(String[] args) {  
        String pwd = getMD5("appid=wx11784c3c4b3f2042&body=e运河支付中心-定金支付&mch_id=1491654792&nonce_str=411510301774140&notify_url=http://1zm8875695.iok.la/e_canal/wPayReturn&out_trade_no=edc941508300666947&spbill_create_ip=0:0:0:0:0:0:0:1&total_fee=1000&trade_type=NATIVE&key=9FBE374486A6C492BCEDA5B7C44FA3A4");  
        System.out.println(pwd);  
    }  
   
   //生成MD5  
    public static String getMD5(String message) {  
        String md5 = "";  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象  
            byte[] messageByte = message.getBytes("UTF-8");  
            byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位  
            md5 = bytesToHex(md5Byte);                            // 转换为16进制字符串  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return md5;  
    }  
   
     // 二进制转十六进制  
    public static String bytesToHex(byte[] bytes) {  
        StringBuffer hexStr = new StringBuffer();  
        int num;  
        for (int i = 0; i < bytes.length; i++) {  
            num = bytes[i];  
             if(num < 0) {  
                 num += 256;  
            }  
            if(num < 16){  
                hexStr.append("0");  
            }  
            hexStr.append(Integer.toHexString(num));  
        }  
        return hexStr.toString().toUpperCase();  
    }  
}  
