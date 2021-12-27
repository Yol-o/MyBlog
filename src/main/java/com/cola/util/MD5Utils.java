package com.cola.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Bigoted waste
 * @Date 2021/12/15 上午10:28
 * @Version 1.0
 */

public class MD5Utils {

    /**
     * MD5加密类
     * @param str  要加密的字符串
     * @return     加密后的字符串
     */
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if(i<=0)
                    i+=256;
                if(i<16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
            // 16位加密
//            return buf.toString().substring(8,24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(code("111111"));
//    }
}
