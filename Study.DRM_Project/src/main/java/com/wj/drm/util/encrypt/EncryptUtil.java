package com.wj.drm.util.encrypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wj.drm.util.CommonUtil;


public class EncryptUtil {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	String iv;
	Key keySpec;

	/**
	 * 2018. 5. 10. JCONE_WONJAE ?��?��.
	 *
	 * 16?���?? key ?��?��.
	 *
	 * @param key
	 * @throws UnsupportedEncodingException
	 */
	public void setEncriptKey(String key) throws UnsupportedEncodingException {

		try {
			byte[] keyBytes = new byte[16];
			byte[] b = key.getBytes("UTF-8");
			System.arraycopy(b, 0, keyBytes, 0, keyBytes.length);
			SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
			this.iv = key.substring(0, 16);
			this.keySpec = keySpec;

		} catch (Exception e) {
			LOGGER.error("encryptFile_AES256 Fail", e);
		}

	}
	
	
	/**
	 * 2018. 5. 10. JCONE_WONJAE ?��?��.
	 *
	 * @param 
	 * 			orgFile ?��?��?��?�� ?��?��
	 * @param 
	 * 			decFile 복호?��?�� ???��?�� ?��?�� 
	 * @return
	 * 			true 	?���??
	 * 			false	?��?��
	 * @throws Exception
	 */
	public boolean decryptFile(File orgFile,File decFile) throws Exception {
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			String key = getKey(decFile.getAbsolutePath());
			String decPath = decFile.getPath();

			new CommonUtil().makeFolder(decPath.substring(0,decPath.lastIndexOf("\\")));
			setEncriptKey(key);
			br = new BufferedReader(new FileReader(orgFile));
			StringBuilder result = new StringBuilder();
			char text;
			while((text = (char)br.read()) !=(char)-1) {
				result.append(text);
			}
//			while (br.readLine() != null) {
//				result.append(br.readLine());
//			}

			StringBuilder encResult = new StringBuilder();

			encResult.append(decrypt(new String(result.toString())));

			fw = new FileWriter(decFile, true);
//			String line = System.getProperty("line.separator");
			fw.write(encResult.toString());
			fw.flush();
			return true;
		} catch (Exception e) {
			LOGGER.error("enc Error", e);
			return false;
		} finally {
			fw.close();
			br.close();
		}

		
	}
	/**
	 * 2018. 5. 10. JCONE_WONJAE ?��?��.
	 *
	 * @param 
	 * 			orgFile ?��로드 ?�� ?��?��
	 * @param 
	 * 			encFile	?��?��?��?�� ???�� ?�� ?��?��
	 * @return
	 * 			
	 * @throws Exception
	 */
	public boolean encryptFile(File orgFile, File encFile) throws Exception {
		BufferedReader br = null;
		FileWriter fw = null;
		try {
			String key = getKey(encFile.getAbsolutePath());
			setEncriptKey(key);
			br = new BufferedReader(new FileReader(orgFile));
			StringBuilder result = new StringBuilder();

			char text;
			while((text = (char)br.read()) !=(char)-1) {
				result.append(text);
			}

			StringBuilder encResult = new StringBuilder();

			encResult.append(encrypt(new String(result.toString())));
			
			fw = new FileWriter(encFile, true);
			String line = System.getProperty("line.separator");
			fw.write(encResult.toString().replaceAll("\n",line));
			fw.flush();

			return true;
		} catch (Exception e) {
			LOGGER.error("enc Error", e);
			return false;
		} finally {
			fw.close();
			br.close();
		}

	}
	
	/**
	 * 2018. 5. 10. JCONE_WONJAE ?��?��.
	 *
	 * @param 
	 * 			str ?��?�� ?��?��
	 * @return
	 * 			?��?��?��?�� str
	 */
	private String encrypt(String str) {
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));

			byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));
			String Str = new String(Base64.encodeBase64(encrypted));

			return Str;
		} catch (Exception e) {
			LOGGER.error("encrypt Error", e);
		}
		return null;
	}

	/**
	 * 2018. 5. 10. JCONE_WONJAE ?��?��.
	 *
	 * @param 
	 * 			str ?��?�� ?��?��
	 * @return
	 * 			복호?��?�� str
	 */
	private String decrypt(String str) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));

			byte[] byteStr = Base64.decodeBase64(str.getBytes());
			String Str = new String(cipher.doFinal(byteStr), "UTF-8");

			return Str;
		} catch (Exception e) {
			LOGGER.error("encrypt Error", e);
		}
		return null;
	}
	
	/**
	 * 2018. 5. 10. JCONE_WONJAE ?��?��.
	 *
	 * @param 
	 * 			path ?��?�� FullPath
	 * @return
	 * 			?��?�� ?���??(UUID) 16?��리까�??.
	 */
	private String getKey(String path) {
		int lastIndex = path.lastIndexOf("/");
		String key = path.substring(lastIndex + 1, lastIndex + 17);
		return key;
	}
}
