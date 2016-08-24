package com.cn.xm.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月24日 上午11:38:30
 */
public class PasswordUtil {

    private final static String SHA_256 = "SHA-256";
    private final static String SHA_512 = "SHA-512";
    private final static String SEP_STR = "$";

    // 加密用户密码 存入DB
    public static String encodeLoginPassword(String rawPassword) {
        String salt = RandomUtil.generateRandomAscii(32);
        String encodePassword = encodePassword(salt, rawPassword);
        return encodePassword;
    }
    // 使用原始密码和数据库存放的密码进行校验
    public static boolean checkLoginPassword(String rawPassword, String encPassword) {
        if (StringUtils.isBlank(rawPassword) || StringUtils.isBlank(encPassword) || !encPassword.contains(SEP_STR)) {
            return false;
        }
        String v[] = encPassword.split("\\" + SEP_STR);
        if (v.length != 2) {
            return false;
        }
        String salt = v[0];
        String encodePassword = encodePassword(salt, rawPassword);
        return encodePassword.equals(encPassword);
    }
    public static String encodePassword(String salt, String rawPassword) {
        String data = String.format("%s%s", salt, rawPassword);
        String hash = shaAlgorithm(data, SHA_256);
        String encPassword = String.format("%s" + SEP_STR + "%s", salt, hash);
        return encPassword;
    }
    /**
     * 字符串 SHA 加密
     * 
     * @param strSourceText
     * @return
     */
    public static String shaAlgorithm(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }

    public static void main(String[] args) {
        String rawPassword = "hello";
        System.out.println(encodeLoginPassword(rawPassword));
        System.out.println(checkLoginPassword(rawPassword, encodeLoginPassword(rawPassword)));
    }
}
