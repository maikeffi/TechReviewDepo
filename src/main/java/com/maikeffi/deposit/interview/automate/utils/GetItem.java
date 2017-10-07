package com.maikeffi.deposit.interview.automate.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Kannan Maikeffi on 07-10-2017.
 */
public class GetItem {
    protected Properties prop = null;

    public String getItemFromProp(String item) throws Exception{
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
