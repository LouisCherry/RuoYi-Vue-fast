package com.ruoyi.project.baomu.mapper;

import java.util.List;
import com.ruoyi.project.baomu.domain.Certificate;

/**
 * 证书信息Mapper接口
 *
 * @author ruoyi
 * @date 2025-05-26
 */
public interface CertificateMapper
{
    /**
     * 通过个人ID查询证书列表
     * @param personInfoId 个人ID
     * @return 证书列表
     */
    public List<Certificate> selectCertificateByPersonId(String personInfoId);

    /**
     * 批量新增证书
     * @param certificateList 证书列表
     * @return 结果
     */
    public int batchCertificate(List<Certificate> certificateList);

    /**
     * 通过个人ID删除证书
     * @param personInfoId 个人ID
     * @return 结果
     */
    public int deleteCertificateByPersonId(String personInfoId);

    /**
     * 批量删除证书
     * @param ids 证书ID数组
     * @return 结果
     */
    public int deleteCertificateByIds(String[] ids);
}