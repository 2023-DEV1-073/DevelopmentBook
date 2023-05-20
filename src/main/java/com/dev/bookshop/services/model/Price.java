package com.dev.bookshop.services.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Price {
    @ApiModelProperty(example = "12.0")
    Double totalPrice;
    @ApiModelProperty(example = "10.0")
    Double discountedPrice;
    @ApiModelProperty(example = "5")
    Integer discountApplied;
}
