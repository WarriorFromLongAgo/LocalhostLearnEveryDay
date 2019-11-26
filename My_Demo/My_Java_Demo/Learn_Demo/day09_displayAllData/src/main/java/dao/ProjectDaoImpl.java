package dao;

import entity.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcDruidUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class ProjectDaoImpl implements IProjectDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtil.getDataSource());

    @Override
    public List<Student> findAllDao() {
        String sql = "SELECT * FROM product";
        System.out.println(sql);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

    }

    @Override
    public Student findByidDao(Integer id) {
        String sql = "SELECT * FROM product WHERE id = ?";
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
}
