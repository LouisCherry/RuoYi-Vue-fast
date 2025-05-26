package com.ruoyi.project.baomu.service;

import java.util.List;
import com.ruoyi.project.baomu.domain.PersonInfo;

/**
 * 保姆个人信息Service接口
 * 
 * @author ruoyi
 * @date 2024-12-22
 */
public interface IPersonInfoService 
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
     * 批量删除保姆个人信息
     * 
     * @param ids 需要删除的保姆个人信息主键集合
     * @return 结果
     */
    public int deletePersonInfoByIds(String[] ids);

    /**
     * 删除保姆个人信息信息
     * 
     * @param id 保姆个人信息主键
     * @return 结果
     */
    public int deletePersonInfoById(String id);
}
