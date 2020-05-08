package com.ua.foxminded.task10;

import java.util.Objects;

public class Lector {
    private String name;

    public Lector() {
    }

    public Lector(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return Objects.equals(name, lector.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Lector{" +
                "name='" + name + '\'' +
                '}';
    }


}
