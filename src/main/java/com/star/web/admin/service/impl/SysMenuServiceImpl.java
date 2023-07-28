package com.star.web.admin.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.star.web.admin.mapper.SysMenuMapper;
import com.star.web.admin.pojo.po.SysMenu;
import com.star.web.admin.service.SysMenuService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author zt
 * @date 2022/6/23 18:09
 */
@RequiredArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {


	@Override
	public List<String> listPermsByUserId(Long userId) {
		return null;
	}
}
