package com.ruoyi.project.baomu.service.impl;

import java.util.*;

import com.ruoyi.project.common.domain.FrameAttachinfo;
import com.ruoyi.project.common.mapper.FrameAttachinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.baomu.domain.Portfolio;
import com.ruoyi.project.baomu.mapper.PersonInfoMapper;
import com.ruoyi.project.baomu.domain.PersonInfo;
import com.ruoyi.project.baomu.service.IPersonInfoService;

/**
 * 保姆个人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-22
 */
@Service
public class PersonInfoServiceImpl implements IPersonInfoService 
{
    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Autowired
    private FrameAttachinfoMapper frameAttachinfoMapper;


    /**
     * 查询保姆个人信息
     * 
     * @param id 保姆个人信息主键
     * @return 保姆个人信息
     */
    @Override
    public PersonInfo selectPersonInfoById(String id)
    {
        PersonInfo personInfo = personInfoMapper.selectPersonInfoById(id);
        List<Portfolio> portfolioList = personInfo.getPortfolioList();
        if(portfolioList!=null && portfolioList.size()>0){
            for(Portfolio portfolio : portfolioList){
                Map<String,Object> imagelist = new HashMap<>();
                if(StringUtils.isNotEmpty(portfolio.getPhotoUrlId())){
                    List<FrameAttachinfo> frameAttachinfos = frameAttachinfoMapper.selectFrameAttachinfoListByCliengguid(portfolio.getPhotoUrlId());
                    List<Map<String,String>> list = new ArrayList<>();
                    if(frameAttachinfos!=null && frameAttachinfos.size()>0){
                        for(FrameAttachinfo frameAttachinfo : frameAttachinfos){
                            Map<String,String> nameandurl = new HashMap<>();
                            nameandurl.put("id", frameAttachinfo.getATTACHGUID());
                            nameandurl.put("filename", frameAttachinfo.getAttachfilename());
                            nameandurl.put("url", frameAttachinfo.getFILEPATH() == null ? "" : frameAttachinfo.getFILEPATH());
                            list.add(nameandurl);
                        }
                    }
                    imagelist.put("imagelist",list);
                    portfolio.setParams(imagelist);
                }else{
                    portfolio.setParams(new HashMap<>());
                }

            }
        }
        return personInfo;
    }

    /**
     * 查询保姆个人信息列表
     * 
     * @param personInfo 保姆个人信息
     * @return 保姆个人信息
     */
    @Override
    public List<PersonInfo> selectPersonInfoList(PersonInfo personInfo)
    {
        return personInfoMapper.selectPersonInfoList(personInfo);
    }

    /**
     * 新增保姆个人信息
     * 
     * @param personInfo 保姆个人信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPersonInfo(PersonInfo personInfo)
    {
        if(StringUtils.isBlank(personInfo.getId())){
            personInfo.setId(UUID.randomUUID().toString());
        }
        int rows = personInfoMapper.insertPersonInfo(personInfo);
        insertPortfolio(personInfo);
        return rows;
    }

    /**
     * 修改保姆个人信息
     * 
     * @param personInfo 保姆个人信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePersonInfo(PersonInfo personInfo)
    {
        personInfoMapper.deletePortfolioByPersonInfoId(personInfo.getId());
        insertPortfolio(personInfo);
        return personInfoMapper.updatePersonInfo(personInfo);
    }

    /**
     * 批量删除保姆个人信息
     * 
     * @param ids 需要删除的保姆个人信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePersonInfoByIds(String[] ids)
    {
        personInfoMapper.deletePortfolioByPersonInfoIds(ids);
        return personInfoMapper.deletePersonInfoByIds(ids);
    }

    /**
     * 删除保姆个人信息信息
     * 
     * @param id 保姆个人信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePersonInfoById(String id)
    {
        personInfoMapper.deletePortfolioByPersonInfoId(id);
        return personInfoMapper.deletePersonInfoById(id);
    }

    /**
     * 新增作品集合信息
     * 
     * @param personInfo 保姆个人信息对象
     */
    public void insertPortfolio(PersonInfo personInfo)
    {
        List<Portfolio> portfolioList = personInfo.getPortfolioList();
        String id = personInfo.getId();
        if (StringUtils.isNotNull(portfolioList))
        {
            List<Portfolio> list = new ArrayList<Portfolio>();
            for (Portfolio portfolio : portfolioList)
            {
                portfolio.setPersonInfoId(id);
                list.add(portfolio);
            }
            if (list.size() > 0)
            {
                personInfoMapper.batchPortfolio(list);
            }
        }
    }
}
