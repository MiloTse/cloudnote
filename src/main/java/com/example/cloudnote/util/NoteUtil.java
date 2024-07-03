package com.example.cloudnote.util;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;


public class NoteUtil {
    public static String md5(String src){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //MD5加密
            byte[] output = md.digest(src.getBytes());
            //return new String(output);
            //Base64.将md5处理的字符用Base64处理

            String ret = Base64.getEncoder().encodeToString(output);
            return ret;
        } catch (Exception e) {
            throw new Md5Exception("加密失败",e);
        }
    }

    //利用uuid生成主键值
    public static String createId(){
        String id=UUID.randomUUID().toString();
        //return id;
        return id.replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
        System.out.println(md5("123456"));
        System.out.println(NoteUtil.createId());

    }


}
