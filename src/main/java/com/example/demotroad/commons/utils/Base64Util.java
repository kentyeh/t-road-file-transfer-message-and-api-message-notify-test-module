package com.example.demotroad.commons.utils;

import java.util.Base64;

public class Base64Util {

    public String Encode(byte[] json){
       String string = Base64.getEncoder().encodeToString(json);
       return string;
    }

    public static byte[] Decode(String string){
        byte[] stringDecode = Base64.getDecoder().decode(string);
        return stringDecode;
    }

}
