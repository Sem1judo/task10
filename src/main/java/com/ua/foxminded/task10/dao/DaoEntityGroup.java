package com.ua.foxminded.task10.dao;

import com.ua.foxminded.task10.model.Group;

public interface DaoEntityGroup extends DaoEntity<Group> {
     int getLessonsById(Long id);
}
