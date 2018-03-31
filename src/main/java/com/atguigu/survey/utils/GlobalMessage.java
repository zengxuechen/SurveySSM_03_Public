package com.atguigu.survey.utils;

/**
 * 常量类
 * @author zhangyu
 *
 */
public class GlobalMessage {
	
	//guest
	public static final String USER_NAME_ALREADY_EXISTS = "用户名称已经存在，请重新注册!";
	public static final String USER_LOGIN_FAILED = "用户名或密码不匹配，请重新登录!";
	public static final String USER_LOGIN_OPERATION_FORBIDDEN = "用户操作是不允许的，请登录后操作!";
	public static final String FILE_TOO_LARGE = "您上传的文件太大了，不要超过100K!";
	public static final String FILE_TYPE_INVAILID = "请上传图片类型文件!";
	public static final String REMOVE_SURVEY_FAILED = "当前调查内还有包裹，请删除包裹后再删除调查!";
	public static final String SURVEY_EMPTY = "调查为空,不能完成调查!";
	public static final String BAG_EMPTY = "调查内有空的包裹,不能完成调查!";
	public static final String BAG_ORDER_DUPLICATE = "包裹序号存在重复的值!";
	public static final String REMOVE_BAG_FAILED = "当前包裹内有问题，请删除问题后再删除包裹!";
	
	
	//manager
	public static final String ADMIN_LOGIN_FAILED = "账户或密码不匹配，请重新登录!";
	public static final String ADMIN_LOGIN_OPERATION_FORBIDDEN = "后台重地，请勿闯入!请先登录管理员账户!";
	public static final String REMOVE_AUTH_FAILED = "批量删除权限失败!";
	public static final String REMOVE_ROLE_FAILED = "批量删除角色失败!";
	public static final String REMOVE_ADMIN_FAILED = "批量删除账号失败!";
	public static final String HAS_NO_AUTHORITY = "您没有权限访问这个资源!";
	
	
}
