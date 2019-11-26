package com.feijm.model.service;

import com.feijm.model.entity.Account;
import com.feijm.model.entity.Paging;
import com.feijm.model.entity.Student;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    public abstract List<Student> findAllService();

    public abstract boolean deleteToIdService(String id);

    public abstract boolean loginService(Account account);

    public abstract boolean addStudentService(Student student);

    public abstract Student findByidService(String id);

    public abstract boolean updateStudentService(Student student);

//    public abstract Integer findTotalCountService();

    public abstract Paging findByPageListService(String currentPage, String pageShowAnCount, Map<String, String[]> conditionStrStrArrMap);
}
