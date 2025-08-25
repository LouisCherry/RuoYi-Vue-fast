package com.ruoyi.project.baomu.service;

import java.util.List;
import com.ruoyi.project.baomu.domain.SysTenant;

/**
 * 租户清单Service接口
 * 
 * @author louis
 * @date 2025-08-25
 */
public interface ISysTenantService 
{
    /**
     * 查询租户清单
     * 
     * @param id 租户清单主键
     * @return 租户清单
     */
    public SysTenant selectSysTenantById(Long id);

    /**
     * 查询租户清单列表
     * 
     * @param sysTenant 租户清单
     * @return 租户清单集合
     */
    public List<SysTenant> selectSysTenantList(SysTenant sysTenant);

    /**
     * 新增租户清单
     * 
     * @param sysTenant 租户清单
     * @return 结果
     */
    public int insertSysTenant(SysTenant sysTenant);

    /**
     * 修改租户清单
     * 
     * @param sysTenant 租户清单
     * @return 结果
     */
    public int updateSysTenant(SysTenant sysTenant);

    /**
     * 批量删除租户清单
     * 
     * @param ids 需要删除的租户清单主键集合
     * @return 结果
     */
    public int deleteSysTenantByIds(Long[] ids);

    /**
     * 删除租户清单信息
     * 
     * @param id 租户清单主键
     * @return 结果
     */
    public int deleteSysTenantById(Long id);
}
