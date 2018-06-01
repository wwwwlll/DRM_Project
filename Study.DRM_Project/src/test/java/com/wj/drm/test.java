package com.wj.drm;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.wj.drm.util.CommonUtil;

public class test {

	public static void main(String[] args) {
		
		try {
			if(new CommonUtil().sendMail()) {
				System.out.println("«Ï«Ï");
			}
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		}
}
