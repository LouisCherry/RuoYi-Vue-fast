package com.ruoyi.project.baomu.mapper;

import java.util.List;
import com.ruoyi.project.baomu.domain.Portfolio;

/**
 * 作品集合Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public interface PortfolioMapper 
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
     * 删除作品集合
     * 
     * @param id 作品集合主键
     * @return 结果
     */
    public int deletePortfolioById(Long id);

    /**
     * 批量删除作品集合
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortfolioByIds(Long[] ids);
}
