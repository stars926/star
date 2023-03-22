package com.star.web.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.common.exceptions.BusinessException;
import com.star.common.result.Result;
import com.star.common.validator.group.AddGroup;
import com.star.web.admin.pojo.po.SysRole;
import com.star.web.admin.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zt
 * @date 2022/6/23 18:03
 */
@RestController
@RequestMapping("sys/role")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 分页获取
	 */
	@GetMapping("/page")
//	@PreAuthorize("@pms.hasPermission('sys:role:page')")
	public Result<IPage<SysRole>> page(Page<SysRole> page) {
		IPage<SysRole> sysRole = sysRoleService.page(page);
		return Result.ok(sysRole);
	}

	/**
	 * 新增保存角色
	 */
//	@RequiresPermissions("system:role:add")
//	@PostMapping("/add")
//	public AjaxResult addSave(@Validated(AddGroup.class) SysRole role) {
//		// 判断后大于零
//		if (sysRoleService.count(new LambdaQueryWrapper<SysRole>()
//				.eq(SysRole::getKey, role.getKey())
//				.or()
//				.eq(SysRole::getName, role.getName())) > 0) {
//			throw new BusinessException("新增角色'" + role.getKey() + "'失败，角色名称已存在");
//		}
//		// 清理所有用户授权信息缓存
//		return toAjax(roleService.insertRole(role));
//	}
//
//	/**
//	 * 修改角色
//	 */
//	@RequiresPermissions("system:role:edit")
//	@GetMapping("/edit/{roleId}")
//	public String edit(@PathVariable("roleId") Long roleId, ModelMap mmap)
//	{
//		roleService.checkRoleDataScope(roleId);
//		mmap.put("role", roleService.selectRoleById(roleId));
//		return prefix + "/edit";
//	}
//
//	/**
//	 * 修改保存角色
//	 */
//	@RequiresPermissions("system:role:edit")
//	@Log(title = "角色管理", businessType = BusinessType.UPDATE)
//	@PostMapping("/edit")
//	@ResponseBody
//	public AjaxResult editSave(@Validated Role role)
//	{
//		roleService.checkRoleAllowed(role);
//		roleService.checkRoleDataScope(role.getRoleId());
//		if (UserConstants.ROLE_NAME_NOT_UNIQUE.equals(roleService.checkRoleNameUnique(role)))
//		{
//			return error("修改角色'" + role.getRoleName() + "'失败，角色名称已存在");
//		}
//		else if (UserConstants.ROLE_KEY_NOT_UNIQUE.equals(roleService.checkRoleKeyUnique(role)))
//		{
//			return error("修改角色'" + role.getRoleName() + "'失败，角色权限已存在");
//		}
//		AuthorizationUtils.clearAllCachedAuthorizationInfo();
//		return toAjax(roleService.updateRole(role));
//	}
//
//	/**
//	 * 角色分配数据权限
//	 */
//	@RequiresPermissions("system:role:edit")
//	@GetMapping("/authDataScope/{roleId}")
//	public String authDataScope(@PathVariable("roleId") Long roleId, ModelMap mmap)
//	{
//		mmap.put("role", roleService.selectRoleById(roleId));
//		return prefix + "/dataScope";
//	}
//
//	/**
//	 * 保存角色分配数据权限
//	 */
//	@RequiresPermissions("system:role:edit")
//	@Log(title = "角色管理", businessType = BusinessType.UPDATE)
//	@PostMapping("/authDataScope")
//	@ResponseBody
//	public AjaxResult authDataScopeSave(Role role)
//	{
//		roleService.checkRoleAllowed(role);
//		roleService.checkRoleDataScope(role.getRoleId());
//		if (roleService.authDataScope(role) > 0)
//		{
//			setSysUser(userService.selectUserById(getUserId()));
//			return success();
//		}
//		return error();
//	}
//
//	@RequiresPermissions("system:role:remove")
//	@Log(title = "角色管理", businessType = BusinessType.DELETE)
//	@PostMapping("/remove")
//	@ResponseBody
//	public AjaxResult remove(String ids)
//	{
//		return toAjax(roleService.deleteRoleByIds(ids));
//	}
//
//	/**
//	 * 校验角色名称
//	 */
//	@PostMapping("/checkRoleNameUnique")
//	@ResponseBody
//	public String checkRoleNameUnique(Role role)
//	{
//		return roleService.checkRoleNameUnique(role);
//	}
//
//	/**
//	 * 校验角色权限
//	 */
//	@PostMapping("/checkRoleKeyUnique")
//	@ResponseBody
//	public String checkRoleKeyUnique(Role role)
//	{
//		return roleService.checkRoleKeyUnique(role);
//	}
//
//	/**
//	 * 选择菜单树
//	 */
//	@GetMapping("/selectMenuTree")
//	public String selectMenuTree()
//	{
//		return prefix + "/tree";
//	}
//
//	/**
//	 * 角色状态修改
//	 */
//	@Log(title = "角色管理", businessType = BusinessType.UPDATE)
//	@RequiresPermissions("system:role:edit")
//	@PostMapping("/changeStatus")
//	@ResponseBody
//	public AjaxResult changeStatus(Role role)
//	{
//		roleService.checkRoleAllowed(role);
//		roleService.checkRoleDataScope(role.getRoleId());
//		return toAjax(roleService.changeStatus(role));
//	}
//
//	/**
//	 * 分配用户
//	 */
//	@RequiresPermissions("system:role:edit")
//	@GetMapping("/authUser/{roleId}")
//	public String authUser(@PathVariable("roleId") Long roleId, ModelMap mmap)
//	{
//		mmap.put("role", roleService.selectRoleById(roleId));
//		return prefix + "/authUser";
//	}
//
//	/**
//	 * 查询已分配用户角色列表
//	 */
//	@RequiresPermissions("system:role:list")
//	@PostMapping("/authUser/allocatedList")
//	@ResponseBody
//	public TableDataInfo allocatedList(User user)
//	{
//		startPage();
//		List<User> list = userService.selectAllocatedList(user);
//		return getDataTable(list);
//	}
//
//	/**
//	 * 取消授权
//	 */
//	@RequiresPermissions("system:role:edit")
//	@Log(title = "角色管理", businessType = BusinessType.GRANT)
//	@PostMapping("/authUser/cancel")
//	@ResponseBody
//	public AjaxResult cancelAuthUser(UserRole userRole)
//	{
//		return toAjax(roleService.deleteAuthUser(userRole));
//	}
//
//	/**
//	 * 批量取消授权
//	 */
//	@RequiresPermissions("system:role:edit")
//	@Log(title = "角色管理", businessType = BusinessType.GRANT)
//	@PostMapping("/authUser/cancelAll")
//	@ResponseBody
//	public AjaxResult cancelAuthUserAll(Long roleId, String userIds)
//	{
//		return toAjax(roleService.deleteAuthUsers(roleId, userIds));
//	}
//
//	/**
//	 * 选择用户
//	 */
//	@RequiresPermissions("system:role:list")
//	@GetMapping("/authUser/selectUser/{roleId}")
//	public String selectUser(@PathVariable("roleId") Long roleId, ModelMap mmap)
//	{
//		mmap.put("role", roleService.selectRoleById(roleId));
//		return prefix + "/selectUser";
//	}
//
//	/**
//	 * 查询未分配用户角色列表
//	 */
//	@RequiresPermissions("system:role:list")
//	@PostMapping("/authUser/unallocatedList")
//	@ResponseBody
//	public TableDataInfo unallocatedList(User user)
//	{
//		startPage();
//		List<User> list = userService.selectUnallocatedList(user);
//		return getDataTable(list);
//	}
//
//	/**
//	 * 批量选择用户授权
//	 */
//	@RequiresPermissions("system:role:edit")
//	@Log(title = "角色管理", businessType = BusinessType.GRANT)
//	@PostMapping("/authUser/selectAll")
//	@ResponseBody
//	public AjaxResult selectAuthUserAll(Long roleId, String userIds)
//	{
//		roleService.checkRoleDataScope(roleId);
//		return toAjax(roleService.insertAuthUsers(roleId, userIds));
//	}
}
