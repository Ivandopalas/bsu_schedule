package edu.bsu.schedule.androidmodule.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("edu.bsu.schedule.androidmodule.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
}
