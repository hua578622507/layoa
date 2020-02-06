/**
 * @Company:中享思途   
 * @Title:RoleService.java 
 * @Author:Administrator   
 * @Date:2020年2月6日 下午5:25:53     
 */
package com.situ.layoa.role.service;

import java.io.Serializable;

import com.situ.layoa.role.domain.Role;

/**
 * @ClassName:RoleService
 * @Description:(这里用一句话描述这个类的作用)
 */
public interface RoleService extends Serializable {
	void saveRole(Role role);
	
	Integer checkName(String roleName);
}
