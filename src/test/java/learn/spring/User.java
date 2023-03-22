package learn.spring;

import com.star.web.admin.pojo.po.SysUser;

/**
 * @author zt
 * @date 2022/10/26 23:37
 */
public class User {
	public static SysUser getUserOne(){
		SysUser sysUser = new SysUser();
		sysUser.setPassword("123123");
		sysUser.setUserId(1L);
		sysUser.setAccount("123456789");
		return sysUser;
	}

	public static SysUser getUserTwo(){
		SysUser sysUser = new SysUser();
		sysUser.setPassword("321321");
		sysUser.setUserId(2L);
		sysUser.setAccount("987654321");
		return sysUser;
	}
	public static SysUser getUserTwoEq(){
		SysUser sysUser = new SysUser();
		sysUser.setPassword("321321");
		sysUser.setUserId(2L);
		sysUser.setAccount("987654321");
		return sysUser;
	}
}
