package com.atao.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author atao
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1", 1);
        hashMap.get("1");
        hashMap.remove("1");

        for (Object key : hashMap.keySet()) {
            System.out.print(key + " ");
        }

        for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
            System.out.print(entry + " ");
        }
    }

}
