/**********************************************************************************************************************
 * FileName - TicketDTO.java
 *
 * (c) Disney. All rights reserved.
 *
 * @Author: lel026 $$ 
 * @Revision: #1 $$ 
 * @Change: 715510 $$ 
 * @Date 4/3/18 $$ 
 **********************************************************************************************************************/
package com.example.validator.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TicketDTO {
    @Min(value = 10,message = "price must bigger than 10")
    Integer price;
    String name;
    @NotNull
    Date date;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
