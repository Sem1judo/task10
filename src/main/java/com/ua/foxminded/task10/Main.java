package com.ua.foxminded.task10;


import com.ua.foxminded.task10.model.Lector;
import com.ua.foxminded.task10.spring.appConfig.AppConfig;
import com.ua.foxminded.task10.spring.dao.impl.FacultyDaoImpl;
import com.ua.foxminded.task10.spring.dao.impl.LectorDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        LectorDaoImpl personDAO = context.getBean(LectorDaoImpl.class);
        FacultyDaoImpl facultyDao = context.getBean(FacultyDaoImpl.class);

//        Faculty faculty = new Faculty();
//        faculty.setName("BIOLEGO");

        Lector person = new Lector("dogsfdas", "Uasdasdser");
        personDAO.create(person);

//        facultyDao.create(faculty);

        System.out.println("List of person is:");
        for (Lector p : personDAO.getAll()) {
            System.out.println(p);
        }
//
//        System.out.println("\nGet person with ID 1");
//        Lector personById = personDAO.getById(1L);
//        System.out.println(personById);
//
//        System.out.println("\nCreating person: ");

//        System.out.println(person);
//        personDAO.create(person);
//
//
//        System.out.println("\nList of person is:");
//        for (Lector p : personDAO.getAll()) {
//            System.out.println(p);
//        }
//
//        System.out.println("\nDeleting person with ID 10");
//        personDAO.delete(10L);
//
//        System.out.println("\nList of person is:");
//        for (Lector p : personDAO.getAll()) {
//            System.out.println(p);
//        }
//
//        Lector pperson = personDAO.getById(2L);
//        pperson.setLastName("CHANGED");
//        personDAO.update(pperson);
//
//        System.out.println("\nList of person is:");
//        for (Lector p : personDAO.getAll()) {
//            System.out.println(p);
//        }

        context.close();
    }
}

