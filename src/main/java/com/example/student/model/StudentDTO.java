package com.example.student.model;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class StudentDTO {

    @NotNull
    @Pattern(regexp = "^\\d+$")
    private String age;

    @NotEmpty()
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Integer.parseInt(age);
    }

    public void setAge(String age) {
        this.age = age;
    }


}
