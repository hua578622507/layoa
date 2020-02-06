/**
 * @Company:中享思途   
 * @Title:RoleServiceImpl.java 
 * @Author:Administrator   
 * @Date:2020年2月6日 下午5:28:16     
 */
package com.situ.layoa.role.service.impl;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;
import com.situ.layoa.student.dao.RoleDao;
import com.situ.layoa.util.ConfigUtils;

/**
 * @ClassName:RoleServiceImpl
 * @Description:(这里用一句话描述这个类的作用)
 */
@Service
public class RoleServiceImpl implements RoleService, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private RoleDao roleDao;

	/**
	 * @Title: saveRole
	 * @Description:(新增用户)
	 * @param role
	 * @return
	 */
	@Override
	public void saveRole(Role role) {
		role.setCreateBy(ConfigUtils.SYS);
		role.setCreateDate(new Date());
		roleDao.save(role);
	}

	/**
	 * @Title: checkName
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param roleName
	 * @return
	 */
	@Override
	public Integer checkName(String roleName) {
		Integer result = 1;
		Role role = roleDao.chenckName(roleName);
		String name = role.getRoleName();
		result = name.equals(roleName) ? 0 : 1;
		return result;
	}

}
