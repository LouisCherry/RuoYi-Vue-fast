package com.ruoyi.project.baomu.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Anonymous;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.project.common.domain.FrameAttachinfo;
import com.ruoyi.project.common.service.IFrameAttachinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    /**
     * 非隐私简历信息
     */
    @ApiOperation("非隐私简历信息")
    @Anonymous
    @GetMapping(value = "/publicresumeinfo/{id}")
    @ApiImplicitParam(name = "id", value = "保姆ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    public AjaxResult publicresumeinfo(@PathVariable("id") String id)
    {
        return success(personInfoService.selectPersonInfoById(id));
    }
}
