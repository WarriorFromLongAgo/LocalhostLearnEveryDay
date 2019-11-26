package service;

import dao.ProjectDaoImpl;
import entity.Student;

import java.util.List;

public class ProjectServiceImpl implements IProjectService {

    private ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();

    @Override
    public List<Student> findAllService() {
        System.out.println("findallservice");
        return projectDaoImpl.findAllDao();
    }

    @Override
    public Student findByIdService(String id) {
        return projectDaoImpl.findByidDao(Integer.parseInt(id));
    }

}
