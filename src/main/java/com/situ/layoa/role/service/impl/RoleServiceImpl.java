/**
 * @Company:中享思途   
 * @Title:RoleServiceImpl.java 
 * @Author:Administrator   
 * @Date:2020年2月6日 下午5:28:16     
 */
package com.situ.layoa.role.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.commons.LayResult;
import com.situ.layoa.role.dao.RoleDao;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;
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
		if (role != null && role.getRoleName().equals(roleName)) {
			result = 0;
		}
		return result;
	}


	/**
	 * @Title: getCount
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@Override
	public Integer getCount() {
		return roleDao.getCount();
	}

	/**
	 * @Title: deleteRole
	 * @Description:(逻辑删除角色)
	 * @param rowId
	 */
	@Override
	public void deleteRole(Long rowId) {
		roleDao.delete(rowId);
	}

	@Override
	public Role getRoleById(Long rowId) {
		return roleDao.get(rowId);
	}

	/**
	 * @Title: findByPage
	 * @Description:(通过分页查询数据)
	 * @param page  分页
	 * @param limit 每页显示的数据量
	 * @param role
	 * @return
	 */
	@Override
	public LayResult findByPage(Integer page, Integer limit, String roleName) {
		// 查询出数据总数
		Integer count = roleDao.getCount();
		// limit查询数据开始的下标
		Integer firstResult = (page - 1) * limit;
		List<Role> roleList = roleDao.findByPage(firstResult, limit, roleName);
		return new LayResult(0, "", count, roleList);
	}

	/**
	 * @Title: updateRole
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param role
	 * @return
	 */
	@Override
	public Integer updateRole(Role role) {
		role.setUpdateBy(role.getRoleName());
		role.setUpdateDate(new Date());
		roleDao.update(role);
		return 1;
	}

}
