/**
 * @Company:中享思途   
 * @Title:RoleController.java 
 * @Author:Administrator   
 * @Date:2020年2月6日 下午5:14:01     
 */
package com.situ.layoa.role.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.layoa.commons.LayResult;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;

/**
 * @ClassName:RoleController
 * @Description:(角色的controller层)
 */
@RestController
@RequestMapping("/role")
public class RoleController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String PAGE_ROLE_INDEX = "role/role_form";
	private static final String PAGE_ROLE_TABLE = "role/role-table";
	@Autowired
	private RoleService roleService;

	/**
	 * 
	 * @Title: goAdd
	 * @Description:(弹出form表单)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/goadd")
	public ModelAndView goAdd(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_ROLE_INDEX);
		return modelAndView;
	}

	/**
	 * 
	 * @Title: findAllRole
	 * @Description:(用分页查询全部角色)
	 * @param page 页号
	 * @param limit 每页显示的数据量
	 * @param searchRole 查询的条件
	 * @return
	 */
	@GetMapping("/{page}/{limit}")
	public LayResult findAllRole(@PathVariable Integer page, @PathVariable Integer limit, Role searchRole) {
		System.out.println("这是controller层的：searchRole："+searchRole);
		return roleService.findByPage(page, limit, searchRole);
	}

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
	 * @Title: doDeleteRole
	 * @Description:(逻辑删除动作)
	 * @param rowId
	 * @return
	 */
	@DeleteMapping("/{rowId}")
	public Long doDeleteRole(@PathVariable Long rowId) {
		roleService.deleteRole(rowId);
		return 1L;
	}

	/**
	 * 
	 * @Title: goUpdate
	 * @Description:(进修改页面)
	 * @param rowId
	 * @return
	 */
	@GetMapping("/{rowId}")
	public Role goUpdate(@PathVariable Long rowId) {
		return roleService.getRoleById(rowId);
	}

	/**
	 * 
	 * @Title: doUpdate
	 * @Description:(执行修改)
	 * @param role
	 * @return
	 */
	@PutMapping
	public Integer doUpdate(Role role) {
		return roleService.updateRole(role);
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
		modelAndView.setViewName(PAGE_ROLE_TABLE);
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
