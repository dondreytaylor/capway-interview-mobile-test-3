package com.news.newsfeed.Util;

import java.util.Locale;

public class Constants {

    public static final String[] categories = {"All", "Business","Gadget","Sports","Video","Technology","Entertainment"};


    // method to get country of user
    public static String getCountry(){
        Locale locale = Locale.getDefault();
        String country = String.valueOf(locale.getCountry());
        return country.toLowerCase();
    }
}
