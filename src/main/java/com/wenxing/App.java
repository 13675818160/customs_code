package com.wenxing;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



/**
 * Hello world!
 *
 */

//@ComponentScan("com.wenxing")
//@RestController
//@EnableAutoConfiguration
//@EnableWebMvc

@SpringBootApplication
public class App
{
	
	private static Log logger = LogFactory.getLog(App.class);
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
