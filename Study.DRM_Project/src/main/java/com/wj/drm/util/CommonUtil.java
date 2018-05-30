package com.wj.drm.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtil {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	/**
	 * 2018. 5. 9. JCONE_WONJAE ??±.
	 *
	 * path κ²½λ‘ ?? ? λ¦? ??±
	 *
	 * @param path
	 *            : κ²½λ‘
	 * @return ??±? : true ?΄λ―? ??κ²½μ° false
	 */
	public boolean makeFolder(String path) {
		File dir = new File(path);
		if (!dir.isDirectory()) {
			return dir.mkdirs();
		}
		return false;
	}

	/**
	 * 2018. 5. 9. JCONE_WONJAE ??±.
	 *
	 * YYYY/MM/DD/ κ²½λ‘κ°? λ¦¬ν΄
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
	 * 2018. 5. 9. JCONE_WONJAE ??±.
	 *
	 *	UUID ??±
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
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("??Ό_?€?΄λ‘λ_??€?Έ","UTF-8")+"\";");
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
	        if(file.exists()){ //??Όμ‘΄μ¬?¬λΆ???Έ
	            if(file.isDirectory()){ //??Ό?΄ ?? ? λ¦¬μΈμ§? ??Έ
	                File[] files = file.listFiles();
	                for(int i=0; i<files.length; i++){
	                    if(files[i].delete()){
	                        System.out.println(files[i].getName()+" ?­? ?±κ³?");
	                    }else{
	                        System.out.println(files[i].getName()+" ?­? ?€?¨");
	                    }
	                }
	            }
	            if(file.delete()){
	                System.out.println("??Ό?­?  ?±κ³?");
	            }else{
	                System.out.println("??Ό?­?  ?€?¨");
	            }
	        }else{
	            System.out.println("??Ό?΄ μ‘΄μ¬?μ§? ??΅??€.");
	        }
		return false;
	}
}
