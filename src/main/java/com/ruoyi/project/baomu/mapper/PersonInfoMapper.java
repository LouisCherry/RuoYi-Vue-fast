package com.ruoyi.project.baomu.mapper;

import java.util.List;
import com.ruoyi.project.baomu.domain.PersonInfo;
import com.ruoyi.project.baomu.domain.Portfolio;

/**
 * 保姆个人信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-22
 */
public interface PersonInfoMapper 
{
    /**
     * 查询保姆个人信息
     * 
     * @param id 保姆个人信息主键
     * @return 保姆个人信息
     */
    public PersonInfo selectPersonInfoById(String id);

    /**
     * 查询保姆个人信息列表
     * 
     * @param personInfo 保姆个人信息
     * @return 保姆个人信息集合
     */
    public List<PersonInfo> selectPersonInfoList(PersonInfo personInfo);

    /**
     * 新增保姆个人信息
     * 
     * @param personInfo 保姆个人信息
     * @return 结果
     */
    public int insertPersonInfo(PersonInfo personInfo);

    /**
     * 修改保姆个人信息
     * 
     * @param personInfo 保姆个人信息
     * @return 结果
     */
    public int updatePersonInfo(PersonInfo personInfo);

    /**
     * 删除保姆个人信息
     * 
     * @param id 保姆个人信息主键
     * @return 结果
     */
    public int deletePersonInfoById(String id);

    /**
     * 批量删除保姆个人信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePersonInfoByIds(String[] ids);

    /**
     * 批量删除作品集合
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortfolioByPersonInfoIds(String[] ids);
    
    /**
     * 批量新增作品集合
     * 
     * @param portfolioList 作品集合列表
     * @return 结果
     */
    public int batchPortfolio(List<Portfolio> portfolioList);
    

    /**
     * 通过保姆个人信息主键删除作品集合信息
     * 
     * @param id 保姆个人信息ID
     * @return 结果
     */
    public int deletePortfolioByPersonInfoId(String id);
}
