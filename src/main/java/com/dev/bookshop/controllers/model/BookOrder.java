package com.dev.bookshop.controllers.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookOrder {

    @ApiModelProperty(example = "12345")
    String isbn;
    @ApiModelProperty(example = "1")
    Integer quantity;
}
