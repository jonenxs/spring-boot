package com.nxs.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: spring-boot
 * @description: ${description}
 * @author: NieXiaoshuang
 * @create: 2019-03-17 13:57
 **/
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -9021008385890643238L;

    private Long id;

    private String name;

    private Integer age;

    private Date birth;

    private String address;
}
