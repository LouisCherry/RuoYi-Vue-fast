package com.ruoyi.project.common.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 附件对象 frame_attachinfo
 * 
 * @author louis
 * @date 2025-02-01
 */
public class FrameAttachinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String ATTACHGUID;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String attachfilename;

    /** 附件类型 */
    @Excel(name = "附件类型")
    private String CONTENTTYPE;

    /** 附件大小 */
    @Excel(name = "附件大小")
    private Long ATTACHLENGTH;

    /** 附件标签 */
    @Excel(name = "附件标签")
    private String CLIENGTAG;

    /** 附件业务guid */
    private String CLIENGGUID;

    /** 附件路径 */
    @Excel(name = "附件路径")
    private String FILEPATH;

    /** 上传人guid */
    @Excel(name = "上传人guid")
    private String UPLOADUSERGUID;

    /** 上传人名称 */
    @Excel(name = "上传人名称")
    private String UPLOADUSERDISPLAYNAME;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date UPLOADDATETIME;

    public void setATTACHGUID(String ATTACHGUID) 
    {
        this.ATTACHGUID = ATTACHGUID;
    }

    public String getATTACHGUID() 
    {
        return ATTACHGUID;
    }
    public void setAttachfilename(String attachfilename) 
    {
        this.attachfilename = attachfilename;
    }

    public String getAttachfilename() 
    {
        return attachfilename;
    }
    public void setCONTENTTYPE(String CONTENTTYPE) 
    {
        this.CONTENTTYPE = CONTENTTYPE;
    }

    public String getCONTENTTYPE() 
    {
        return CONTENTTYPE;
    }
    public void setATTACHLENGTH(Long ATTACHLENGTH) 
    {
        this.ATTACHLENGTH = ATTACHLENGTH;
    }

    public Long getATTACHLENGTH() 
    {
        return ATTACHLENGTH;
    }
    public void setCLIENGTAG(String CLIENGTAG) 
    {
        this.CLIENGTAG = CLIENGTAG;
    }

    public String getCLIENGTAG() 
    {
        return CLIENGTAG;
    }
    public void setCLIENGGUID(String CLIENGGUID) 
    {
        this.CLIENGGUID = CLIENGGUID;
    }

    public String getCLIENGGUID() 
    {
        return CLIENGGUID;
    }
    public void setFILEPATH(String FILEPATH) 
    {
        this.FILEPATH = FILEPATH;
    }

    public String getFILEPATH() 
    {
        return FILEPATH;
    }
    public void setUPLOADUSERGUID(String UPLOADUSERGUID) 
    {
        this.UPLOADUSERGUID = UPLOADUSERGUID;
    }

    public String getUPLOADUSERGUID() 
    {
        return UPLOADUSERGUID;
    }
    public void setUPLOADUSERDISPLAYNAME(String UPLOADUSERDISPLAYNAME) 
    {
        this.UPLOADUSERDISPLAYNAME = UPLOADUSERDISPLAYNAME;
    }

    public String getUPLOADUSERDISPLAYNAME() 
    {
        return UPLOADUSERDISPLAYNAME;
    }
    public void setUPLOADDATETIME(Date UPLOADDATETIME) 
    {
        this.UPLOADDATETIME = UPLOADDATETIME;
    }

    public Date getUPLOADDATETIME() 
    {
        return UPLOADDATETIME;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ATTACHGUID", getATTACHGUID())
            .append("attachfilename", getAttachfilename())
            .append("CONTENTTYPE", getCONTENTTYPE())
            .append("ATTACHLENGTH", getATTACHLENGTH())
            .append("CLIENGTAG", getCLIENGTAG())
            .append("CLIENGGUID", getCLIENGGUID())
            .append("FILEPATH", getFILEPATH())
            .append("UPLOADUSERGUID", getUPLOADUSERGUID())
            .append("UPLOADUSERDISPLAYNAME", getUPLOADUSERDISPLAYNAME())
            .append("UPLOADDATETIME", getUPLOADDATETIME())
            .toString();
    }
}
