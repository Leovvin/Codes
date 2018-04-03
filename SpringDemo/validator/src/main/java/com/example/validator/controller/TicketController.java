/**********************************************************************************************************************
 * FileName - TicketController.java
 *
 * (c) Disney. All rights reserved.
 *
 * @Author: lel026 $$ 
 * @Revision: #1 $$ 
 * @Change: 715510 $$ 
 * @Date 4/3/18 $$ 
 **********************************************************************************************************************/
package com.example.validator.controller;

import com.example.validator.dto.TicketDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @PostMapping
    public String addTicket(@Validated @RequestBody TicketDTO ticketDTO){
        return ticketDTO.getPrice().toString();
    }
}
