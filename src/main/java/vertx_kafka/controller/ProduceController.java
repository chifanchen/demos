package vertx_kafka.controller;

import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.producer.KafkaProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/9 15:43
 * @version:
 * @modified By:
 */
@RestController("/")
public class ProduceController {

    @Autowired
    KafkaProducer producer;

    @PostMapping("/msg/send")
    public void sendMsg(@RequestBody String msg){

        producer.write(
                KafkaProducerRecord.create("topic1",msg)
        );
    }
}
