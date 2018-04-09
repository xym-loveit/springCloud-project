package com.xym.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 采用以下命令传参切换当前profile环境
 * java -jar microservice-discovery-eureka-ha-1.0-SNAPSHOT.jar --spring.profiles.active=peer1
 * <p>
 * java -jar microservice-discovery-eureka-ha-1.0-SNAPSHOT.jar --spring.profiles.active=peer2
 *
 * @author xym
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApplication.class).run(args);
    }
}
