package com.maikeffi.deposit.interview.automate.manager;

import com.maikeffi.deposit.interview.automate.core.CHDriver;
import com.maikeffi.deposit.interview.automate.core.FFDriver;
import com.maikeffi.deposit.interview.automate.utils.GetItem;
import com.maikeffi.deposit.interview.automate.utils.UserClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class Manager {
    private static Manager manager;
    private FFDriver ffDriver;
    private CHDriver chDriver;
    private GetItem proItem;
    private UserClient userClient;

    public static Manager getManager() {
        if (manager == null){
            manager = new Manager();
        }
        return manager;
    }

    public FFDriver getFfDriver() {

        if (ffDriver == null){
            ffDriver = new FFDriver();
        }
        return ffDriver;
    }

    public CHDriver getCrDriver() {

        if (chDriver == null){
            chDriver = new CHDriver();
        }
        return chDriver;
    }

    public GetItem getProItem() {
        if (proItem==null){
            proItem = new GetItem();
        }

        return proItem;
    }


    public void kill(){
        if (chDriver !=null){
            chDriver.dismiss();
        }else if (ffDriver != null){
            ffDriver.dismiss();
        }

    }

    public UserClient getUserClient() {
        if (userClient == null){
            userClient = createClient(UserClient.class,getManager().getProItem().getItemFromProp("baseUrl"));
        }
        return userClient;
    }

    private static  <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                //.logger(new Slf4jLogger(type))
                //.logLevel(Logger.Level.FULL)
                .target(type, uri);
    }
}
