package com.eyunhe.rsatools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RSAUtils {
	public static final int KEYSIZE = 1024;

	/**
	 * 加密
	 * 
	 * @param publicKey
	 *            公钥
	 * @param content
	 *            需要加密的内容
	 * @return
	 * @throws Exception
	 */
	public String encrypttoStr(Key publicKey, String content) throws Exception {
		RandUtil rand = new RandUtil();
		String endata = rand.parseByte2HexStr(publicEnrypy(publicKey, content));
		return endata;
	}

	/**
	 * 解密
	 * 
	 * @param privateKey
	 *            私钥
	 * @param endata
	 *            需要解密的内容
	 * @return
	 * @throws Exception
	 */
	public String decrypttoStr(Key privateKey, String endata) throws Exception {
		RandUtil rand = new RandUtil();
		String data = new String(privateEncode(privateKey, rand.parseHexStr2Byte(endata)));
		return data;
	}

	public String decrypttoStr_normal(Key privateKey, String endata) throws Exception {
		String data = new String(privateEncode(privateKey, endata.getBytes()));
		return data;
	}

	/**
	 * 加密的方法,使用公钥进行加密
	 * 
	 * @param publicKey
	 *            公钥
	 * @param data
	 *            需要加密的数据
	 * @throws Exception
	 */
	public static byte[] publicEnrypy(Key publicKey, String data) throws Exception {

		Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());

		// 设置为加密模式
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		// 对数据进行加密
		byte[] result = cipher.doFinal(data.getBytes());

		return result;
	}

	/**
	 * 解密的方法，使用私钥进行解密 privateKey 私钥 encoData 需要解密的数据
	 * 
	 * @throws Exception
	 */
	public static byte[] privateEncode(Key privateKey, byte[] encoData) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());

		// 设置为解密模式，用私钥解密
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		// 解密
		byte[] data = cipher.doFinal(encoData);
		// System.out.println("解密后的数据："+data);
		return data;
	}

	/**
	 * 把私钥或则公钥保存到硬盘上
	 * 
	 * @param privateKey
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void saveKey(Key key, String path) {
		ObjectOutputStream outputStream;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(new File(path)));
			outputStream.writeObject(key);
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 自动生成密钥对
	 * 
	 * @throws Exception
	 */
	public static Map<String, Object> createKey() {

		try {
			// Cipher cipher = Cipher.getInstance("RSA");
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());

			SecureRandom random = new SecureRandom();
			keyPairGenerator.initialize(RSAUtils.KEYSIZE, random);

			// 生成钥匙对
			KeyPair keyPair = keyPairGenerator.generateKeyPair();

			// 得到公钥
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
			// 得到私钥
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("publicKey", publicKey);
			map.put("privateKey", privateKey);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 从硬盘中加载公私钥
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static Key loadKey(String path) {
		ObjectInputStream inputStream;
		System.out.println(path);
		Key key = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(new File(path)));
			key = (Key) inputStream.readObject();
			inputStream.close();
		} catch (FileNotFoundException e) {
			key = null;
			e.printStackTrace();
		} catch (IOException e) {
			key = null;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			key = null;
			e.printStackTrace();
		}
		return key;
	}

	// IOS端
	public static Key iosloadKey(String path) {
		ObjectInputStream inputStream;
		System.out.println(path);
		Key key = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(new File(path)));
			key = (Key) inputStream.readObject();
			inputStream.close();
		} catch (FileNotFoundException e) {
			key = null;
			e.printStackTrace();
		} catch (IOException e) {
			key = null;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			key = null;
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * 使用模和指数生成RSA公钥
	 * 
	 * 
	 * @param modulus
	 *            模
	 * @param exponent
	 *            指数
	 * @return
	 */
	public static RSAPublicKey getPublicKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus);
			BigInteger b2 = new BigInteger(exponent);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 使用模和指数生成RSA私钥
	 * 
	 * /None/NoPadding】
	 * 
	 * @param modulus
	 *            模
	 * @param exponent
	 *            指数
	 * @return
	 */
	public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus);
			BigInteger b2 = new BigInteger(exponent);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * ios加解密
	 */
	// ios加密
	public static String iosEncrypt(RSAPublicKey publicKey, String pwd) {
		String epwd = null;
		if (publicKey == null) {
			System.out.println("公钥为空");
		} else {
			Cipher cipher = null;
			try {
				cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				byte[] output = cipher.doFinal(pwd.getBytes());
				epwd = new BASE64Encoder().encodeBuffer(output);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("加密算法错误");
			} catch (NoSuchPaddingException e) {
				System.out.println("加密算法错误");
			} catch (InvalidKeyException e) {
				System.out.println("公钥错误");
			} catch (IllegalBlockSizeException e) {
				System.out.println("明文长度错误");
			} catch (BadPaddingException e) {
				System.out.println("明文数据已损坏");
			}
		}
		return epwd;
	}

	// ion解密
	public static String iosDecrypt(RSAPrivateKey privateKey, String epwd) {
		String pwd = null;
		if (privateKey == null) {
			System.out.println("私钥为空");
		}
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] output = null;
			try {
				output = cipher.doFinal(new BASE64Decoder().decodeBuffer(epwd));
			} catch (IOException e) {
				System.out.println("decodeBuffer错误");
			}
			pwd = new String(output);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法错误");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			System.out.println("加密算法错误");
		} catch (IllegalBlockSizeException e) {
			System.out.println("密文长度错误");
		} catch (BadPaddingException e) {
			System.out.println("密文数据已损坏");
		}
		return pwd;
	}

	// 从文件中获取公/私钥
	public static String getKeyFromFile(String filePath) {
		BufferedReader bufferedReader;
		List<String> list = new ArrayList<String>();
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			System.out.println("密钥文件读取错误");
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i < list.size() - 1; i++) {
			stringBuilder.append(list.get(i)).append("\r");
		}

		String key = stringBuilder.toString();
		return key;
	}

	/**
	 * 从字符串中加载公钥
	 */
	public static RSAPublicKey loadPublicKey(String publicKeyStr){
		RSAPublicKey publicKey = null;
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr); // 将公钥字符串转化为byte
			KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // 初始化公钥工厂
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer); // 规范
																			// 用X.509标准作为密钥规范管理的编码格式*(公钥字符串)
			publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec); // 工厂获取规范后的公钥字符串
		} catch (NoSuchAlgorithmException e) {
			System.out.println("无此算法");
		} catch (InvalidKeySpecException e) {
			System.out.println("公钥非法");
		} catch (IOException e) {
			System.out.println("公钥数据内容读取错误");
		} catch (NullPointerException e) {
			System.out.println("公钥数据为空");
		}

		return publicKey;
	}

	/**
	 * 从字符串中加载公钥
	 */
	public static RSAPrivateKey loadPrivateKey(String privateKeyStr){
		RSAPrivateKey privateKey = null;
		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("无此算法");
		} catch (InvalidKeySpecException e) {
			System.out.println("私钥不正确");
		} catch (IOException e) {
			System.out.println("私钥数据内容读取错误");
		} catch (NullPointerException e) {
			System.out.println("私钥数据为空");
		}

		return privateKey;
	}
}