package com.ruoyi.project.baomu.service;

import java.util.List;
import com.ruoyi.project.baomu.domain.Portfolio;

/**
 * 作品集合Service接口
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public interface IPortfolioService 
{
    /**
     * 查询作品集合
     * 
     * @param id 作品集合主键
     * @return 作品集合
     */
    public Portfolio selectPortfolioById(Long id);

    /**
     * 查询作品集合列表
     * 
     * @param portfolio 作品集合
     * @return 作品集合集合
     */
    public List<Portfolio> selectPortfolioList(Portfolio portfolio);

    /**
     * 新增作品集合
     * 
     * @param portfolio 作品集合
     * @return 结果
     */
    public int insertPortfolio(Portfolio portfolio);

    /**
     * 修改作品集合
     * 
     * @param portfolio 作品集合
     * @return 结果
     */
    public int updatePortfolio(Portfolio portfolio);

    /**
     * 批量删除作品集合
     * 
     * @param ids 需要删除的作品集合主键集合
     * @return 结果
     */
    public int deletePortfolioByIds(Long[] ids);

    /**
     * 删除作品集合信息
     * 
     * @param id 作品集合主键
     * @return 结果
     */
    public int deletePortfolioById(Long id);
}
