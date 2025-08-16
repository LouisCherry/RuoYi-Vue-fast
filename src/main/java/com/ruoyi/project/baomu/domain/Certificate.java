package com.ruoyi.project.baomu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 证书信息对象 certificate
 *
 * @author ruoyi
 * @date 2025-05-26
 */
public class Certificate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String id;

    /** 所属个人ID */
    @Excel(name = "所属个人ID")
    private String personInfoId;

    /** 证书名称 */
    @Excel(name = "证书名称")
    private String certificateName;

    // getter/setter
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateName() {
        return certificateName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("personInfoId", getPersonInfoId())
                .append("certificateName", getCertificateName())
                .append("createTime", getCreateTime())
                .toString();
    }
}