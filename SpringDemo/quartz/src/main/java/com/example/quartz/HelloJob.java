/**********************************************************************************************************************
 * FileName - HelloJob.java
 *
 * (c) Disney. All rights reserved.
 *
 * @Author: lel026 $$ 
 * @Revision: #1 $$ 
 * @Change: 715510 $$ 
 * @Date 3/20/18 $$ 
 **********************************************************************************************************************/
package com.example.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    public void execute(){
        logger.info("ss");
    }
}
