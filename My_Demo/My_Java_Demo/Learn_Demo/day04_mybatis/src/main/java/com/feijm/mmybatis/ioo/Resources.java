package com.feijm.mmybatis.ioo;

import java.io.InputStream;

public class Resources {
    /**
     * @-----cdoing：utf-8-----
     * @Author :
     * @Project :
     * @Time :
     * @version :
     * @修改原因 :
     * @more info   ：根据传入的参数，获得一个字节输入流
     * @more info   ：
     * @more info   ：
     */
    public static InputStream getResourceAsStream(String feilpath) {
        return Resources.class.getClassLoader().getResourceAsStream(feilpath);
    }
}
