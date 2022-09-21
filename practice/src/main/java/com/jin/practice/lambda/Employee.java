package com.jin.practice.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    String name;
    Integer age;
    Integer salary;
    Status status;

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
