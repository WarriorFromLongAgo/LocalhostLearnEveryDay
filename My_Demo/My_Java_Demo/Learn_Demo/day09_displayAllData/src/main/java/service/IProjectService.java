package service;

import entity.Student;

import java.util.List;

public interface IProjectService {
    public abstract List<Student> findAllService();

    public abstract Student findByIdService(String id);
}
