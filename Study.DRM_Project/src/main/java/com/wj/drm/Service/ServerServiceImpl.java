package com.wj.drm.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.wj.drm.DTO.FileListDTO;
import com.wj.drm.DTO.UsersDTO;
import com.wj.drm.util.CommonUtil;
import com.wj.drm.DAO.StudyDAO;
@Service
public class ServerServiceImpl implements ServerService{
	public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudyDAO studyDAO;
	
	
	@Override
	public ModelAndView setMainPageData(ModelAndView mav) {
		mav.setViewName("mainPageJsp");
		List<FileListDTO> fileList = new ArrayList<FileListDTO>();
		try {
			fileList = studyDAO.selectFileList_RecentUpload_10();
			if(fileList == null) {
				LOGGER.error("fileList is null");
			}
		}catch (Exception e) {
			LOGGER.error("filestList를 받아 오던중 에러가 발생했습니다.",e);
		}	
		mav.addObject("recentFileList",fileList);
		return mav;
	}


	@Override
	public String registUsers(UsersDTO usersDTO) {
		if(checkUser_OnlyId(usersDTO)!=null) {
			LOGGER.info("이미 가입된 메일입니다.");
			return "이미 가입된 메일입니다.";
		}
		
		
		String accessKey = CommonUtil.getUuid().substring(0, 8);
		usersDTO.setAccessKey(accessKey);
		String content = "회원 가입 인증번호 : "+accessKey; 
		try {
			CommonUtil.sendMail(usersDTO.getUserId(), null, content, null);
		} catch (AddressException e) {
			e.printStackTrace();
			return "fail";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
			return "fail";
		}
		
		try {
			if(studyDAO.INSERT_USERS(usersDTO)!=1) {
				LOGGER.error("유저 정보를 등록하던 중 에러가 발생했습니다");
				return "유저 정보를 등록하던 중 에러가 발생했습니다";
			}else {
				LOGGER.info("유저 정보가 등록되었습니다.");
			}
		}catch (Exception e) {
			LOGGER.error("유저 정보를 등록하던 중 에러가 발생했습니다.",e);
			return "유저 정보를 등록하던 중 에러가 발생했습니다";
		}
		
		
		return "success";
	}


	@Override
	public String login(UsersDTO usersDTO) {
		UsersDTO checkUsersDTO = checkUser_Id_Width_Pwd(usersDTO);
		if(checkUsersDTO == null) {
			return "계정 정보가 잘못되었습니다.";
		}else {
			if(!checkUsersDTO.getAccessKey().equals("ACCESS")) {
				if(usersDTO.getAccessKey()==null||usersDTO.getAccessKey().equals("")) {
					return "accessKey";					
				}else {
					if(checkUsersDTO.getAccessKey().equals(usersDTO.getAccessKey())) {
						try {
							LOGGER.info("update_ACCESSKEY : "+studyDAO.UPDATE_ACCESSKEY(usersDTO));
							return "success";
						}catch(Exception e){
							LOGGER.error("유저 정보를 수정하던 중 에러가 발생했습니다.",e);
							return "유저 정보를 수정하던 중 에러가 발생했습니다.";
						}
						
					}else {
						return "인증키를 잘못 입력하셨습니다.";
					}
				}
			}else {
				return "success";
			}
		}
	}
	
	public UsersDTO checkUser_OnlyId(UsersDTO usersDTO) {
		usersDTO = studyDAO.SELECT_USERS_ONLY_ID(usersDTO.getUserId());
		if(usersDTO!=null) {
			return usersDTO;
		}else {
			return null;
		}
	}
	
	public UsersDTO checkUser_Id_Width_Pwd(UsersDTO usersDTO) {
		usersDTO = studyDAO.SELECT_USERS_ID_WITH_PWD(usersDTO);
		if(usersDTO!=null) {
			return usersDTO;
		}else {
			return null;
		}
}
}
