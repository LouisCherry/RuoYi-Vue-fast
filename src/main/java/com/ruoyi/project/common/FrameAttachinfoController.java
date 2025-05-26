package com.ruoyi.project.common;

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
import com.ruoyi.project.common.domain.FrameAttachinfo;
import com.ruoyi.project.common.service.IFrameAttachinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 附件Controller
 * 
 * @author louis
 * @date 2025-02-01
 */
@RestController
@RequestMapping("/baomu/attachinfo")
public class FrameAttachinfoController extends BaseController
{
    @Autowired
    private IFrameAttachinfoService frameAttachinfoService;

    /**
     * 查询附件列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:attachinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(FrameAttachinfo frameAttachinfo)
    {
        startPage();
        List<FrameAttachinfo> list = frameAttachinfoService.selectFrameAttachinfoList(frameAttachinfo);
        return getDataTable(list);
    }

    /**
     * 导出附件列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:attachinfo:export')")
    @Log(title = "附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FrameAttachinfo frameAttachinfo)
    {
        List<FrameAttachinfo> list = frameAttachinfoService.selectFrameAttachinfoList(frameAttachinfo);
        ExcelUtil<FrameAttachinfo> util = new ExcelUtil<FrameAttachinfo>(FrameAttachinfo.class);
        util.exportExcel(response, list, "附件数据");
    }

    /**
     * 获取附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('baomu:attachinfo:query')")
    @GetMapping(value = "/{ATTACHGUID}")
    public AjaxResult getInfo(@PathVariable("ATTACHGUID") String ATTACHGUID)
    {
        return success(frameAttachinfoService.selectFrameAttachinfoByATTACHGUID(ATTACHGUID));
    }

    /**
     * 新增附件
     */
    @PreAuthorize("@ss.hasPermi('baomu:attachinfo:add')")
    @Log(title = "附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FrameAttachinfo frameAttachinfo)
    {
        return toAjax(frameAttachinfoService.insertFrameAttachinfo(frameAttachinfo));
    }

    /**
     * 修改附件
     */
    @PreAuthorize("@ss.hasPermi('baomu:attachinfo:edit')")
    @Log(title = "附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FrameAttachinfo frameAttachinfo)
    {
        return toAjax(frameAttachinfoService.updateFrameAttachinfo(frameAttachinfo));
    }

    /**
     * 删除附件
     */
    @PreAuthorize("@ss.hasPermi('baomu:attachinfo:remove')")
    @Log(title = "附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ATTACHGUIDs}")
    public AjaxResult remove(@PathVariable String[] ATTACHGUIDs)
    {
        return toAjax(frameAttachinfoService.deleteFrameAttachinfoByATTACHGUIDs(ATTACHGUIDs));
    }
}
