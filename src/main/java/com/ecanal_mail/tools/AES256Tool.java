package com.ecanal_mail.tools;

//import it.sauronsoftware.base64.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
 * java瀹炵幇AES256鍔犲瘑瑙ｅ瘑
 * 渚濊禆璇存槑锛�
 * bcprov-jdk15-133.jar锛歅KCS7Padding
 * javabase64-1.3.1.jar锛歜ase64
 * local_policy.jar 鍜� US_export_policy.jar闇�娣诲姞鍒�%JAVE_HOME%\jre\lib\security涓紙lib涓増鏈�傚悎jdk1.7锛�
 */

public class AES256Tool {
	public static byte[] encrypt(String content, String password) {
		try {
			//"AES"锛氳姹傜殑瀵嗛挜绠楁硶鐨勬爣鍑嗗悕绉�
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			//256锛氬瘑閽ョ敓鎴愬弬鏁帮紱securerandom锛氬瘑閽ョ敓鎴愬櫒鐨勯殢鏈烘簮
			SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
			kgen.init(256, securerandom);
			//鐢熸垚绉樺瘑锛堝绉帮級瀵嗛挜
			SecretKey secretKey = kgen.generateKey();
			//杩斿洖鍩烘湰缂栫爜鏍煎紡鐨勫瘑閽�
			byte[] enCodeFormat = secretKey.getEncoded();
			//鏍规嵁缁欏畾鐨勫瓧鑺傛暟缁勬瀯閫犱竴涓瘑閽ャ�俥nCodeFormat锛氬瘑閽ュ唴瀹癸紱"AES"锛氫笌缁欏畾鐨勫瘑閽ュ唴瀹圭浉鍏宠仈鐨勫瘑閽ョ畻娉曠殑鍚嶇О
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			//灏嗘彁渚涚▼搴忔坊鍔犲埌涓嬩竴涓彲鐢ㄤ綅缃�
			Security.addProvider(new BouncyCastleProvider());
			//鍒涘缓涓�涓疄鐜版寚瀹氳浆鎹㈢殑 Cipher瀵硅薄锛岃杞崲鐢辨寚瀹氱殑鎻愪緵绋嬪簭鎻愪緵銆�
			//"AES/ECB/PKCS7Padding"锛氳浆鎹㈢殑鍚嶇О锛�"BC"锛氭彁渚涚▼搴忕殑鍚嶇О
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] byteContent = content.getBytes("utf-8");
			byte[] cryptograph = cipher.doFinal(byteContent);
		//	return Base64.encode(cryptograph);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(byte[] cryptograph, String password) {
		String msg = null;
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
			kgen.init(256, securerandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

			cipher.init(Cipher.DECRYPT_MODE, key);
		//	byte[] content = cipher.doFinal(Base64.decode(cryptograph));
	//		msg = new String(content);
		} catch (Exception e) {
			msg="瑙ｅ瘑閿欒";
		}
		return msg;
	}

	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/*private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length()/2];
		for (int i = 0;i< hexStr.length()/2; i++) {
			int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
			int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}*/
	
	private static byte[] tohash256Deal(String datastr) {
		try {
			MessageDigest digester=MessageDigest.getInstance("SHA-256");
			digester.update(datastr.getBytes());
			byte[] hex=digester.digest();
			return hex; 
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());  
		}
	}
	
	public static void main(String[] args) {

		String content = "0f607264fc6318a92b9e13c65db7cd3c";
		String password = "123456";
		System.out.println("鏄庢枃锛�" + content);
		System.out.println("key锛�" + password);
		
		byte[] encryptResult = AES256Tool.encrypt(content, password);
		System.out.println("瀵嗘枃锛�" + AES256Tool.parseByte2HexStr(encryptResult));
		
		String decryptResult = AES256Tool.decrypt(encryptResult, "123");
		System.out.println("瑙ｅ瘑锛�" + decryptResult);
		System.out.println("base64鍔犲瘑锛�");
	//	System.out.println("Base64:"+Base64.encode("913a50990dd4127ad1cd69196544ba5d81c9417a9d67e216e296fa45b9eb7ffa668f73e0ec3376dfa2b6c2a7ea40f851b6967dac4f3163cf7679990c148399b3"));
		System.out.println("base64瑙ｅ瘑锛�");
		//System.out.println("Base64:"+Base64.decode("OTEzYTUwOTkwZGQ0MTI3YWQxY2Q2OTE5NjU0NGJhNWQ4MWM5NDE3YTlkNjdlMjE2ZTI5NmZhNDViOWViN2ZmYTY2OGY3M2UwZWMzMzc2ZGZhMmI2YzJhN2VhNDBmODUxYjY5NjdkYWM0ZjMxNjNjZjc2Nzk5OTBjMTQ4Mzk5YjM"));
	}
}
