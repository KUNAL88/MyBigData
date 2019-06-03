package com.kunal.big.kafka;

import com.kunal.config.KafkaConfig;

import java.io.IOException;

public class MessageConsumer {

    public static void main(String[] args)throws IOException {

        String configPath="./src/main/resources/local.properties";
        KafkaConfig config=new KafkaConfig(configPath);
        System.out.println(config.toString());

    }

}
