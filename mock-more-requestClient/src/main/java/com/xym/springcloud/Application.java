package com.xym.springcloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xym
 */
@SpringBootApplication
public class Application implements CommandLineRunner {


    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    ResponseEntity<String> forEntity = restTemplate().getForEntity("http://xym-pc:8010/user/{1}", String.class, 2);
                    System.out.println(Thread.currentThread().getId() + "--" + forEntity.getBody());
                }
            });
        }
    }
}
