package com.ms.spring_to_kafka;

import com.microservices.config.SpringToConfigData;
import com.ms.spring_to_kafka.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;


@SpringBootApplication
@ComponentScan({"com.microservices.config","com.ms.spring_to_kafka"})
public class SpringToKafkaDemo implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringToKafkaDemo.class);
    private final SpringToConfigData springToConfigData;
    private StreamRunner streamRunner;



    public SpringToKafkaDemo(SpringToConfigData springToConfigData, StreamRunner streamRunner) {

        this.springToConfigData = springToConfigData;
        this.streamRunner = streamRunner;
    }

    public static void main(String args []){
        SpringApplication.run(SpringToKafkaDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("App starts...");
        LOGGER.info(Arrays.toString(springToConfigData.getTwitterKeywords().toArray(new String[] {})));
//        LOGGER.info(Arrays.toString(springToConfigData.getTwitterKeywords().toArray(new String[0])));
        LOGGER.info(springToConfigData.getWelcomeMessage() +" hhh");
        streamRunner.start();
    }
}
