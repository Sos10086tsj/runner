package com.chinesedreamer.runner.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesedreamer.runner.business.system.user.service.UserService;
import com.chinesedreamer.runner.business.system.user.vo.UserVo;
import com.chinesedreamer.runner.web.vo.ResponseVo;

/**  
* Description:
* @author Paris    
* @date Jul 29, 2015
* @version 1.0
*/
@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 用户注册
	 * @param request
	 * @param userVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ResponseVo register(HttpServletRequest request, UserVo userVo){
		ResponseVo responseVo = new ResponseVo();
		try {
			this.userService.register(userVo);
		} catch (Exception e) {
			responseVo.setHasException(Boolean.TRUE);
			responseVo.setErrorMessage(e.getMessage());
		}
		return responseVo;
	}
	
	/**
	 * 用户登陆
	 * @param request
	 * @param userVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseVo login(HttpServletRequest request, UserVo userVo){
		ResponseVo responseVo = new ResponseVo();
		try {
			this.userService.login(userVo);
		} catch (Exception e) {
			responseVo.setHasException(Boolean.TRUE);
			responseVo.setErrorMessage(e.getMessage());
		}
		return responseVo;
	}
}
