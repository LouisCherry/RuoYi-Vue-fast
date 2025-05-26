package com.ruoyi.project.common.service;

import java.util.List;
import com.ruoyi.project.common.domain.FrameAttachinfo;

/**
 * 附件Service接口
 * 
 * @author louis
 * @date 2025-02-01
 */
public interface IFrameAttachinfoService 
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

    List<FrameAttachinfo> selectFrameAttachinfoListByCliengguid(String CLIENGGUID);

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
     * 批量删除附件
     * 
     * @param ATTACHGUIDs 需要删除的附件主键集合
     * @return 结果
     */
    public int deleteFrameAttachinfoByATTACHGUIDs(String[] ATTACHGUIDs);

    /**
     * 删除附件信息
     * 
     * @param ATTACHGUID 附件主键
     * @return 结果
     */
    public int deleteFrameAttachinfoByATTACHGUID(String ATTACHGUID);
}
