package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author xym
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HytrixDashboardApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HytrixDashboardApplication.class).web(true).run(args);
    }
}
