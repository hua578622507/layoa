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

import com.situ.layoa.commons.DAOUtils;
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
	 * @Description:(检测名字唯一性)
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
	 * @Title: getCount
	 * @Description:(查询出数据的总量)
	 * @return
	 */
//	@Override
//	public Integer getCount(Role searchRole) {
//		return roleDao.getCount(searchRole);
//	}

	/**
	 * @Title: findByPage
	 * @Description:(通过分页查询数据)
	 * @param page  分页
	 * @param limit 每页显示的数据量
	 * @param role
	 * @return
	 */
	@Override
	public LayResult findByPage(Integer page, Integer limit, Role searchRole) {
		System.out.println("这是RoleServiceImpl层的：searchRole：" + searchRole);
		// 通过反射机制将类的实例中的‘’重新赋值为null，方便MyBatis中多条件查询SQL语句的拼写
		Role searchParm = DAOUtils.buildSearchParam(searchRole);
		System.out.println("这是RoleServiceImpl层的：searchParm：" + searchParm);
		// 查询出符合条件的一共有多少条数据
		Integer count = roleDao.getCount(searchParm);
		// 根据分页的请求信息查询出数量列表
		List<Role> roleList = roleDao.findByPage(DAOUtils.buildPagination(page, limit), searchParm);
		return new LayResult(0, "", count, roleList);
	}

	/**
	 * @Title: updateRole
	 * @Description:(更新数据操作)
	 * @param role
	 * @return
	 */
	@Override
	public Integer updateRole(Role role) {
		Long rowId = role.getRowId();
		Role updateRole = roleDao.get(rowId);
		roleDao.update(DAOUtils.buildEditData(updateRole, role));
		return 1;
	}

}
