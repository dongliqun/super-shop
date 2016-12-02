package com.fengze.shop.utils;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密 16位
 *
 * @author zhanglingsi
 *         createTime: 2016/11/13 18:39
 */
public class MD5Utils {

    private final static char[] hexDigits = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        int t;
        for (int i = 0; i < 16; i++) {
            t = bytes[i];
            if (t < 0)
                t += 256;
            sb.append(hexDigits[(t >>> 4)]);
            sb.append(hexDigits[(t % 16)]);
        }
        return sb.toString();
    }

    public static String Md5Encode(String input) throws Exception {
        return code(input, 16);
    }

    public static String code(String input, int bit) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance(System.getProperty(
                    "MD5.algorithm", "MD5"));
            if (bit == 16)
                return bytesToHex(md.digest(input.getBytes("utf-8")))
                        .substring(8, 24);
            return bytesToHex(md.digest(input.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new Exception("Could not found MD5 algorithm.", e);
        }
    }

    public static String md5_3(String b) throws Exception {
        MessageDigest md = MessageDigest.getInstance(System.getProperty(
                "MD5.algorithm", "MD5"));
        byte[] a = md.digest(b.getBytes());
        a = md.digest(a);
        a = md.digest(a);

        return bytesToHex(a);
    }

    /**
     * @param origin
     * @return
     * @author shenbobo
     */
    public static String MD5Encode(String origin) {
        return MD5Encode(origin, null);
    }

    /**
     * MD5添加
     *
     * @param origin
     * @param charSetName
     * @return
     * @author shenbobo
     */
    public static String MD5Encode(String origin, String charSetName) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (StringUtils.isEmpty(charSetName)) {
                resultString = bytesToHex(md.digest(
                        resultString.getBytes()));
            } else {
                resultString = bytesToHex(md.digest(
                        resultString.getBytes(charSetName)));
            }
        } catch (Exception localException) {
        }
        return resultString;
    }
}