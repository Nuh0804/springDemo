package com.example.demo.Course;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Entity(name = "course")
public class  Course {
    @Id
    @Column(
            name = "course",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String Id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "description",
            columnDefinition = "TEXT",
            length = 255
    )
    private String description;

    @Column(
            name = "year_taught",
            nullable = false,
            length = 4
    )
    private int yearTaught;
    public Course(){

    }

    public Course(String id, String name, String description, int yearTaught) {
        Id = id;
        this.name = name;
        this.description = description;
        this.yearTaught = yearTaught;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear_taught(int year_taught) {
        this.yearTaught = year_taught;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year_taught=" + yearTaught +
                '}';
    }
}
