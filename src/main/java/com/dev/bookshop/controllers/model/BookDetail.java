package com.dev.bookshop.controllers.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"title", "isbn", "authorName", "yearOfPublish", "price"})
public class BookDetail {

    @ApiModelProperty(position = 1, example = "123456789123456789")
    private String isbn;
    @ApiModelProperty(example = "Book Title")
    private String title;
    @ApiModelProperty(position = 2, example = "Its Author who wrote")
    private String authorName;
    @ApiModelProperty(position = 3, example = "1789")
    private String yearOfPublish;
    @ApiModelProperty(position = 4, example = "150")
    private String price;
}
