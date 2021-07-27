package com.stone.controller;

import com.stone.component.exception.BusinessException;
import com.stone.component.response.ResponseCallBack;
import com.stone.component.response.ResponseCriteria;
import com.stone.component.response.ResponseInfo;
import com.stone.utils.FdfsClient;
import com.stone.utils.ImageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
    public ResponseInfo uploadImgToFastdfs(@RequestParam("file") MultipartFile uploadImg) {
        Assert.notNull(uploadImg, "上传图片文件不能为空");
        return new ResponseCallBack() {
            @Override
            public void execute(ResponseCriteria criteria, Object... obj) {
                if (!ImageUtils.isImgFile(uploadImg))
                    throw new BusinessException(BusinessException.CODE_IMAGE_EXCEPTION, "图片格式不正确");
                criteria.addSingleResult(fdfsClient.uploadFile(uploadImg));
            }
        }.sendRequest();
    }

    @PostMapping(value = "/uploadImageAndCrtThumbImage")
    @ApiOperation(value = "图片上传并获取略缩图", notes = "图片上传并获取略缩图")
    public ResponseInfo uploadImageAndCrtThumbImage(@RequestParam("file") MultipartFile uploadImg) {
        Assert.notNull(uploadImg, "上传图片文件不能为空");
        return new ResponseCallBack() {
            @Override
            public void execute(ResponseCriteria criteria, Object... obj) {
                if (!ImageUtils.isImgFile(uploadImg))
                    throw new BusinessException(BusinessException.CODE_IMAGE_EXCEPTION, "图片格式不正确");
                criteria.addSingleResult(fdfsClient.uploadImageAndCrtThumbImage(uploadImg));
            }
        }.sendRequest();
    }

    @PostMapping(value = "/deleteFile")
    @ApiOperation(value = "删除文件", notes = "删除文件")
    public ResponseInfo deleteFile(@RequestBody List<String> urls) {
        return new ResponseCallBack() {
            @Override
            public void execute(ResponseCriteria criteria, Object... obj) {
                urls.forEach(url->{
                    fdfsClient.deleteFile(url);
                });
//                criteria.addSingleResult();
            }
        }.sendRequest();
    }

    @PostMapping(value = "/imageList")
    @ApiOperation(value = "图片批量上传", notes = "图片批量上传")
    public ResponseInfo uploadImgListToFastdfs(@RequestParam("files") MultipartFile[] uploadImgList) {
        return new ResponseCallBack() {
            @Override
            public void execute(ResponseCriteria criteria, Object... obj) {
                List<String> returnList = new ArrayList<>();
                for(MultipartFile file : uploadImgList){
                    Assert.notNull(file, "上传图片文件不能为空");
                    if (!ImageUtils.isImgFile(file))
                        throw new BusinessException(BusinessException.CODE_IMAGE_EXCEPTION, "图片格式不正确");
                    returnList.add(fdfsClient.uploadFile(file));
                }
                criteria.addSingleResult(returnList);
            }
        }.sendRequest();
    }

    @PostMapping(value = "/file")
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public ResponseInfo uploadFilesToFastdfs(@RequestParam("file") MultipartFile file) {
        Assert.notNull(file, "上传文件不能为空");
        return new ResponseCallBack() {
            public void execute(ResponseCriteria criteria, Object... obj) {
                if (null != file) {
                    criteria.addSingleResult(fdfsClient.uploadFile(file));
                }
            }
        }.sendRequest();
    }

}