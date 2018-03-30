package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author xym
 */
@SpringBootApplication
public class ConfigServerClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServerClientApplication.class).run(args);
    }
}
