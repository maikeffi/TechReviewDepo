package com.maikeffi.deposit.interview.automate.manager;

import com.maikeffi.deposit.interview.automate.core.CHDriver;
import com.maikeffi.deposit.interview.automate.core.FFDriver;
import com.maikeffi.deposit.interview.automate.utils.GetItem;

public class Manager {
    private static Manager manager;
    private FFDriver ffDriver;
    private CHDriver chDriver;
    private GetItem proItem;





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
}
