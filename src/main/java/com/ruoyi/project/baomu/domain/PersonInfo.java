package com.ruoyi.project.baomu.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 保姆个人信息对象 person_info
 * 
 * @author ruoyi
 * @date 2024-12-22
 */
public class PersonInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一ID */
    private String id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String fullName;

    /** 职业类型 */
    @Excel(name = "职业类型")
    private String occupation;

    /** 薪资范畴 */
    @Excel(name = "薪资范畴")
    private String salaryRange;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 生肖 */
    @Excel(name = "生肖")
    private String zodiac;

    /** 所在省份 */
    @Excel(name = "所在省份")
    private String province;

    /** 民族 */
    @Excel(name = "民族")
    private String ethnicGroup;

    /** 星座 */
    @Excel(name = "星座")
    private String constellation;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 工作经验 */
    @Excel(name = "工作经验")
    private String workExperience;

    /** 技能与优势 */
    @Excel(name = "技能与优势")
    private String skillsAndStrengths;

    /** 自我介绍 */
    @Excel(name = "自我介绍")
    private String selfIntroduction;

    /** 作品集合信息 */
    private List<Portfolio> portfolioList;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setFullName(String fullName) 
    {
        this.fullName = fullName;
    }

    public String getFullName() 
    {
        return fullName;
    }
    public void setOccupation(String occupation) 
    {
        this.occupation = occupation;
    }

    public String getOccupation() 
    {
        return occupation;
    }
    public void setSalaryRange(String salaryRange) 
    {
        this.salaryRange = salaryRange;
    }

    public String getSalaryRange() 
    {
        return salaryRange;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setZodiac(String zodiac) 
    {
        this.zodiac = zodiac;
    }

    public String getZodiac() 
    {
        return zodiac;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setEthnicGroup(String ethnicGroup) 
    {
        this.ethnicGroup = ethnicGroup;
    }

    public String getEthnicGroup() 
    {
        return ethnicGroup;
    }
    public void setConstellation(String constellation) 
    {
        this.constellation = constellation;
    }

    public String getConstellation() 
    {
        return constellation;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setWorkExperience(String workExperience) 
    {
        this.workExperience = workExperience;
    }

    public String getWorkExperience() 
    {
        return workExperience;
    }
    public void setSkillsAndStrengths(String skillsAndStrengths) 
    {
        this.skillsAndStrengths = skillsAndStrengths;
    }

    public String getSkillsAndStrengths() 
    {
        return skillsAndStrengths;
    }
    public void setSelfIntroduction(String selfIntroduction) 
    {
        this.selfIntroduction = selfIntroduction;
    }

    public String getSelfIntroduction() 
    {
        return selfIntroduction;
    }

    public List<Portfolio> getPortfolioList()
    {
        return portfolioList;
    }

    public void setPortfolioList(List<Portfolio> portfolioList)
    {
        this.portfolioList = portfolioList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fullName", getFullName())
            .append("occupation", getOccupation())
            .append("salaryRange", getSalaryRange())
            .append("age", getAge())
            .append("zodiac", getZodiac())
            .append("province", getProvince())
            .append("ethnicGroup", getEthnicGroup())
            .append("constellation", getConstellation())
            .append("education", getEducation())
            .append("phone", getPhone())
            .append("workExperience", getWorkExperience())
            .append("skillsAndStrengths", getSkillsAndStrengths())
            .append("selfIntroduction", getSelfIntroduction())
            .append("portfolioList", getPortfolioList())
            .toString();
    }
}
