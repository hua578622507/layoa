package com.situ.layoa.util;

import java.io.Serializable;

/**
 * 系统配置信息
 * 
 * @author wxinpeng
 *
 */
public class ConfigUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户购物车-session object 名称
	public static final String SESSION_USER_CART = "userCart";
	// 用户登录-session object 名称
	public static final String SESSION_USER_LOGIN = "userLogin";
	// 管理员登录-session object 名称
	public static final String SESSION_ADMIN_LOGIN = "adminLogin";
	// 用户的收藏 商品CODE集合
	public static final String SESSION_USER_WISH_PRO_LIST = "userWishProList";

	// 用户登录- cookie name
	public static final String COOKIE_USER_NAME = "user.reiz.com";
	//
	public static final String COOKIE_ADMIN_NAME = "admin.reiz.com";

	public static final String SYS = "sys";
	//默认的存放 文件的路径
	public static final String DEFAULT_FILE_PATH = "assets/uploads/";

	//写出文件的默认路径
	public static final String FILE_BASE_PATH = "E:/webfiles/reiz/";
	//商品的基本路径
	public static final String PRODUCT_BASE_PATH = "filereiz/product/";

}
