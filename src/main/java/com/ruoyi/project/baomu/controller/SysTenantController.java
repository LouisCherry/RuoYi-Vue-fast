package com.ruoyi.project.baomu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.baomu.domain.SysTenant;
import com.ruoyi.project.baomu.service.ISysTenantService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 租户清单Controller
 * 
 * @author louis
 * @date 2025-08-25
 */
@RestController
@RequestMapping("/baomu/tenant")
public class SysTenantController extends BaseController
{
    @Autowired
    private ISysTenantService sysTenantService;

    /**
     * 查询租户清单列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:tenant:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTenant sysTenant)
    {
        startPage();
        List<SysTenant> list = sysTenantService.selectSysTenantList(sysTenant);
        return getDataTable(list);
    }

    /**
     * 导出租户清单列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:tenant:export')")
    @Log(title = "租户清单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTenant sysTenant)
    {
        List<SysTenant> list = sysTenantService.selectSysTenantList(sysTenant);
        ExcelUtil<SysTenant> util = new ExcelUtil<SysTenant>(SysTenant.class);
        util.exportExcel(response, list, "租户清单数据");
    }

    /**
     * 获取租户清单详细信息
     */
    @PreAuthorize("@ss.hasPermi('baomu:tenant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysTenantService.selectSysTenantById(id));
    }

    /**
     * 新增租户清单
     */
    @PreAuthorize("@ss.hasPermi('baomu:tenant:add')")
    @Log(title = "租户清单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTenant sysTenant)
    {
        return toAjax(sysTenantService.insertSysTenant(sysTenant));
    }

    /**
     * 修改租户清单
     */
    @PreAuthorize("@ss.hasPermi('baomu:tenant:edit')")
    @Log(title = "租户清单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTenant sysTenant)
    {
        return toAjax(sysTenantService.updateSysTenant(sysTenant));
    }

    /**
     * 删除租户清单
     */
    @PreAuthorize("@ss.hasPermi('baomu:tenant:remove')")
    @Log(title = "租户清单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysTenantService.deleteSysTenantByIds(ids));
    }
}
