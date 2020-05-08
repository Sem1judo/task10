package com.ua.foxminded.task10;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeSlot {
    private LocalDateTime startLesson;
    private LocalDateTime endLesson;
    private Group group;
    private Lector lector;

    public TimeSlot() {
    }

    public TimeSlot(LocalDateTime startLesson, LocalDateTime endLesson, Group group, Lector lector) {
        this.startLesson = startLesson;
        this.endLesson = endLesson;
        this.group = group;
        this.lector = lector;
    }

    public LocalDateTime getStartLesson() {
        return startLesson;
    }

    public void setStartLesson(LocalDateTime startLesson) {
        this.startLesson = startLesson;
    }

    public LocalDateTime getEndLesson() {
        return endLesson;
    }

    public void setEndLesson(LocalDateTime endLesson) {
        this.endLesson = endLesson;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(startLesson, timeSlot.startLesson) &&
                Objects.equals(endLesson, timeSlot.endLesson) &&
                Objects.equals(group, timeSlot.group) &&
                Objects.equals(lector, timeSlot.lector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startLesson, endLesson, group, lector);
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "startLesson=" + startLesson +
                ", endLesson=" + endLesson +
                ", group=" + group +
                ", lector=" + lector +
                '}';
    }
}
