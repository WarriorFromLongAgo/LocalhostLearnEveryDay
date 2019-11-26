package com.feijm.model.dao;

import com.feijm.model.entity.Account;
import com.feijm.model.entity.Student;

import java.util.List;
import java.util.Map;

public interface ProjectDao {
    public abstract List<Student> findAllDao();

    public abstract Integer deleteToIdDao(Integer id);

    public abstract Account loginDao(Account account);

    public abstract Integer addStudentDao(Student student);

    public abstract Student findByidDao(Integer id);

    public abstract Integer updateStudentDao(Student student);

    public abstract Integer findTotalCountDao(Map<String, String[]> conditionStrStrArrMap);

    public abstract List<Student> findByPageListDao(Integer start, Integer pageShowAnCount, Map<String, String[]> conditionStrStrArrMap);
}
