package com.inno.serverMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Home on 16.12.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.inno.serverMVC")
public class WebConfig extends WebMvcConfigurerAdapter{
}
