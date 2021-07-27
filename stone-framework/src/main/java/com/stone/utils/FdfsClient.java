package com.stone.utils;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.stone.controller.vo.ImgPathVo;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class FdfsClient {
    private final Logger logger = LoggerFactory.getLogger(FdfsClient.class);

    @Autowired(required = false)
    private FastFileStorageClient storageClient;
    @Autowired
    private ThumbImageConfig thumbImageConfig;
    @Value("${fdfs.nginx-ip}")
    private String nginxIp;
    @Value("${fdfs.nginx-port}")
    private String nginxPort;

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) {
        StorePath storePath;
        String path = null;
        try {
            storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            path = storePath.getFullPath();
            logger.info("上传文件{}成功!", file.getOriginalFilename());
        } catch (IOException e) {
            logger.error("上传文件异常!", e);
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        path = sb.append("http://").append(nginxIp).append(":").append(nginxPort).append("/").append(path).toString();
        return path;
    }

    /**
     * 传图片并同时生成一个缩略图
     * "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP"
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public ImgPathVo uploadImageAndCrtThumbImage(MultipartFile file) {
        StorePath storePath = null;
        try {
            storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),
                    FilenameUtils.getExtension(file.getOriginalFilename()), null);
            logger.info("上传文件{}成功!", file.getOriginalFilename());
        } catch (IOException e) {
            logger.error("上传文件异常!", e);
            e.printStackTrace();
        }
        ImgPathVo imgPathVo = new ImgPathVo();
        // 获取缩略图路径
        StringBuffer thumbSb = new StringBuffer();
        String thumbPath = thumbSb.append("http://")
                .append(nginxIp).append(":")
                .append(nginxPort).append("/")
                .append(storePath.getGroup()).append("/")
                .append(thumbImageConfig.getThumbImagePath(storePath.getPath())).toString();
        imgPathVo.setThumbPath(thumbPath);
        //获取全路径
        StringBuffer fullSb = new StringBuffer();
        String fullPath = fullSb.append("http://")
                .append(nginxIp).append(":")
                .append(nginxPort).append("/")
                .append(storePath.getFullPath()).toString();
        imgPathVo.setFullPath(fullPath);
        return imgPathVo;
    }

    /**
     * 将一段字符串生成一个文件上传
     *
     * @param content       文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return storePath.getFullPath();
    }

    /**
     * 删除文件
     *
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }
}
