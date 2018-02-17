package github.meifans.inTesting.kafka;
import com.google.gson.Gson;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pengfei.zhao
 */
@Slf4j
public class Producer {
    Gson gson = new Gson();

    @Test
    public void testProduce() throws ExecutionException, InterruptedException {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("acks", "0");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);

        Future<RecordMetadata> future = producer.send(new ProducerRecord<>("topic", 0, "key", "value"));
        RecordMetadata recordMetadata = future.get();
        System.out.println(gson.toJson(recordMetadata));


        producer.send(new ProducerRecord<>("topicfd", 0, "keykey", "valuevalue"),
                (RecordMetadata metadata, Exception exception) -> {
                    System.out.println(gson.toJson(metadata));
                });

        Thread.sleep(1000);

    }
}
