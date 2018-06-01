package com.wj.drm.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wj.drm.Service.FileService;
import com.wj.drm.Service.ServerService;
import com.wj.drm.util.messages.CodeProperties;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DrmServerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DrmServerController.class);
//	@Autowired
//	CodeProperties msg;
	@Autowired
	FileService fileSVC;
	@Autowired
	ServerService serverSVC;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "mainPageJsp")
	public ModelAndView home(HttpServletRequest request, ModelAndView mav) {
		mav = serverSVC.setMainPageData(mav);
		
		return mav;
	}
	@RequestMapping(value ="uploadDoc")
	public 	@ResponseBody String uploadDoc(MultipartHttpServletRequest request,Model mode) {
		String result ="";
		try {
			result +=  fileSVC.fileUpload(request);
		} catch (Exception e) {
			LOGGER.error("file Upload Fail",e);
		}
		return result;
	}
	@RequestMapping(value="downloadDoc")
	public @ResponseBody String downloadDoc(HttpServletRequest request) {
		String result ="";
		try {
			result = fileSVC.fileDownload(request.getParameter("encPath"));
		} catch (Exception e) {
			LOGGER.error("file download Fail",e);
		}
		
		return result;
		
	}
	
	@RequestMapping(value="registUserJsp")
	public String registUserJSP(ModelAndView mav) {
		return "registUser";
	}
		

}
