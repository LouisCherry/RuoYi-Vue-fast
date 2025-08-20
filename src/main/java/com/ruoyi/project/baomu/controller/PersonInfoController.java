package com.ruoyi.project.baomu.controller;

import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.reflect.ReflectUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Anonymous;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.project.baomu.domain.Certificate;
import com.ruoyi.project.baomu.domain.vo.PublicResumeVO;
import com.ruoyi.project.common.domain.FrameAttachinfo;
import com.ruoyi.project.common.mapper.FrameAttachinfoMapper;
import com.ruoyi.project.common.service.IFrameAttachinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.baomu.domain.PersonInfo;
import com.ruoyi.project.baomu.service.IPersonInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 保姆个人信息Controller
 * 
 * @author ruoyi
 * @date 2024-12-22
 */
@Api(value = "/baomu/personinfo", description = "保姆个人信息")
@RestController
@RequestMapping("/baomu/personinfo")
public class PersonInfoController extends BaseController
{
    @Autowired
    private IPersonInfoService personInfoService;

    @Autowired
    private FrameAttachinfoMapper frameAttachinfoMapper;

    @Autowired
    private ServerConfig serverConfig;
    
    @Autowired
    private IFrameAttachinfoService iframeAttachinfoService;

    /**
     * 查询保姆个人信息列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:personinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PersonInfo personInfo)
    {
        startPage();
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        return getDataTable(list);
    }

    /**
     * 导出保姆个人信息列表
     */
    @PreAuthorize("@ss.hasPermi('baomu:personinfo:export')")
    @Log(title = "保姆个人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PersonInfo personInfo)
    {
        List<PersonInfo> list = personInfoService.selectPersonInfoList(personInfo);
        ExcelUtil<PersonInfo> util = new ExcelUtil<PersonInfo>(PersonInfo.class);
        util.exportExcel(response, list, "保姆个人信息数据");
    }

    /**
     * 获取保姆个人信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('baomu:personinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(personInfoService.selectPersonInfoById(id));
    }

    /**
     * 新增保姆个人信息
     */
    @PreAuthorize("@ss.hasPermi('baomu:personinfo:add')")
    @Log(title = "保姆个人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PersonInfo personInfo)
    {
        return toAjax(personInfoService.insertPersonInfo(personInfo));
    }

    /**
     * 修改保姆个人信息
     */
    @PreAuthorize("@ss.hasPermi('baomu:personinfo:edit')")
    @Log(title = "保姆个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PersonInfo personInfo)
    {
        return toAjax(personInfoService.updatePersonInfo(personInfo));
    }

    /**
     * 删除保姆个人信息
     */
    @PreAuthorize("@ss.hasPermi('baomu:personinfo:remove')")
    @Log(title = "保姆个人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(personInfoService.deletePersonInfoByIds(ids));
    }



    /**
     * 通用上传请求（单个）
     */
    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file,@RequestParam("clientguid") String clientguid, @RequestParam("rowguid") String rowguid, @RequestParam("tag") String tag) throws Exception
    {
        try
        {
            logger.info(clientguid);
            logger.info(rowguid);
            FrameAttachinfo frameAttachinfo = new FrameAttachinfo();
            if(StringUtils.isNotEmpty(rowguid)){
                frameAttachinfo.setATTACHGUID(rowguid);
            }else{
                frameAttachinfo.setATTACHGUID(UUID.randomUUID().toString());
            }
            
            if(StringUtils.isNotEmpty(clientguid)){
                frameAttachinfo.setCLIENGGUID(clientguid);
            }else {
                frameAttachinfo.setCLIENGGUID(frameAttachinfo.getATTACHGUID());
            }
            
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
            String newfilename = FileUtils.getName(fileName);
            ajax.put("newFileName", newfilename);
            ajax.put("originalFilename", file.getOriginalFilename());
            ajax.put("id", rowguid);
            frameAttachinfo.setCONTENTTYPE(FileUtils.getExtName(fileName));
            frameAttachinfo.setATTACHLENGTH(file.getSize());
            if(StringUtils.isNotEmpty(tag)){
                frameAttachinfo.setCLIENGTAG(tag);
            }
            frameAttachinfo.setAttachfilename(newfilename);
            frameAttachinfo.setFILEPATH(fileName);
            frameAttachinfo.setUPLOADDATETIME(new Date());
            // 获取当前的用户
            LoginUser loginUser = SecurityUtils.getLoginUser();
            frameAttachinfo.setUPLOADUSERDISPLAYNAME(loginUser.getUsername());
            frameAttachinfo.setUPLOADUSERGUID(loginUser.getUserId()+"");
            iframeAttachinfoService.insertFrameAttachinfo(frameAttachinfo);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

/*
    */
/**
     * 非隐私简历信息
     *//*

    @ApiOperation("非隐私简历信息")
    @Anonymous
    @GetMapping(value = "/publicresumeinfo/{id}")
    @ApiImplicitParam(name = "id", value = "保姆ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    public AjaxResult publicresumeinfo(@PathVariable("id") String id)
    {
        return success(personInfoService.selectPersonInfoById(id));
    }
*/

    /**
     * 获取公开简历信息接口
     * 用于展示非隐私的个人简历信息，包括基本信息、自我介绍、证书和作品集合
     *
     * @param id 个人信息ID（从路径参数获取）
     * @return AjaxResult 封装的响应结果，包含公开简历信息
     */
    @ApiOperation(value = "获取公开简历信息", notes = "返回非隐私的个人简历信息，供公开展示使用")
    @Anonymous // 允许匿名访问，无需登录
    @GetMapping(value = "/publicresumeinfo/{id}")
    @ApiImplicitParam(
            name = "id",
            value = "个人信息唯一标识ID",
            required = true,
            dataType = "String",
            paramType = "path"
    )
    public AjaxResult publicresumeinfo(@PathVariable("id") String id) {
        // 1. 根据ID查询原始个人信息数据
        PersonInfo personInfo = personInfoService.selectPersonInfoById(id);
        if (personInfo == null) {
            return AjaxResult.error("未找到对应的个人信息");
        }

        // 2. 初始化返回结果对象
        PublicResumeVO result = new PublicResumeVO();

        // 3. 封装个人基本信息
        // 使用反射工具类快速复制同名属性，减少重复的set方法调用
        PublicResumeVO.PersonalInfo personalInfo = new PublicResumeVO.PersonalInfo();
        BeanUtils.copyProperties(personInfo, personalInfo);
        // 单独处理照片URL（原始数据中可能存储的是附件ID，需要转换为完整URL）
        personalInfo.setPhotoUrl(getMainPhotoUrl(personInfo.getAvatar()));
        result.setPersonalInfo(personalInfo);

        // 4. 封装自我介绍（直接使用富文本内容）
        result.setSelfIntroduction(personInfo.getSelfIntroduction());

        // 5. 封装证书列表
        // 从证书集合中提取证书名称，转换为字符串列表
        List<String> certificateNames = Optional.ofNullable(personInfo.getCertificateList())
                .orElse(Collections.emptyList()) // 避免空指针异常
                .stream()
                .map(Certificate::getCertificateName) // 提取证书名称
                .collect(Collectors.toList());
        result.setCertificateList(certificateNames);

        // 6. 封装作品集合
        // 转换作品数据结构，提取标题和照片URL列表
        List<PublicResumeVO.PortfolioVO> portfolioVOS = Optional.ofNullable(personInfo.getPortfolioList())
                .orElse(Collections.emptyList()) // 避免空指针异常
                .stream()
                .map(portfolio -> {
                    PublicResumeVO.PortfolioVO vo = new PublicResumeVO.PortfolioVO();
                    vo.setTitle(portfolio.getTitle());
                    // 获取作品对应的照片URL列表
                    vo.setPhotoUrls(getPortfolioPhotoUrls(portfolio.getPhotoUrlId()));
                    return vo;
                })
                .collect(Collectors.toList());
        result.setPortfolio(portfolioVOS);

        // 7. 返回封装好的结果
        return AjaxResult.success(result);
    }

    /**
     * 获取个人主照片的完整URL
     * 从附件表查询个人主照片，并拼接成可访问的完整URL
     *
     * @param personId 个人信息ID
     * @return String 照片完整URL，若不存在则返回空字符串
     */
    private String getMainPhotoUrl(String personId) {
        // 查询个人主照片附件（假设主照片的标签为"main_photo"）
        FrameAttachinfo query = new FrameAttachinfo();
        query.setATTACHGUID(personId);
        List<FrameAttachinfo> attachinfos = frameAttachinfoMapper.selectFrameAttachinfoList(query);

        // 若存在附件，拼接完整URL（服务器地址 + 文件路径）
        if (attachinfos != null && !attachinfos.isEmpty()) {
            return serverConfig.getUrl() + attachinfos.get(0).getFILEPATH();
        }
        return "";
    }

    /**
     * 获取作品集合的照片URL列表
     * 根据作品关联的附件ID，查询所有照片并返回完整URL列表
     *
     * @param photoUrlId 作品照片的附件关联ID
     * @return List<String> 照片完整URL列表，若不存在则返回空列表
     */
    private List<String> getPortfolioPhotoUrls(String photoUrlId) {
        // 若附件ID为空，直接返回空列表
        if (StringUtils.isEmpty(photoUrlId)) {
            return Collections.emptyList();
        }

        // 查询该作品关联的所有照片附件
        List<FrameAttachinfo> attachinfos = frameAttachinfoMapper.selectFrameAttachinfoListByCliengguid(photoUrlId);

        // 转换为完整URL列表
        return attachinfos.stream()
                .map(attach -> serverConfig.getUrl() + attach.getFILEPATH())
                .collect(Collectors.toList());
    }
}
