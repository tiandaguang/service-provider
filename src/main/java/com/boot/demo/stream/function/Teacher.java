package com.boot.demo.stream.function;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {

    private static final long serialVersionUID = 2083114923510347064L;

    private String name;


    @Override
    public String toString() {
        return "Teacher [name=" + name + "]";
    }
}