package test;

import com.feijm.model.dao.ProjectDaoImpl;
import com.feijm.model.entity.Student;
import org.junit.Test;

import java.util.List;

public class ProjectDaoImplTest {
    @Test
    public void findAllDaoTest() {
        ProjectDaoImpl findAllDaoImpl = new ProjectDaoImpl();
        List<Student> allDao = findAllDaoImpl.findAllDao();

        for (Student student : allDao) {
            System.out.println(student);
        }
    }
}
