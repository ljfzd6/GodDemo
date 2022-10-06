package com.ljfzd6.goddemo.utils;


import java.util.Random;
public class VerifCode {
    /**
     * 字母+数字 随机验证码
     * @return
     */
    public static String getLetter(){
        String code = "";
        char[] ch = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K','L', 'M', 'N', 'O', 'P', 'Q','R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','0','1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < 5; i++) {
            int index = (int)(Math.random() * ch.length);
            code = code + ch[index];
        }
        return code;
    }

}
