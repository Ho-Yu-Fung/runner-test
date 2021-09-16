package com.example.runnertest.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;

public class Md5Utils {
    public static String getMd5Hex(String str){
        Md5Hash md5Hash = new Md5Hash(str);
        return md5Hash.toHex();
    }
    public static String getMd5SaltHex(String str,String salt){
        Md5Hash md5Hash = new Md5Hash(str,salt);
        return md5Hash.toHex();
    }
    public static String getMd5SaltTimesHex(String str,String salt,int times){
        Md5Hash md5Hash = new Md5Hash(str,salt,times);
        return md5Hash.toHex();
    }

    /**
     * 通过UUID生成随机盐
     * @return
     */
    public static String getRamdomSalt(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
