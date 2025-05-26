package com.ruoyi.project.baomu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.baomu.mapper.PortfolioMapper;
import com.ruoyi.project.baomu.domain.Portfolio;
import com.ruoyi.project.baomu.service.IPortfolioService;

/**
 * 作品集合Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
@Service
public class PortfolioServiceImpl implements IPortfolioService 
{
    @Autowired
    private PortfolioMapper portfolioMapper;

    /**
     * 查询作品集合
     * 
     * @param id 作品集合主键
     * @return 作品集合
     */
    @Override
    public Portfolio selectPortfolioById(Long id)
    {
        return portfolioMapper.selectPortfolioById(id);
    }

    /**
     * 查询作品集合列表
     * 
     * @param portfolio 作品集合
     * @return 作品集合
     */
    @Override
    public List<Portfolio> selectPortfolioList(Portfolio portfolio)
    {
        return portfolioMapper.selectPortfolioList(portfolio);
    }

    /**
     * 新增作品集合
     * 
     * @param portfolio 作品集合
     * @return 结果
     */
    @Override
    public int insertPortfolio(Portfolio portfolio)
    {
        return portfolioMapper.insertPortfolio(portfolio);
    }

    /**
     * 修改作品集合
     * 
     * @param portfolio 作品集合
     * @return 结果
     */
    @Override
    public int updatePortfolio(Portfolio portfolio)
    {
        return portfolioMapper.updatePortfolio(portfolio);
    }

    /**
     * 批量删除作品集合
     * 
     * @param ids 需要删除的作品集合主键
     * @return 结果
     */
    @Override
    public int deletePortfolioByIds(Long[] ids)
    {
        return portfolioMapper.deletePortfolioByIds(ids);
    }

    /**
     * 删除作品集合信息
     * 
     * @param id 作品集合主键
     * @return 结果
     */
    @Override
    public int deletePortfolioById(Long id)
    {
        return portfolioMapper.deletePortfolioById(id);
    }
}
