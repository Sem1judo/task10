package com.ua.foxminded.task10;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private List<Group> groups;
    private List<Lector> lectors;

    public Faculty() {
    }


    public Faculty(String name, List<Group> groups, List<Lector> lectors) {
        this.name = name;
        this.groups = groups;
        this.lectors = lectors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(groups, faculty.groups) &&
                Objects.equals(lectors, faculty.lectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups, lectors);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                ", lectors=" + lectors +
                '}';
    }
}
