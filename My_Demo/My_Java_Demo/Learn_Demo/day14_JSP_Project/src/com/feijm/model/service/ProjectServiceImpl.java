package com.feijm.model.service;

import com.feijm.model.dao.ProjectDaoImpl;
import com.feijm.model.entity.Account;
import com.feijm.model.entity.Paging;
import com.feijm.model.entity.Student;

import java.util.List;
import java.util.Map;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();

    @Override
    public List<Student> findAllService() {
        return projectDaoImpl.findAllDao();
    }

    @Override
    public boolean deleteToIdService(String id) {
        return projectDaoImpl.deleteToIdDao(Integer.parseInt(id)) > 0;
    }

    /*检测传入的账号密码是否是正确的，正确返回true，错误则返回一个false*/
    @Override
    public boolean loginService(Account userAccount) {
        return projectDaoImpl.loginDao(userAccount) != null;
    }

    @Override
    public boolean addStudentService(Student student) {
        System.out.println(student.toString());
        return projectDaoImpl.addStudentDao(student) > 0;
    }

    @Override
    public Student findByidService(String id) {
        return projectDaoImpl.findByidDao(Integer.parseInt(id));
    }

    @Override
    public boolean updateStudentService(Student student) {
        return projectDaoImpl.updateStudentDao(student) > 0;
    }

    private Integer findTotalCountService(Map<String, String[]> conditionStrStrArrMap) {
        return projectDaoImpl.findTotalCountDao(conditionStrStrArrMap);
    }

    @Override
    public Paging<Student> findByPageListService(String currentPage, String pageShowAnCount, Map<String, String[]> conditionStrStrArrMap) {
        int currentPageInt = Integer.parseInt(currentPage);
//        每一页显示的记录数
        int pageShowAnCountInt = Integer.parseInt(pageShowAnCount);
        Integer totalCount = findTotalCountService(conditionStrStrArrMap);

        if (currentPageInt <= 0) {
            currentPageInt = 1;
        }

        Paging paging = new Paging();
        paging.setTotalCount(totalCount);
        paging.setCurrentPage(currentPageInt);

        int pageCount = (totalCount % pageShowAnCountInt == 0) ? totalCount / pageShowAnCountInt : totalCount / pageShowAnCountInt + 1;

        paging.setPageCount(pageCount);

//        计算的开始的索引
        int start = (currentPageInt - 1) * pageShowAnCountInt;
        List<Student> byPageListDao = projectDaoImpl.findByPageListDao(start, pageShowAnCountInt, conditionStrStrArrMap);
        paging.setStudentList(byPageListDao);

        paging.setPageShowAnCount(pageShowAnCountInt);

        return paging;
    }
}
