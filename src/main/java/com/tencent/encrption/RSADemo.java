package com.tencent.encrption;


import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * 原理: 典型的非对称加密. http://www.ruanyifeng.com/blog/2013/06/rsa_algorithm_part_one.html
 * 加密和解密用的不是同一个秘钥,分为公钥和私钥,公钥可以到处传递,用来对数据加密,只有有密码的,才能对数据解密.
 * 欧拉定理是rsa算法的核心.
 *
 * DO:生成公钥和私钥,用公钥对数据加密,用秘钥对数据解密.
 *
 * https://blog.csdn.net/qq_18870023/article/details/52596808
 * Created by andy on 2018/10/22.
 */
public class RSADemo {
    public static String data="hello world";

    public static void main(String[] args) throws Exception {

        KeyPair keyPair=genKeyPair(1024);

        //获取公钥，并以base64格式打印出来
        PublicKey publicKey=keyPair.getPublic();
        System.out.println("公钥："+new String(Base64.getEncoder().encode(publicKey.getEncoded())));

        //获取私钥，并以base64格式打印出来
        PrivateKey privateKey=keyPair.getPrivate();
        System.out.println("私钥："+new String(Base64.getEncoder().encode(privateKey.getEncoded())));

        //公钥加密
        byte[] encryptedBytes=encrypt(data.getBytes(), publicKey);
        System.out.println("加密后："+new String(encryptedBytes));

        //私钥解密
        byte[] decryptedBytes=decrypt(encryptedBytes, privateKey);
        System.out.println("解密后："+new String(decryptedBytes));

    }


    //生成密钥对
    public static KeyPair genKeyPair(int keyLength) throws Exception{
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }



}
