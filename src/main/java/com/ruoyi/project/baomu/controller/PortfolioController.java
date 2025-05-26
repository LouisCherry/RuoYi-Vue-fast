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
import com.ruoyi.project.baomu.domain.Portfolio;
import com.ruoyi.project.baomu.service.IPortfolioService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 作品集合Controller
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
@RestController
@RequestMapping("/baomu/portfolio")
public class PortfolioController extends BaseController
{
    @Autowired
    private IPortfolioService portfolioService;

    /**
     * 查询作品集合列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:portfolio:list')")
    @GetMapping("/list")
    public TableDataInfo list(Portfolio portfolio)
    {
        startPage();
        List<Portfolio> list = portfolioService.selectPortfolioList(portfolio);
        return getDataTable(list);
    }

    /**
     * 导出作品集合列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:portfolio:export')")
    @Log(title = "作品集合", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Portfolio portfolio)
    {
        List<Portfolio> list = portfolioService.selectPortfolioList(portfolio);
        ExcelUtil<Portfolio> util = new ExcelUtil<Portfolio>(Portfolio.class);
        util.exportExcel(response, list, "作品集合数据");
    }

    /**
     * 获取作品集合详细信息
     */
    @PreAuthorize("@ss.hasPermi('baomu:portfolio:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(portfolioService.selectPortfolioById(id));
    }

    /**
     * 新增作品集合
     */
    @PreAuthorize("@ss.hasPermi('baomu:portfolio:add')")
    @Log(title = "作品集合", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Portfolio portfolio)
    {
        return toAjax(portfolioService.insertPortfolio(portfolio));
    }

    /**
     * 修改作品集合
     */
    @PreAuthorize("@ss.hasPermi('baomu:portfolio:edit')")
    @Log(title = "作品集合", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Portfolio portfolio)
    {
        return toAjax(portfolioService.updatePortfolio(portfolio));
    }

    /**
     * 删除作品集合
     */
    @PreAuthorize("@ss.hasPermi('baomu:portfolio:remove')")
    @Log(title = "作品集合", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(portfolioService.deletePortfolioByIds(ids));
    }
}
