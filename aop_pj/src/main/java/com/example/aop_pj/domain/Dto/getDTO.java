package com.example.aop_pj.domain.Dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class getDTO {

    @ApiModelProperty(name = "艾迪")
    private String id;
    @ApiModelProperty(value = "姓名")
    private String name;


}
