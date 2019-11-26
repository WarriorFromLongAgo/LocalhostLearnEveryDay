package com.day19_treeset_sql.tttt2222;


//  父类必须给定变量类型
public class CcClass implements CcInter<String> {
    @Override
    public void print(String str) {
        System.out.println(str);
    }

}
