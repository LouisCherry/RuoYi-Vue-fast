package com.ruoyi.project.baomu.domain.vo;

import lombok.Data;
import java.util.List;

/**
 * 公共简历信息VO
 */
@Data
public class PublicResumeVO {
    private PersonalInfo personalInfo;
    private String selfIntroduction;
    private List<String> certificateList;
    private List<PortfolioVO> portfolio;

    /**
     * 个人基本信息子VO
     */
    @Data
    public static class PersonalInfo {
        private String fullName;
        private String occupation;
        private String salaryRange;
        private Long age;
        private String zodiac;
        private String province;
        private String ethnicGroup;
        private String constellation;
        private String education;
        private String phone;
        private String workExperience;
        private String skillsAndStrengths;
        private String photoUrl; // 需确认照片存储逻辑，这里假设从附件表获取
    }

    /**
     * 作品集合子VO
     */
    @Data
    public static class PortfolioVO {
        private String title;
        private List<String> photoUrls;
    }
}