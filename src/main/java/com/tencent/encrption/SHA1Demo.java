package com.tencent.encrption;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * 原理:shaHex
 * 生成的散列值为160 bit,20Byte,40个16进制字符(4bit)
 * 123456:7c4a8d09ca3762af61e59520943dc26494f8941b
 * Created by andy on 2018/10/22.
 */
public class SHA1Demo {
    public static void main(String[] args) {
        System.out.println("hello,world");
        sha1("123456");
    }

    public static void sha1(String rawInut) {
        String shaHex = DigestUtils.shaHex(rawInut);
        System.out.println("raw:"+rawInut + " shaHex:"+ shaHex);
    }
}
