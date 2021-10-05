package com.hendisantika.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-advertisement
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/10/21
 * Time: 06.46
 */
@Configuration
@ConfigurationProperties(prefix = "advertisement")
public class ApplicationConfig {
    private final List<String> typologies = new ArrayList<>();
    private final ScoresConfig scores = new ScoresConfig();
    private Integer irrelevantMinScore;

}
