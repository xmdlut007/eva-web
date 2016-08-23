package com.cn.xm.common.utils;

import java.util.UUID;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月23日 下午9:14:05 生成随机数
 */
public class RandomUtil {
    /**
     * 随机生成 num位数字字符数组
     * 
     * @param num
     * @return
     */
    public static char[] generateRandomArray(int num) {
        String chars = "0123456789";
        char[] rands = new char[num];
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * 10);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }
    public static String generateRandomDigStr(int num) {
        if (num <= 0) {
            return null;
        } else {
            return new String(generateRandomArray(num));
        }
    }
    /*
     * 生成uuid
     */
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public static void main(String[] args) {
        System.out.println(generateRandomArray(6));
        System.out.println(generateUUID());

    }

}
