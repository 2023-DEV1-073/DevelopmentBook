package com.dev.bookshop.controllers.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@JsonPropertyOrder({"groupOfDifferentBooks", "totalPrice", "discountedPrice"})
public class Invoice {

    List<GroupOfDifferentBook> groupOfDifferentBooks;
    @ApiModelProperty(position = 1, example = "800.0")
    String totalPrice;
    @ApiModelProperty(position = 2, example = "500.0")
    String discountedPrice;
}
