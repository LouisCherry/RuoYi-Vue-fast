package com.ruoyi.project.baomu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 作品集合对象 portfolio
 * 
 * @author ruoyi
 * @date 2024-12-22
 */
public class Portfolio extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String personInfoId;

    /** 作品标题 */
    @Excel(name = "作品标题")
    private String title;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String photoUrlId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPersonInfoId(String personInfoId) 
    {
        this.personInfoId = personInfoId;
    }

    public String getPersonInfoId() 
    {
        return personInfoId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setPhotoUrlId(String photoUrlId) 
    {
        this.photoUrlId = photoUrlId;
    }

    public String getPhotoUrlId() 
    {
        return photoUrlId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("personInfoId", getPersonInfoId())
            .append("title", getTitle())
            .append("photoUrlId", getPhotoUrlId())
            .toString();
    }
}
