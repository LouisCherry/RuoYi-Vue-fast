package com.ruoyi.project.common.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.common.mapper.FrameAttachinfoMapper;
import com.ruoyi.project.common.domain.FrameAttachinfo;
import com.ruoyi.project.common.service.IFrameAttachinfoService;

/**
 * 附件Service业务层处理
 * 
 * @author louis
 * @date 2025-02-01
 */
@Service
public class FrameAttachinfoServiceImpl implements IFrameAttachinfoService 
{
    @Autowired
    private FrameAttachinfoMapper frameAttachinfoMapper;

    /**
     * 查询附件
     * 
     * @param ATTACHGUID 附件主键
     * @return 附件
     */
    @Override
    public FrameAttachinfo selectFrameAttachinfoByATTACHGUID(String ATTACHGUID)
    {
        return frameAttachinfoMapper.selectFrameAttachinfoByATTACHGUID(ATTACHGUID);
    }

    /**
     * 查询附件列表
     * 
     * @param frameAttachinfo 附件
     * @return 附件
     */
    @Override
    public List<FrameAttachinfo> selectFrameAttachinfoList(FrameAttachinfo frameAttachinfo)
    {
        return frameAttachinfoMapper.selectFrameAttachinfoList(frameAttachinfo);
    }

    /**
     * 查询附件列表
     *
     * @param CLIENGGUID 附件CLIENGGUID
     * @return 附件
     */
    @Override
    public List<FrameAttachinfo> selectFrameAttachinfoListByCliengguid(String CLIENGGUID)
    {
        return frameAttachinfoMapper.selectFrameAttachinfoListByCliengguid(CLIENGGUID);
    }

    /**
     * 新增附件
     * 
     * @param frameAttachinfo 附件
     * @return 结果
     */
    @Override
    public int insertFrameAttachinfo(FrameAttachinfo frameAttachinfo)
    {
        return frameAttachinfoMapper.insertFrameAttachinfo(frameAttachinfo);
    }

    /**
     * 修改附件
     * 
     * @param frameAttachinfo 附件
     * @return 结果
     */
    @Override
    public int updateFrameAttachinfo(FrameAttachinfo frameAttachinfo)
    {
        return frameAttachinfoMapper.updateFrameAttachinfo(frameAttachinfo);
    }

    /**
     * 批量删除附件
     * 
     * @param ATTACHGUIDs 需要删除的附件主键
     * @return 结果
     */
    @Override
    public int deleteFrameAttachinfoByATTACHGUIDs(String[] ATTACHGUIDs)
    {
        return frameAttachinfoMapper.deleteFrameAttachinfoByATTACHGUIDs(ATTACHGUIDs);
    }

    /**
     * 删除附件信息
     * 
     * @param ATTACHGUID 附件主键
     * @return 结果
     */
    @Override
    public int deleteFrameAttachinfoByATTACHGUID(String ATTACHGUID)
    {
        return frameAttachinfoMapper.deleteFrameAttachinfoByATTACHGUID(ATTACHGUID);
    }
}
