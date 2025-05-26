package com.ruoyi.project.common.mapper;

import java.util.List;
import com.ruoyi.project.common.domain.FrameAttachinfo;

/**
 * 附件Mapper接口
 * 
 * @author louis
 * @date 2025-02-01
 */
public interface FrameAttachinfoMapper 
{
    /**
     * 查询附件
     * 
     * @param ATTACHGUID 附件主键
     * @return 附件
     */
    public FrameAttachinfo selectFrameAttachinfoByATTACHGUID(String ATTACHGUID);

    /**
     * 查询附件列表
     * 
     * @param frameAttachinfo 附件
     * @return 附件集合
     */
    public List<FrameAttachinfo> selectFrameAttachinfoList(FrameAttachinfo frameAttachinfo);

    /**
     * 查询附件列表
     *
     * @param CLIENGGUID 附件CLIENGGUID
     * @return 附件集合
     */
    public List<FrameAttachinfo> selectFrameAttachinfoListByCliengguid(String CLIENGGUID);

    /**
     * 新增附件
     * 
     * @param frameAttachinfo 附件
     * @return 结果
     */
    public int insertFrameAttachinfo(FrameAttachinfo frameAttachinfo);

    /**
     * 修改附件
     * 
     * @param frameAttachinfo 附件
     * @return 结果
     */
    public int updateFrameAttachinfo(FrameAttachinfo frameAttachinfo);

    /**
     * 删除附件
     * 
     * @param ATTACHGUID 附件主键
     * @return 结果
     */
    public int deleteFrameAttachinfoByATTACHGUID(String ATTACHGUID);

    /**
     * 批量删除附件
     * 
     * @param ATTACHGUIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFrameAttachinfoByATTACHGUIDs(String[] ATTACHGUIDs);
}
