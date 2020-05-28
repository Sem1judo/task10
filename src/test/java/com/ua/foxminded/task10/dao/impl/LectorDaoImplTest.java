package com.ua.foxminded.task10.dao.impl;

import com.ua.foxminded.task10.model.Lector;
import com.ua.foxminded.task10.model.mapper.LectorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class LectorDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private LectorDaoImpl lectorDao;

    @BeforeEach
    void init() {
        lectorDao = new LectorDaoImpl();
        MockitoAnnotations.initMocks(this);

    }

    private Lector getMeTestLector() {
        MockitoAnnotations.initMocks(this);
        Lector lector = new Lector();
        lector.setLectorId(1000L);
        lector.setFirstName("TestFirstName");
        lector.setLastName("TestSurname");
        return lector;
    }

    @Test
    public void shouldRerutnCreatedLector() {
        when(lectorDao.create(new Lector())).thenReturn(Boolean.TRUE);
        boolean isCreated = lectorDao.create(new Lector());
        assertTrue(isCreated);

    }

    @Test
    public void shouldUpdatedLector() {
        Lector lector = lectorDao.getById(1000L);
        ReflectionTestUtils.setField(lectorDao, "jdbcTemplate"
                ,when(jdbcTemplate.update("update lessons set lesson_name = ? where lesson_id = ?")).thenReturn(1));

        Mockito.when(jdbcTemplate.update(Mockito.anyString(),
                Mockito.eq(LectorMapper.class))).thenReturn(1);
        boolean isUpdated = lectorDao.update(lector);

        verify(jdbcTemplate, times(1))
                .update(eq(Mockito.anyString())
                        , refEq(isUpdated), eq(LectorMapper.class));

        assertTrue(isUpdated);
    }

    @Test
    public void shouldDeleteLector() {
        when(lectorDao.delete(1000L)).thenReturn(Boolean.TRUE);
        boolean isDeleted = lectorDao.delete(1000L);
        assertTrue(isDeleted);
    }

    @Test
    public void shouldRerutnAppropriateFirstNameAndLastName() {
        when(lectorDao.getById(1000L)).thenReturn(getMeTestLector());
        Lector lector = lectorDao.getById(1000L);
        assertNotNull(lector);
        assertEquals("TestFirstName", lector.getFirstName());
        assertEquals("TestSurname", lector.getLastName());
    }

}

