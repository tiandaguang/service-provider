package com.boot.demo.core.entity;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "cardN1111111111111111ame不能为空")
    private String name;
}
