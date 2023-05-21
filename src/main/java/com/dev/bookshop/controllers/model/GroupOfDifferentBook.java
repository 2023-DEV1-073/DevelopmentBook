package com.dev.bookshop.controllers.model;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({"books", "discountApplied", "totalPrice", "discountedPrice"})
public class GroupOfDifferentBook {

    private List<BookDetail> books;
    @ApiModelProperty(position = 1, example = "25")
    private String discountApplied;
    @ApiModelProperty(position = 2, example = "225.0")
    private String totalPrice;
    @ApiModelProperty(position = 3, example = "225.0")
    private String discountedPrice;

}
