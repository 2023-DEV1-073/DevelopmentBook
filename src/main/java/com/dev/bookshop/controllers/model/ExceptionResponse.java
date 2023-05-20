package com.dev.bookshop.controllers.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionResponse {

    @ApiModelProperty(example = "Error While processing data")
    private String message;

}