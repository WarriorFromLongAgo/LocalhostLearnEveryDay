package com.feijm.jdbctemplate;

import com.feijm.jdbcutil.jdbcUtilDruid;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JdbcTemplateSelect {
    private static JdbcTemplate JdbcTemplate = null;

    @Before
    public void getJdbcTemplate() {
        JdbcTemplate = new JdbcTemplate(jdbcUtilDruid.getDataSource());
    }

    @Test
    public void queryFoMapDemo() {
        //  返回一条数据
        String sql = "SELECT * FROM student WHERE id = ?;";
        Map<String, Object> stringObjectMap = JdbcTemplate.queryForMap(sql, 1);

        for (Map.Entry<String, Object> stringObjectEntry : stringObjectMap.entrySet()) {
            System.out.print("key = " + stringObjectEntry.getKey());
            System.out.println("    value = " + stringObjectEntry.getValue());
        }
        int id = (int) stringObjectMap.get("id");
        String name = (String) stringObjectMap.get("NAME");
        int age = (int) stringObjectMap.get("age");
        String sex = (String) stringObjectMap.get("sex");
        String address = (String) stringObjectMap.get("address");
        int math = (int) stringObjectMap.get("math");
        int english = (int) stringObjectMap.get("english");

        Student student = new Student(id, name, age, sex, address, math, english);
        System.out.println(student);
    }
//    public void test() {
//        String sql = "select name,age from test where id = 10";
//        Customer customer = jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {
//
//            @Override
//            public Customer mapRow(ResultSet rs, int i)
//                    throws SQLException {
//                Customer c = new Customer();
//                c.setName(rs.getString("name"));
//                c.setAge(rs.getInt("age"));
//                return c;
//            }
//
//        });
//    }
//public void test(Integer id) {//参数也是局部变量，也必须用final修饰，内部类中才能访问（全局变量不用）
//    String sql = "select name,age from test where id = ?";
//    Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Customer>() {
//
//        @Override
//        public Customer mapRow(ResultSet rs, int paramInt)
//                throws SQLException {
//            Customer c = new Customer();
//            c.setName(rs.getString("name"));
//            c.setAge(rs.getInt("age"));
//            return c;
//        }
//
//    });
//}

    @Test
    public void queryFoListDemo() {
        String sql = "select * from student where id = ? or id = ?";
        List<Map<String, Object>> mapInList = JdbcTemplate.queryForList(sql, 1, 2);
        List<Student> studentList = new ArrayList<>();

        for (Map<String, Object> stringObjectMap : mapInList) {

            int id = (int) stringObjectMap.get("id");
            String name = (String) stringObjectMap.get("NAME");
            int age = (int) stringObjectMap.get("age");
            String sex = (String) stringObjectMap.get("sex");
            String address = (String) stringObjectMap.get("address");
            int math = (int) stringObjectMap.get("math");
            int english = (int) stringObjectMap.get("english");

            studentList.add(new Student(id, name, age, sex, address, math, english));
//            for (String keymap : stringObjectMap.keySet()) {
//                System.out.print("key = " + keymap);
//                System.out.println("    value = " + stringObjectMap.get(keymap));
//            }
//            System.out.println();
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void queryFoListDemoTwo() {
        String sql = "select * from student";
        List<Map<String, Object>> mapInList = JdbcTemplate.queryForList(sql);
        List<Student> studentList = new ArrayList<>();

        for (Map<String, Object> stringObjectMap : mapInList) {

            int id = (int) stringObjectMap.get("id");
            String name = (String) stringObjectMap.get("NAME");
            int age = (int) stringObjectMap.get("age");
            String sex = (String) stringObjectMap.get("sex");
            String address = (String) stringObjectMap.get("address");
            int math = (int) stringObjectMap.get("math");
            //English 有空的存在
            int english = (int) stringObjectMap.get("english");

            studentList.add(new Student(id, name, age, sex, address, math, english));
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void queryForRowMapper() {
        String sql = "select * from student";
        List<Student> studentList = JdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");
                int math = resultSet.getInt("math");
                int english = resultSet.getInt("english");

                return new Student(id, name, age, sex, address, math, english);
            }
        });
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void queryBeanPropertyRowMapper() {
        String sql = "select * from student where id = 1 or id = 2";

        List<Student> studentList = JdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
