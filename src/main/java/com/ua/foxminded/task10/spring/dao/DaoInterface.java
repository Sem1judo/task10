package com.ua.foxminded.task10.spring.dao;

import javax.sql.DataSource;
import java.util.List;

public interface DaoInterface<T> {

    T getById(Long id);

    List<T> getAll();

    boolean delete(Long id);

    boolean update(T entity);

    boolean create(T entity);


}
