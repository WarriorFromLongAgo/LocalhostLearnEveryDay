package com.feijm.model.dao;

import com.feijm.model.entity.Account;
import com.feijm.model.entity.Student;
import com.feijm.until.JdbcDruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectDaoImpl implements ProjectDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtil.getDataSource());

    @Override
    public List<Student> findAllDao() {
        String sql = "SELECT * FROM jspproject";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
//        BeanUtils.populate();   object, Map
    }

    @Override
    public Integer deleteToIdDao(Integer id) {
        String sql = "delete from jspproject where id = ?";
        int update = jdbcTemplate.update(sql, id);
        if (update > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        return update;
    }

    @Override
    public Account loginDao(Account userAccount) {
        try {
            String sql = "SELECT * FROM account WHERE userName = ? AND passWord = ?";
            Map<String, Object> strObjectMap = jdbcTemplate.queryForMap(sql, userAccount.getUserName(), userAccount.getPassWord());
            Account mysqlAccount = new Account();
            BeanUtils.populate(mysqlAccount, strObjectMap);
            return mysqlAccount;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (EmptyResultDataAccessException e) {
            System.out.println("未找到数据");
            return null;
        }
        return null;
    }

    @Override
    public Integer addStudentDao(Student student) {
        String sql = "INSERT INTO jspproject (id, NAME, sex, age, birthplace, qqAccount, mailbox) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, null, student.getName(), student.getSex(), student.getAge(),
                student.getBirthplace(), student.getQqAccount(), student.getMailbox());
    }

    @Override
    public Student findByidDao(Integer id) {
        String sql = "SELECT * FROM jspproject WHERE id = ?";
        Student student = new Student();
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, id);

        try {
            BeanUtils.populate(student, stringObjectMap);
            return student;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateStudentDao(Student student) {
        String sql = "UPDATE jspproject SET sex = ?, age = ?, birthplace = ?, qqAccount = ?, mailbox = ? " +
                "WHERE id = ? AND NAME = ?";
        return jdbcTemplate.update(sql, student.getSex(), student.getAge(), student.getBirthplace(),
                student.getQqAccount(), student.getMailbox(), student.getId(), student.getName());
    }

    @Override
    public Integer findTotalCountDao(Map<String, String[]> conditionStrStrArrMap) {
//        定义一个模板的sql
//        String sql = "SELECT COUNT(id) FROM jspproject";
        String sql = "SELECT COUNT(id) FROM jspproject where 1 = 1 ";

        StringBuilder stringBuilder = new StringBuilder(sql);

        Set<String> strKey = conditionStrStrArrMap.keySet();

        List<Object> objectList = new ArrayList<>();

        for (String key : strKey) {
//            获取value的首个
            if ("currentPage".equals(key) || "pageShowAnCount".equals(key)) {
                continue;
            }

            String value = conditionStrStrArrMap.get(key)[0];
//            判断是否为空，只有不为空才做一下的操作
            if (value != null && !("".equals(value))) {
                stringBuilder.append(" and " + key + " like ? ");
                objectList.add("%" + value + "%");
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println(objectList);

        sql = stringBuilder.toString();

        return jdbcTemplate.queryForObject(sql, Integer.class, objectList.toArray());
    }

    @Override
    public List<Student> findByPageListDao(Integer start, Integer pageShowAnCount, Map<String, String[]> conditionStrStrArrMap) {
//        String sql = "SELECT * FROM jspproject LIMIT ?, ?";
        String sql = "SELECT * FROM jspproject where 1 = 1 ";

        StringBuilder stringBuilder = new StringBuilder(sql);

        Set<String> strKey = conditionStrStrArrMap.keySet();

        List<Object> objectList = new ArrayList<>();

        for (String key : strKey) {
//            获取value的首个
            if ("currentPage".equals(key) || "pageShowAnCount".equals(key)) {
                continue;
            }

            String value = conditionStrStrArrMap.get(key)[0];
//            判断是否为空，只有不为空才做一下的操作
            if (value != null && !("".equals(value))) {
                stringBuilder.append(" and " + key + " like ? ");
                objectList.add("%" + value + "%");
            }
        }
        System.out.println("========================");
        stringBuilder.append(" limit ?, ? ");
        objectList.add(start);
        objectList.add(pageShowAnCount);

        System.out.println(stringBuilder.toString());
        System.out.println(objectList);

        sql = stringBuilder.toString();
        System.out.println("========================");

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), objectList.toArray());
    }

}
