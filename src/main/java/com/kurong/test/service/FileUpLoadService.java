package com.kurong.test.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.kurong.test.config.Aliconfig;
import com.kurong.test.bean.FileUploadResult;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class FileUpLoadService {

    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",
            ".jpeg", ".gif", ".png"};
    @Autowired
    private OSS ossClient;
    @Autowired
    private Aliconfig aliyunConfig;

    /**
     * 文件上传
     *
     * @param uploadFile
     * @return
     */
    public String upload(MultipartFile uploadFile) throws IOException{
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(),
                    type)) {
                isLegal = true;
                break;
            }
        }
        isLegal = true;
        //封装Result对象，并且将文件的byte数组放置到result对象中
        FileUploadResult fileUploadResult = new FileUploadResult();
        if (!isLegal) {
            fileUploadResult.setStatus("error");
            return "error";
        }
        //文件新路径
        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName);

        // 上传到阿里云
        try {
            ossClient.putObject(aliyunConfig.getBucketName(), filePath, new
                    ByteArrayInputStream(uploadFile.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            //上传失败
            fileUploadResult.setStatus("error");
            return "error";
        }
        fileUploadResult.setStatus("done");
        fileUploadResult.setResponse("success");
        // this.aliyunConfig.getUrlPrefix() + filePath 文件路径需要保存到数据库
        fileUploadResult.setName(this.aliyunConfig.getUrlPrefix() + filePath);
        return this.aliyunConfig.getUrlPrefix() + "/" + filePath;
    }

    /**
     * 通过源文件获取 路径和文件名
     *
     * @param sourceFileName
     * @return
     */
    private String getFilePath(String sourceFileName) {
        DateTime dateTime = new DateTime();
        String filePath = "images/" + dateTime.toString("yyyy")
                + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis() +
                RandomUtils.nextInt(100, 9999) + "." +
                StringUtils.substringAfterLast(sourceFileName, ".");
        return filePath;
    }

    /**
     * 查看文件列表
     *
     * @return
     */
    public List<OSSObjectSummary> list() {
        // 设置最大个数。
        final int maxKeys = 200;
        // 列举文件。
        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(aliyunConfig.getBucketName()).withMaxKeys(maxKeys));
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        return sums;
    }

    /**
     * @desc 删除文件
     */
    public FileUploadResult delete(String objectName) {
        // 根据BucketName,objectName删除文件
        ossClient.deleteObject(aliyunConfig.getBucketName(), objectName);
        FileUploadResult fileUploadResult = new FileUploadResult();
        fileUploadResult.setName(objectName);
        fileUploadResult.setStatus("removed");
        fileUploadResult.setResponse("success");
        return fileUploadResult;
    }

    /**
     * 下载文件
     *
     * @param os
     * @param objectName
     * @throws IOException
     */
    public void exportOssFile(OutputStream os, String objectName) throws IOException {
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(aliyunConfig.getBucketName(), objectName);
        // 读取文件内容。
        BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
        BufferedOutputStream out = new BufferedOutputStream(os);
        byte[] buffer = new byte[1024];
        int lenght = 0;
        while ((lenght = in.read(buffer)) != -1) {
            out.write(buffer, 0, lenght);
        }
        if (out != null) {
            out.flush();
            out.close();
        }
        if (in != null) {
            in.close();
        }
    }
}
