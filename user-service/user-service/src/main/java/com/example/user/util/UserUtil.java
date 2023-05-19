package com.example.user.util;

import java.util.Random;

public class UserUtil {

    public static final String USER_TOPIC="USER-ACTIVITY";
    public static String getUserNo()
    {
        StringBuffer userBuffer=new StringBuffer();
        userBuffer.append("USER");
        userBuffer.append("-");
        Random rd=new Random();
        userBuffer.append(rd.nextInt(1000,9999));
        return userBuffer.toString();
    }
}
