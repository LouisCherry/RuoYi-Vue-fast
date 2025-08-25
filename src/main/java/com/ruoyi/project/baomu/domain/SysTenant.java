package com.ruoyi.project.baomu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 租户清单对象 sys_tenant
 * 
 * @author louis
 * @date 2025-08-25
 */
public class SysTenant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 用户关联ID（关联sys_user表的user_id） */
    @Excel(name = "用户关联ID", readConverterExp = "关=联sys_user表的user_id")
    private Long userId;

    /** 租户截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "租户截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tenantEndTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setTenantEndTime(Date tenantEndTime) 
    {
        this.tenantEndTime = tenantEndTime;
    }

    public Date getTenantEndTime() 
    {
        return tenantEndTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("tenantEndTime", getTenantEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
