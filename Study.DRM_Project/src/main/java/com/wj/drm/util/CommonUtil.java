package com.wj.drm.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtil {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	/**
	 * 2018. 5. 9. JCONE_WONJAE ?ûë?Ñ±.
	 *
	 * path Í≤ΩÎ°ú ?îî?†â?Ü†Î¶? ?Éù?Ñ±
	 *
	 * @param path
	 *            : Í≤ΩÎ°ú
	 * @return ?Éù?Ñ±?ãú : true ?ù¥ÎØ? ?ûà?ùÑÍ≤ΩÏö∞ false
	 */
	public boolean makeFolder(String path) {
		File dir = new File(path);
		if (!dir.isDirectory()) {
			return dir.mkdirs();
		}
		return false;
	}

	/**
	 * 2018. 5. 9. JCONE_WONJAE ?ûë?Ñ±.
	 *
	 * YYYY/MM/DD/ Í≤ΩÎ°úÍ∞? Î¶¨ÌÑ¥
	 *
	 * @return YYYY/MM/DD/
	 */
	public String getDatePath_STR() {
		String datePath = "";

		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd", Locale.KOREA);
		Date date = new Date();
		datePath += dateFormat.format(date);
		System.out.println(datePath);
		return datePath;
	}
	
	/*public String convertStrDateToDateType(String datePath) {
		String[] splitDate = datePath.split("/");
		java.sql.Date date = java.sql.Date.valueOf(splitDate[0]+"-"+splitDate[1]+"-"+splitDate[2]);
		return date;
	}*/


	/**
	 * 2018. 5. 9. JCONE_WONJAE ?ûë?Ñ±.
	 *
	 *	UUID ?Éù?Ñ±
	 *
	 * @return 
	 * 			UUID
	 */
	public String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public void downLoad(HttpServletResponse response,File decryptFile) throws IOException {     
		try {
			byte fileByte[] = FileUtils.readFileToByteArray(decryptFile);
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("?åå?ùº_?ã§?ö¥Î°úÎìú_?Öå?ä§?ä∏","UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.getOutputStream().write(fileByte);    
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean delDir(String path) {		
		File file = new File(path);
	        if(file.exists()){ //?åå?ùºÏ°¥Ïû¨?ó¨Î∂??ôï?ù∏
	            if(file.isDirectory()){ //?åå?ùº?ù¥ ?îî?†â?Ü†Î¶¨Ïù∏Ïß? ?ôï?ù∏
	                File[] files = file.listFiles();
	                for(int i=0; i<files.length; i++){
	                    if(files[i].delete()){
	                        System.out.println(files[i].getName()+" ?Ç≠?†ú?Ñ±Í≥?");
	                    }else{
	                        System.out.println(files[i].getName()+" ?Ç≠?†ú?ã§?å®");
	                    }
	                }
	            }
	            if(file.delete()){
	                System.out.println("?åå?ùº?Ç≠?†ú ?Ñ±Í≥?");
	            }else{
	                System.out.println("?åå?ùº?Ç≠?†ú ?ã§?å®");
	            }
	        }else{
	            System.out.println("?åå?ùº?ù¥ Ï°¥Ïû¨?ïòÏß? ?ïä?äµ?ãà?ã§.");
	        }
		return false;
	}
		
	public boolean sendMail() throws AddressException,UnsupportedEncodingException,MessagingException{
		String host = "smtp.naver.com";
	    Properties prop = System.getProperties();
	    Session session = Session.getDefaultInstance(prop,null);
	    MimeMessage message = new MimeMessage(session);
	    String toName = "±Ëø¯¿Á";
	    String title = "±Ëø¯¿Á ∏ﬁ¿œ ≈◊Ω∫∆Æ¿‘¥œ¥Ÿ.";
	    StringBuilder content = new StringBuilder() ;
	    content.append("µø«ÿπ∞∞˙ πÈµŒªÍ¿Ã ∏∂∏£∞Ì¥‚µµ∑œ «œ¥¿¥‘¿Ã ∫∏øÏ«œªÁ øÏ∏Æ ≥™∂Û ∏∏ºº!");
	    String toAddress ="funnywonjae@naver.com";
	    String fromAddress = "funnywonjae@naver.com";
	    String ccAddress = "funnywonjae@naver.com,funnywonjae@naver.com,funnywonjae@naver.com,funnywonjae@naver.com";
	    String filePath = "D:\\testText.txt";
	    InternetAddress[] address = {new InternetAddress(fromAddress)};
	    String[] ccAddress_split = ccAddress.split(",");
	    InternetAddress[] addresscc = new InternetAddress[ccAddress_split.length];
	    for(int i = 0 ; i < ccAddress_split.length ; i++) {
	    	addresscc[i] = new InternetAddress(ccAddress_split[i]);
	    }
	    message.setFrom(new InternetAddress(new String(toName.getBytes("KSC5601"),"8859_1")+"<"+toAddress+">"));
	    message.setRecipients(Message.RecipientType.TO, address);
	    message.setRecipients(Message.RecipientType.CC, addresscc);
	    message.setSubject(title,"KSC5601");
	    MimeBodyPart mbp1 = new MimeBodyPart();
	    mbp1.setText(content.toString().replaceAll(" "," "), "KSC5601");
	    String file = filePath;
	    file = fileSize(file);
	    MimeBodyPart mdp2 = new MimeBodyPart();
	    FileDataSource fds = new FileDataSource(file);
	    mdp2.setDataHandler(new DataHandler(fds));
	    mdp2.setFileName(MimeUtility.encodeText(fds.getName(),"KSC5601","B"));
	    Multipart mp = new MimeMultipart();
	    mp.addBodyPart(mbp1);
	    if(!file.equals("")) {
	        mp.addBodyPart(mdp2);
	    }
	    message.setContent(mp);
	    Transport transport = session.getTransport("smtp");
	            //smtp ¡÷º“∑Œ º≥¡§«— ∏ﬁ¿œ¿« ∏ﬁ¿œ¡÷º“(æ∆¿Ãµ)/∆–Ω∫øˆµÂ
	    transport.connect(host,"funnywonjae","dnjswo3675!");
	    transport.sendMessage(message,message.getAllRecipients());
	    transport.close();
	    System.out.println("∏ﬁ¿œ¿¸º€ º∫∞¯!");
		return true;
	}
	 
	private static String fileSize(String fileName) {
	    File file = new File(fileName);
	    if(file.length()>(1024*1024*2.5)) {
	        fileName = "";
	    }
	 	return fileName;
	}
}
