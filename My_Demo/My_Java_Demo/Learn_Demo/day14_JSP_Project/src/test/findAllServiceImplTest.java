package test;

import com.feijm.model.entity.Student;
import com.feijm.model.service.ProjectServiceImpl;
import org.junit.Test;

import java.util.List;

public class findAllServiceImplTest {
    @Test
    public void findAllServiceTest() {
        ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();
        List<Student> allDao = projectServiceImpl.findAllService();

        for (Student student : allDao) {
            System.out.println(student);
        }
    }
}
