/**********************************************************************************************************************
 * FileName - Controller.java
 *
 * (c) Disney. All rights reserved.
 *
 * @Author: lel026 $$ 
 * @Revision: #1 $$ 
 * @Change: 715510 $$ 
 * @Date 3/22/18 $$ 
 **********************************************************************************************************************/
package com.example.quartz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuartzController {
    @RequestMapping("quartz")
    public String getQuartzJobDetail(){
        return "ss";
    }
}
