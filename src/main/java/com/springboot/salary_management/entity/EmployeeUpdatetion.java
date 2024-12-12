package com.springboot.salary_management.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdatetion {
    @NotNull(message = "Name is required.")
    String name;
    @NotNull(message = "Age is required.")
    @Min(value = 18, message = "Age must be at least 18 years old")
    Integer age;
    @NotNull(message = "Salary is required.")
    @Min(value = 0, message = "Age must be greater than 0")
    Float salary;
}
