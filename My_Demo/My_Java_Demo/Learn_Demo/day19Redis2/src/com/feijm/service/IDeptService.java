package com.feijm.service;

import com.feijm.domain.Dept;

import java.util.List;

public interface IDeptService {
    public abstract List<Dept> findAllService();

    public abstract String findAllJsonService();
}
