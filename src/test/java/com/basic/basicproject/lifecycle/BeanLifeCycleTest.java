package com.basic.basicproject.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
                LifeCycleConfig.class);

        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); // 스프링 컨테이너 종료, ConfigurableApplicationContext 필요
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient client = new NetworkClient();
            client.setUrl("http://hello-spring.dev");
            return networkClient();
        }
    }
}
