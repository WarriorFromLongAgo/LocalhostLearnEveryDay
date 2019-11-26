package Json.service;

import Json.domain.People;
import com.alibaba.fastjson.JSON;

import java.util.Date;

public class JsonDemo {
    public static void main(String[] args) {

        People people = new People(1, "feijm", new Date(), "hubei");

        String string = JSON.toJSONString(people);
        System.out.println(string);

        Object o = JSON.toJSON(people);
        System.out.println(o);

    }
}
