package com.dev.bookshop.controllers.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCart {

    @ApiModelProperty(example = "12345")
    private String isbn;
    
}
