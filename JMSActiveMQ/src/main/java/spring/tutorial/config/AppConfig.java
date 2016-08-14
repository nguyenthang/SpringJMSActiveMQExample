package spring.tutorial.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by thangnguyen-imac on 8/14/16.
 */
@Configuration
@ComponentScan(basePackages = "spring.tutorial")
@Import({MessagingConfiguration.class})
public class AppConfig {
}
