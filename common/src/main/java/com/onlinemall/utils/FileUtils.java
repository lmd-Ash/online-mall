package com.onlinemall.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件工具类
 *
 * @author 11923
 */
public class FileUtils {

    /**
     * 获取文件后缀
     *
     * @param filename 文件名
     * @return 返回文件后缀
     */
    public static String getSuffixName(String filename) {
        if (StringUtils.isBlank(filename)) {
            return null;
        }
        int index = filename.lastIndexOf(".");
        return index == -1 ? null : filename.substring(index + 1);
    }

    /**
     * 判断是否是图片
     *
     * @param suffixName 文件后缀名
     * @return 返回是/否
     */
    public static boolean isImg(String suffixName) {
        if (StringUtils.isBlank(suffixName)) {
            return false;
        }
        switch (suffixName) {
            case "jpg":
            case "jpeg":
            case "png":
            case "gif":
                return true;
            default:
                return false;
        }
    }

}
