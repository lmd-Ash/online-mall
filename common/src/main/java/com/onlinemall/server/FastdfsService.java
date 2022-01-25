package com.onlinemall.server;


import java.io.IOException;
import java.io.InputStream;

/**
 * 文件服务接口
 *
 * @version 1.0
 */
public interface FastdfsService {
    /**
     * 文件上传
     *
     * @param fileBytes 文件字节数组
     * @param extName   文件扩展名
     * @return 成功则返回 文件在服务器的URI
     */
    String uploadFile(byte[] fileBytes, String extName);

    /**
     * 文件上传
     *
     * @param inputStream 文件流
     * @param extName     文件扩展名
     * @return 成功则返回 文件在服务器的URI
     * @throws IOException 异常信息
     */
    String uploadFile(InputStream inputStream, String extName) throws IOException;

    /**
     * 删除文件
     *
     * @param groupName 文件的分组
     * @param fileName  文件的名称
     * @return
     */
    boolean deleteFile(String groupName, String fileName);

    /**
     * 删除文件
     *
     * @param uri 文件的URI
     * @return
     */
    boolean deleteFile(String uri);
}
