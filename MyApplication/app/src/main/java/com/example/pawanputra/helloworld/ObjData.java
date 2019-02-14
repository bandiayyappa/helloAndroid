package com.example.pawanputra.helloworld;

import java.util.HashMap;

/**
 * Created by PAWAN PUTRA on 12/12/2016.
 */
public class ObjData {
    static HashMap<String,String> hm;
    ObjData(HashMap<String,String> hm)
    {
     System.out.println("this is hashmap constructor in objData");
        this.hm=hm;
        System.out.println("obj data");
        System.out.println(hm);
    }
    ObjData()
    {
        System.out.println("this is 0argument constructor in objData");

    }
    HashMap<String,String> oo()
    {
        System.out.println("hashMap data after sending hm to objdata= "+hm);

        return hm;
    }

}
