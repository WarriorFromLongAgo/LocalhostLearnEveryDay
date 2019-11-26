package dao;

import entity.Student;

import java.util.List;

public interface IProjectDao {
    public abstract List<Student> findAllDao();

    public abstract Student findByidDao(Integer id);
}
