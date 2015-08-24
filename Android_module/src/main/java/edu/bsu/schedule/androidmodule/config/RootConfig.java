package edu.bsu.schedule.androidmodule.config;

import edu.bsu.schedule.databasemodule.config.ApplicationConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan("edu.bsu.schedule.databasemodule.service.impl")

@Import({ApplicationConfig.class})
public class RootConfig {
}
