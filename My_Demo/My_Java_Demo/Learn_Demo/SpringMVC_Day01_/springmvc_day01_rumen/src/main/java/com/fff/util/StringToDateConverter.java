package com.fff.util;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PackageName：com.fff.util
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/24 19:16
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * @return
     * @Author
     * @Description
     * @Date 2019/10/24 19:19
     * @Param
     **/
    @Override
    public Date convert(String inputStr) {
        if (inputStr == null || inputStr.length() == 0|| "".equals(inputStr)){
            throw new RuntimeException("数据为空，请传入数据");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(inputStr);

        } catch (ParseException e) {
            throw new RuntimeException("数据类型异常转换出错");
        }
    }
}
