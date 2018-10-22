package com.tencent.encrption;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * 原理:https://blog.csdn.net/u012611878/article/details/54000607
 * 生成的散列值为128 bit,16Byte,32个16进制字符(4bit)
 * 123456:e10adc3949ba59abbe56e057f20f883e
 * Created by andy on 2018/10/22.
 */
public class MD5Demo {
    public static void main(String[] args) {
        System.out.println("hello,world");
        md5("123456");
    }

    public static void md5(String rawInut) {
        String md5Hash = DigestUtils.md5Hex(rawInut);
        System.out.println("raw:"+rawInut + " md5Hash:"+ md5Hash);
    }
}
