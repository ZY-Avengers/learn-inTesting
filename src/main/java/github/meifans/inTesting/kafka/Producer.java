package github.meifans.inTesting.kafka;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.util.Properties;

/**
 * @author pengfei.zhao
 */
public class Producer {


    @Test
    public void testProduce() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);

        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<>("topic", 0, "key", "value"));
        }

    }
}
