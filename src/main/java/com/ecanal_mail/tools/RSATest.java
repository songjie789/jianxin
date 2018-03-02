package com.ecanal_mail.tools;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import com.eyunhe.rsatools.RSAUtils;
import com.sun.xml.internal.messaging.saaj.util.Base64;

public class RSATest {

	public static void main(String[] args) throws Exception {
		RSAUtils rsa = new RSAUtils();
		//生成公钥和密钥
		Map<String,Object> keyMap = rsa.createKey();
//		RSAPublicKey publicKey = (RSAPublicKey) RSAUtils.loadKey("F:\\spring+mybatis\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\e_canal\\upload\\file\\publicKey");
//		RSAPrivateKey privateKey = (RSAPrivateKey) RSAUtils.loadKey("F:\\spring+mybatis\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\e_canal\\upload\\file\\privateKey");
//		RSAPublicKey publicKey=rsa.getPublicKey("913a50990dd4127ad1cd69196544ba5d81c9417a9d67e216e296fa45b9eb7ffa668f73e0ec3376dfa2b6c2a7ea40f851b6967dac4f3163cf7679990c148399b3", "10001");
//		String pwd = "1234546";
//		System.out.println("明文："+pwd);
//		String epwd = rsa.encrypttoStr(publicKey,pwd);
//		System.out.println("密文："+epwd);
//		System.out.println("解密过程:");
		System.out.println(Base64.base64Decode("913a50990dd4127ad1cd69196544ba5d81c9417a9d67e216e296fa45b9eb7ffa668f73e0ec3376dfa2b6c2a7ea40f851b6967dac4f3163cf7679990c148399b3"));
//		String npwd = rsa.decrypttoStr(privateKey, epwd);
//		StringBuffer pd = new StringBuffer(npwd);
//		System.out.println("明文："+pd.toString());
//		String epwd2 = rsa.encrypttoStr(publicKey,pwd);
//		System.out.println("密文："+epwd2);
		
	}

}
