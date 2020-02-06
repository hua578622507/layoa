/**
 * @Company:中享思途   
 * @Title:RoleDao.java 
 * @Author:Administrator   
 * @Date:2020年2月6日 下午6:56:34     
 */
package com.situ.layoa.student.dao;

import org.springframework.stereotype.Repository;

import com.situ.layoa.role.domain.Role;

/**
 * @ClassName:RoleDao
 * @Description:(这里用一句话描述这个类的作用)
 */
@Repository
public interface RoleDao {
	// 新增角色
	void save(Role role);

	// 检验角色名字的唯一性
	Role chenckName(String roleName);
}
