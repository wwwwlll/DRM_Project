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
	 * 2018. 5. 9. JCONE_WONJAE 김원재
	 *
	 * 디렉토리 생성 
	 *
	 * @param path
	 *            : 경로
	 * @return 폴더를 생성할경우 : true / 폴더를 생성하지 못할경우 : false
	 */
	public static boolean makeFolder(String path) {
		File dir = new File(path);
		if (!dir.isDirectory()) {
			return dir.mkdirs();
		}
		return false;
	}

	/**
	 * 2018. 5. 9. JCONE_WONJAE 김원재
	 *
	 * YYYY/MM/DD/ 로 된 리턴
	 *
	 * @return YYYY/MM/DD/
	 */
	public static String getDatePath_STR() {
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
	 * 2018. 5. 9. JCONE_WONJAE 김원재
	 *
	 *	UUID 리턴
	 *
	 * @return 
	 * 			UUID
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static void downLoad(HttpServletResponse response,File decryptFile) throws IOException {     
		try {
			byte fileByte[] = FileUtils.readFileToByteArray(decryptFile);
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("?��?��_?��?��로드_?��?��?��","UTF-8")+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.getOutputStream().write(fileByte);    
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean delDir(String path) {		
		File file = new File(path);
	        if(file.exists()){ 
	            if(file.isDirectory()){ 
	                File[] files = file.listFiles();
	                for(int i=0; i<files.length; i++){
	                    if(files[i].delete()){
	                        System.out.println(files[i].getName()+" ?��?��?���?");
	                    }else{
	                        System.out.println(files[i].getName()+" ?��?��?��?��");
	                    }
	                }
	            }
	            if(file.delete()){
	                System.out.println("?��?��?��?�� ?���?");
	            }else{
	                System.out.println("?��?��?��?�� ?��?��");
	            }
	        }else{
	            System.out.println("?��?��?�� 존재?���? ?��?��?��?��.");
	        }
		return false;
	}
		
	/**
	 * 2018. 6. 14. JCONE_WONJAE 작성.
	 *
	 * @param userId
	 * 					: 받는 사람 아이디(메일주소)
	 * @param ccAddress
	 * 					: 참조 메일 아이디(cc1,cc2,cc3 으로 나열)
	 * @param content
	 * 					: 메일 내용
	 * @param fileFullPath
	 * 					: 첨부파일 fullPath
	 * @return
	 * @throws AddressException
	 * @throws UnsupportedEncodingException
	 * @throws MessagingException
	 */
	public static boolean sendMail(String userId ,String ccAddress,String content,String fileFullPath) throws AddressException,UnsupportedEncodingException,MessagingException{
		String host = "smtp.naver.com";
	    Properties prop = System.getProperties();
	    Session session = Session.getDefaultInstance(prop,null);
	    MimeMessage message = new MimeMessage(session);
	    String toName = "김원재 미니 프로젝트";
	    String title = "인증코드입니다.";
	    String toAddress =userId;
	    String fromAddress = "funnywonjae@naver.com";
	    boolean b_file = false;
	    boolean b_ccAddress = false;
	    if(fileFullPath != null) {
	    	b_file = true;
	    }
	    if(ccAddress != null) {
	    	b_ccAddress = true;
	    }
	    InternetAddress[] address = {new InternetAddress(fromAddress)};
	    String[] ccAddress_split = null;
	    InternetAddress[] addresscc = null;
	    if(b_ccAddress) {
	    	ccAddress_split = ccAddress.split(",");
	    	addresscc = new InternetAddress[ccAddress_split.length];
	    	for(int i = 0 ; i < ccAddress_split.length ; i++) {
	    		addresscc[i] = new InternetAddress(ccAddress_split[i]);
	    	}
	    }
	    message.setFrom(new InternetAddress(new String(toName.getBytes("KSC5601"),"8859_1")+"<"+toAddress+">"));
	    message.setRecipients(Message.RecipientType.TO, address);
	    if(b_ccAddress) message.setRecipients(Message.RecipientType.CC, addresscc);
	    message.setSubject(title,"KSC5601");
	    MimeBodyPart mbp1 = new MimeBodyPart();
	    mbp1.setText(content.toString().replaceAll(" "," "), "KSC5601");
    	FileDataSource fds = null;
    	MimeBodyPart mdp2 = new MimeBodyPart();
    	Multipart mp = new MimeMultipart();
    	mp.addBodyPart(mbp1);
	    if(b_file) {
	    	fds = new FileDataSource(fileFullPath);
	    	fileFullPath = fileSize(fileFullPath);
	    	if(fileFullPath != "") {
	    		mdp2.setDataHandler(new DataHandler(fds));
		    	mdp2.setFileName(MimeUtility.encodeText(fds.getName(),"KSC5601","B"));
	        	mp.addBodyPart(mdp2);
	    	}
	    }
    	message.setContent(mp);
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host,"funnywonjae","dnjswo3675!");
	    transport.sendMessage(message,message.getAllRecipients());
	    transport.close();
	    System.out.println("메일 전송 완료.");
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
