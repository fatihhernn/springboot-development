package com.fatihhernn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Benim pet nesnem",description = "benim pet")
public class Pet {

    @ApiModelProperty(value = "Pet nesnesinin tekil ID alanı")
    private int id;

    @ApiModelProperty(value = "Pet nesnesinin Adı alanı")
    private String name;

    @ApiModelProperty(value = "Pet nesnesinin tekil Date alanı")
    private Date date;
}
