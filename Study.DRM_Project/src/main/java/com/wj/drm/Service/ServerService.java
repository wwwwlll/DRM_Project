package com.wj.drm.Service;

import org.springframework.web.servlet.ModelAndView;

import com.wj.drm.DTO.UsersDTO;

public interface ServerService {
	public ModelAndView setMainPageData(ModelAndView mav);
	public String registUsers(UsersDTO usersDTO);
	public String login(UsersDTO usersDTO);
}
