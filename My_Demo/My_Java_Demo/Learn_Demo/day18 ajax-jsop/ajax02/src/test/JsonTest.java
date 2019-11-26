package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feijm.domain.project;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {

    @Test
    public void jsonTest1() {
        project project = new project();
        project.setUserName("123456");
        project.setPassWord("123456");

        ObjectMapper objectMapper = new ObjectMapper();
        String string = null;
        try {
            string = objectMapper.writeValueAsString(project);
            objectMapper.writeValue(new File("D:\\学习资料下载\\我自己的 md文件\\a.txt"), project);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(string);
    }

    @Test
    public void jsonTest2() {
        String json1 = "{\"userName\":\"123456\",\"passWord\":\"123456\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            project project = objectMapper.readValue(json1, project.class);
            System.out.println(project);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonTest3() {
        project project = new project();
        project.setUserName("123456");
        project.setPassWord("123456");

        project project2 = new project();
        project2.setUserName("123456789");
        project2.setPassWord("123456789");

        Map<String, Object> strObjMap = new HashMap<>();
        strObjMap.put("1", project);
        strObjMap.put("2", project2);

        ObjectMapper objectMapper = new ObjectMapper();
        String string = null;
        try {
            string = objectMapper.writeValueAsString(strObjMap);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(string);
    }
}
