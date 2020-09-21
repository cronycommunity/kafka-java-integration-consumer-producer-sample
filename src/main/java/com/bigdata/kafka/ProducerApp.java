package com.bigdata.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Scanner;

public class ProducerApp {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        Properties config = new Properties();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());

        Producer producer = new KafkaProducer<String, String>(config);

        while(true){
            System.out.println("Data what will send to Kafka : ");
            String key = read.nextLine();
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>("search", key);
            producer.send(rec);
        }

        //producer.close();

    }
}
