package com.stone.controller;

import com.stone.component.enums.ReturnCodeEnum;
import com.stone.component.exception.BusinessException;
import com.stone.component.response.ResponseInfo;
import com.stone.controller.vo.ImgPathVo;
import com.stone.utils.FdfsClient;
import com.stone.utils.ImageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: stone
 * @Date: 2021/3/24 15:53
 */
@RestController
@Api(value = "文件上传接口",description = "文件上传接口")
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private FdfsClient fdfsClient;

    @PostMapping(value = "/image")
    @ApiOperation(value = "图片上传", notes = "图片上传")
    public String uploadImgToFastdfs(@RequestParam("file") MultipartFile uploadImg) {
        Assert.notNull(uploadImg, "上传图片文件不能为空");
        if (!ImageUtils.isImgFile(uploadImg))
            throw new BusinessException(ReturnCodeEnum.IMAGE_FORMAT_ERROR);
        return fdfsClient.uploadFile(uploadImg);
    }

    @PostMapping(value = "/uploadImageAndCrtThumbImage")
    @ApiOperation(value = "图片上传并获取略缩图", notes = "图片上传并获取略缩图")
    public ImgPathVo uploadImageAndCrtThumbImage(@RequestParam("file") MultipartFile uploadImg) {
        Assert.notNull(uploadImg, "上传图片文件不能为空");
        if (!ImageUtils.isImgFile(uploadImg))
            throw new BusinessException(ReturnCodeEnum.IMAGE_FORMAT_ERROR);
        return fdfsClient.uploadImageAndCrtThumbImage(uploadImg);
    }

    @PostMapping(value = "/deleteFile")
    @ApiOperation(value = "删除文件", notes = "删除文件")
    public String deleteFile(@RequestBody List<String> urls) {
        if(!CollectionUtils.isEmpty(urls)){
            throw new BusinessException(ReturnCodeEnum.INFO_INCOMPLETE);
        }
        urls.forEach(url->{
            fdfsClient.deleteFile(url);
        });
        return "删除成功";
    }

    @PostMapping(value = "/imageList")
    @ApiOperation(value = "图片批量上传", notes = "图片批量上传")
    public List<String> uploadImgListToFastdfs(@RequestParam("files") MultipartFile[] uploadImgList) {
        List<String> returnList = new ArrayList<>();
        for(MultipartFile file : uploadImgList){
            Assert.notNull(file, "上传图片文件不能为空");
            if (!ImageUtils.isImgFile(file))
                throw new BusinessException(ReturnCodeEnum.IMAGE_FORMAT_ERROR);
            returnList.add(fdfsClient.uploadFile(file));
        }
        return returnList;
    }

    @PostMapping(value = "/file")
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public String uploadFilesToFastdfs(@RequestParam("file") MultipartFile file) {
        Assert.notNull(file, "上传文件不能为空");
        return fdfsClient.uploadFile(file);
    }
}