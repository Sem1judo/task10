package com.ua.foxminded.task10;

import java.util.Objects;

public class Lesson {
    private String name;
    private Lector lector;

    public Lesson() {
    }

    public Lesson(String name, Lector lector) {
        this.name = name;
        this.lector = lector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(name, lesson.name) &&
                Objects.equals(lector, lesson.lector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lector);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", lector=" + lector +
                '}';
    }
}
