package com.tencent.encrption;


import java.util.Base64;

/**
 * 原理:一种编码方式,原理参考:https://baike.baidu.com/item/base64/8545775?fr=aladdin
 * 原来的字符串3个一组(3*8),转变成4*6,4个6位的一组(6位的范围是64,映射为可见的字符--有一个映射表),高位的2位补零,也就是3个字节变成了4个字节.
 * base64编码比原来的字符串增加了1/3.
 * 末尾可能剩下1-2个字符单着,那么1个字符是变成2个字符,补2个等号,两个字符单着的话,就变成3个字符,然后补一个字符;
 * 解码用逆思路就可以了
 *
 * base64中的字符+和/在url中会被做转义,一种思路是对这两个思路做替换就可以了.替换成-和_.
 * Created by andy on 2018/10/22.
 */
public class Base64Demo {
    public static void main(String[] args) {
        System.out.println("hello,world");
        base64("s13");
    }

    public static void base64(String rawInut) {
        byte[] encBase64 = Base64.getEncoder().encode(rawInut.getBytes());
        String encBase64Str = new String(encBase64);
        System.out.println("raw:"+rawInut + " base64:"+ encBase64Str);
    }
}
