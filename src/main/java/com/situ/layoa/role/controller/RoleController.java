/**
 * @Company:中享思途   
 * @Title:RoleController.java 
 * @Author:Administrator   
 * @Date:2020年2月6日 下午5:14:01     
 */
package com.situ.layoa.role.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;

/**
 * @ClassName:RoleController
 * @Description:(这里用一句话描述这个类的作用)
 */
@RestController
@RequestMapping("/role")
public class RoleController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String PAGE_ROLE_INDEX = "role/role_index";
	@Autowired
	private RoleService roleService;

	/**
	 * 
	 * @Title: saveRole
	 * @Description:(新增角色)
	 * @param role
	 * @return
	 */
	@PostMapping
	public Long saveRole(Role role) {
		roleService.saveRole(role);
		return 1L;

	}

	/**
	 * 
	 * @Title: goIndex
	 * @Description:(进首页)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_ROLE_INDEX);
		return modelAndView;
	}

	/**
	 * 
	 * @Title: chenckName
	 * @Description:(角色名字唯一性校验)
	 * @param roleName
	 * @return
	 */
	@GetMapping("/chenckname")
	public Integer chenckName(String roleName) {
		return roleService.checkName(roleName);
	}
}
