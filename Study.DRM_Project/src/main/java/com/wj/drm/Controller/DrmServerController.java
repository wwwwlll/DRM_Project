package com.wj.drm.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wj.drm.DAO.StudyDAO;
import com.wj.drm.DTO.UsersDTO;
import com.wj.drm.Service.FileService;
import com.wj.drm.Service.ServerService;


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
	@Autowired
	StudyDAO studyDAO;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/",produces ="application/text; charset=utf8")
	public String gatePage(HttpServletRequest request) {
		return "youtubeTest"; 
	}
	@RequestMapping(value = "mainPageJsp",produces = "application/text; charset=utf8")
	public ModelAndView home(HttpServletRequest request, ModelAndView mav) {
		mav = serverSVC.setMainPageData(mav);
		return mav;
	}
	@RequestMapping(value = "sqlTestPage",produces = "application/text; charset=utf8")
	public ModelAndView home(HttpServletRequest request) {
		String sql = "SELECT * from users"; 
		studyDAO.test(sql);
		return null;
	}
	@RequestMapping(value ="uploadDoc",produces = "application/text; charset=utf8")
	public 	@ResponseBody String uploadDoc(MultipartHttpServletRequest request,Model mode) {
		String result ="";
		try {
			result +=  fileSVC.fileUpload(request);
		} catch (Exception e) {
			LOGGER.error("file Upload Fail",e);
		}
		return result;
	}
	@RequestMapping(value="login",produces = "application/text; charset=utf8")
	public @ResponseBody String login(UsersDTO usersDTO) {
		
		return serverSVC.login(usersDTO);
	}
	@RequestMapping(value="downloadDoc",produces = "application/text; charset=utf8")
	public @ResponseBody String downloadDoc(HttpServletRequest request) {
		String result ="";
		try {
			result = fileSVC.fileDownload(request.getParameter("encPath"));
		} catch (Exception e) {
			LOGGER.error("file download Fail",e);
		}
		return result;
	}
	
	@RequestMapping(value="registUserJsp",produces = "application/text; charset=utf8")
	public String registUserJSP(ModelAndView mav) {
		return "registUserJsp";
	}
	
	@ResponseBody
	@RequestMapping(value="registUser",produces = "application/text; charset=utf8")
	public String registUser(UsersDTO  usersDTO) {
		String result = serverSVC.registUsers(usersDTO);
		LOGGER.info(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="addList",produces="application/text;charset=utf8")
	public String addList(@RequestParam("command") String command) {
		return command;
	}
}
