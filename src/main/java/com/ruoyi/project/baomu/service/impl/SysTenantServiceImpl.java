package com.ruoyi.project.baomu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.baomu.mapper.SysTenantMapper;
import com.ruoyi.project.baomu.domain.SysTenant;
import com.ruoyi.project.baomu.service.ISysTenantService;

/**
 * 租户清单Service业务层处理
 * 
 * @author louis
 * @date 2025-08-25
 */
@Service
public class SysTenantServiceImpl implements ISysTenantService 
{
    @Autowired
    private SysTenantMapper sysTenantMapper;

    /**
     * 查询租户清单
     * 
     * @param id 租户清单主键
     * @return 租户清单
     */
    @Override
    public SysTenant selectSysTenantById(Long id)
    {
        return sysTenantMapper.selectSysTenantById(id);
    }

    /**
     * 查询租户清单列表
     * 
     * @param sysTenant 租户清单
     * @return 租户清单
     */
    @Override
    public List<SysTenant> selectSysTenantList(SysTenant sysTenant)
    {
        return sysTenantMapper.selectSysTenantList(sysTenant);
    }

    /**
     * 新增租户清单
     * 
     * @param sysTenant 租户清单
     * @return 结果
     */
    @Override
    public int insertSysTenant(SysTenant sysTenant)
    {
        sysTenant.setCreateTime(DateUtils.getNowDate());
        return sysTenantMapper.insertSysTenant(sysTenant);
    }

    /**
     * 修改租户清单
     * 
     * @param sysTenant 租户清单
     * @return 结果
     */
    @Override
    public int updateSysTenant(SysTenant sysTenant)
    {
        sysTenant.setUpdateTime(DateUtils.getNowDate());
        return sysTenantMapper.updateSysTenant(sysTenant);
    }

    /**
     * 批量删除租户清单
     * 
     * @param ids 需要删除的租户清单主键
     * @return 结果
     */
    @Override
    public int deleteSysTenantByIds(Long[] ids)
    {
        return sysTenantMapper.deleteSysTenantByIds(ids);
    }

    /**
     * 删除租户清单信息
     * 
     * @param id 租户清单主键
     * @return 结果
     */
    @Override
    public int deleteSysTenantById(Long id)
    {
        return sysTenantMapper.deleteSysTenantById(id);
    }
}
