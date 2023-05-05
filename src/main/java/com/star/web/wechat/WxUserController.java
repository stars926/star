// package com.star.web.wechat;
//
// import java.util.List;
//
// import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
// import com.gf.cloud.common.util.QueryWrapperUtils;
// import com.gf.cloud.common.util.Result;
// import com.gf.cloud.excel.util.ExcelUtils;
// import com.gf.cloud.oplog.annotation.Log;
// import com.gf.cloud.oplog.enums.BusinessType;
// import com.gf.cloud.wx.mp.entity.WxMpUserEntity;
// import lombok.RequiredArgsConstructor;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import com.gf.cloud.wx.mp.entity.WxMpUserEntity;
// import com.gf.cloud.wechat.service.WxUserService;
//
// /**
//  * 微信公众号用户 Controller
//  *
//  * @author gf
//  * @date 2023-04-20 17:53:03
//  */
// @Tag(name = "微信公众号用户 ")
// @Validated
// @RestController
// @RequestMapping("/wechat/user")
// @RequiredArgsConstructor
// public class WxUserController {
//
//     private final WxUserService wxUserService;
//
//     @Operation(summary = "微信公众号用户 分页查询")
//     @PreAuthorize("@ss.hasPermi('wechat:user:page')")
//     @GetMapping("/page")
//     public Result queryPage(Page page,WxMpUserEntity wxUser) {
//         return Result.success(wxUserService.page(page, wxUser));
//         // return Result.success(wxUserService.page(page, QueryWrapperUtils.toSimpleQuery(wxUser)));
//     }
//
//     @Operation(summary = "微信公众号用户 导出")
//     @PreAuthorize("@ss.hasPermi('wechat:user:export')")
//     @Log(title = "微信公众号用户 ", businessType = BusinessType.EXPORT)
//     @GetMapping("/export")
//     public void export(WxMpUserEntity wxUser) {
//         List<WxMpUserEntity> list = wxUserService.list(QueryWrapperUtils.toSimpleQuery(wxUser));
//         ExcelUtils.exportExcel(list, "微信公众号用户 数据", WxMpUserEntity.class);
//     }
//
//     @Operation(summary = "微信公众号用户 获取详情")
//     @PreAuthorize("@ss.hasPermi('wechat:user:query')")
//     @GetMapping(value = "/{id}")
//     public Result getInfo(@PathVariable("id") Long id) {
//         return Result.success(wxUserService.getById(id));
//     }
//
//     @Operation(summary = "微信公众号用户 添加")
//     @PreAuthorize("@ss.hasPermi('wechat:user:save')")
//     @Log(title = "微信公众号用户 ", businessType = BusinessType.INSERT)
//     @PostMapping
//     public Result save(@RequestBody WxMpUserEntity wxUser) {
//         return Result.success(wxUserService.save(wxUser));
//     }
//
//     @Operation(summary = "微信公众号用户 更新")
//     @PreAuthorize("@ss.hasPermi('wechat:user:update')")
//     @Log(title = "微信公众号用户 ", businessType = BusinessType.UPDATE)
//     @PutMapping
//     public Result update(@RequestBody WxMpUserEntity wxUser) {
//         return Result.success(wxUserService.updateById(wxUser));
//     }
//
//     @Operation(summary = "微信公众号用户 删除")
//     @PreAuthorize("@ss.hasPermi('wechat:user:delete')")
//     @Log(title = "微信公众号用户 ", businessType = BusinessType.DELETE)
//     @DeleteMapping("/{ids}")
//     public Result delete(@PathVariable List<Long > ids) {
//         return Result.success(wxUserService.removeByIds(ids));
//     }
// }
