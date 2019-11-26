package com.byit.model;


import java.util.*;
//import java.util.Map.Entry;

public class SHashMapGrammer {
    public static void main(String[] args) {
        HashHash map = new HashHash();
        map.IsEmptyHashHash();
        System.out.println("==================================");
        map.PutHashHash();
        System.out.println("==================================");
        map.GetHashHash();
        System.out.println("==================================");
        map.IsEmptyHashHash();
        System.out.println("==================================");
        map.RemoveMap();
        System.out.println("==================================");
        map.KeySetMap();
        System.out.println("==================================");
        map.ClearMap();
        System.out.println("==================================");
        map.PutHashTwo();
        System.out.println("==================================");
        System.out.println("==================================");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("费1号", "0001");
        linkedHashMap.put("费2号", "0002");
        linkedHashMap.put("费3号", "0003");
        linkedHashMap.put("费4号", "0004");
        System.out.println(linkedHashMap.values());
        for (String i : linkedHashMap.keySet()) {
            System.out.println(i);
        }
        System.out.println();
    }
}

class HashHash {
    HashMap<String, String> Hashmap = new HashMap<String, String>();
    //Entry<String, String> entryMap;

    public void PutHashHash() {
        Hashmap.put("费久猛", "31");
        System.out.println("containkey= " + Hashmap.containsKey("张三"));
        System.out.println("containvalue= " + Hashmap.containsValue("31"));
        System.out.println("containkey= " + Hashmap.containsKey("费久猛"));
    }

    public void PutHashTwo() {
        Hashmap.put("A", "1");
        Hashmap.put("B", "2");
        Hashmap.put("C", "3");
        Hashmap.put("D", "1");
        Hashmap.put("E", "2");
        Hashmap.put("F", "3");
        Hashmap.put("G", "1");
        Hashmap.put("H", "2");
        Hashmap.put("I", "3");
//        for (Entry<String, String> entryMap : Hashmap.entrySet()) {
//            String key = entryMap.getKey();
//            String value = entryMap.getValue();
//            System.out.println("key= " + key + "，value= " + value);
//        }
//        System.out.println("=============================");
//        List<String> ListString = new ArrayList<String>();
//        for (Entry<String, String> entryMap : Hashmap.entrySet()) {
//            if (!(entryMap.getValue().equals("1"))) {
//                ListString.add(entryMap.getKey());
//            }
//        }
    }

    public void GetHashHash() {
        String Output;
        //get只会返回value值 ; 在get里面只能写get(key)
        //HashMap<Key, Value>
        Output = Hashmap.get("费久猛");
        System.out.println("get(key)= " + Output);
        //get(value)时，不会返回其他的。
        //只会返回 null
        Output = Hashmap.get("31");
        System.out.println("get(value)= " + Output);
    }

    public void IsEmptyHashHash() {
        boolean OutputBoolean;
        int Size = 0;
        OutputBoolean = Hashmap.isEmpty();
        Size = Hashmap.size();
        System.out.println("是否为空= " + OutputBoolean);
        System.out.println("HashMap的长度= " + Size);
    }

    public void RemoveMap() {
        System.out.println("HashMap.Value= " + Hashmap.values());
        System.out.println("Hashmap.get= " + Hashmap.get("费久猛"));
        Hashmap.remove("费久猛");
        for (int i = 0; i < Hashmap.size(); i++) {
            System.out.print("Hashmap.values= " + Hashmap.values());
        }
        System.out.println();
        Hashmap.put("费1号", "001");
        Hashmap.put("费2号", "002");
        Hashmap.put("费3号", "003");
        Hashmap.put("费4号", "004");
        Hashmap.put("费5号", "005");
        System.out.println("Hashmap.values= " + Hashmap.values());
        Hashmap.put("费4号", "044");
        System.out.println("Hashmap.values= " + Hashmap.values());

        System.out.println("Hashmap.get= " + Hashmap.get("费5号"));
        Hashmap.put("费3号", "555");
        System.out.println("Hashmap.values= " + Hashmap.values());
        System.out.println("Hashmap.get= " + Hashmap.get("费5号"));

        //Hashmap.remove("费5号");
        System.out.println("remove key remove vlaue= " + Hashmap.remove("费5号", "005"));
        System.out.println("remove key remove vlaue= " + Hashmap.remove("费1号", "0000"));

//        SortedSet<String> keys = new TreeSet<>(Hashmap.keySet());
//        Object[] NewArrary = keys.toArray();
//        for (Object i : NewArrary) {
//            System.out.println("NewArrary= " + i);
//        }
        for (String key : Hashmap.keySet()) {
            System.out.print("key= " + key);
            System.out.println();
        }

    }

    public void KeySetMap() {
        for (String key : Hashmap.keySet()) {
            System.out.print("key= " + key);
            System.out.println();
        }
        System.out.println("Hashmap.values= " + Hashmap.values());
    }

    public void ClearMap() {
        Hashmap.clear();
        Hashmap.keySet();
        Hashmap.values();
        System.out.println("hashmap Clear");
    }
}

