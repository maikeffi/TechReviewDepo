package com.maikeffi.deposit.interview.automate.utils.impl;

import com.maikeffi.deposit.interview.automate.utils.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class UtilsImpl implements Utils {

    protected Properties prop = null;

    @Override public String getItemFromProp(String item) {
        if (prop == null){
            prop = new Properties();
            try {
                //System.out.println(System.getProperty("user.dir"));
                FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\elements.properties");
                prop.load(ip);
                System.out.println("Loading properties file - Successfull");
            }catch(Exception t){
                //t.printStackTrace();
                System.out.println("Error in reading properties file");
            }

        }

        return prop.getProperty(item);
    }
}
