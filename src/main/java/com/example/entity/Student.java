package com.example.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2023-05-07 22:31:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    
    private String sName;
    
    private Integer sAge;
    
    private String sAddress;
    
    private Integer sPhone;


}

