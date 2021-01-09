package vertx_kafka;

import io.vertx.core.Vertx;
import io.vertx.kafka.client.consumer.KafkaConsumer;
import io.vertx.kafka.client.producer.KafkaProducer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vertx_kafka.handler.IKafkaHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/8 21:43
 * @version:
 * @modified By:
 */
@Configuration
@ConditionalOnProperty(value = "kafka.client.enable",matchIfMissing = true)
public class KafkaClientConfiguration implements BeanPostProcessor, ApplicationContextAware {

    private static final Vertx vertx = Vertx.vertx();

    private ApplicationContext context;

    @Bean
    public List<KafkaConsumer> kafkaConsumers(){
        Map<String, String> config = new HashMap<>();
        config.put("bootstrap.servers", "localhost:9092");
        config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("group.id", "my_group");
        config.put("auto.offset.reset", "earliest");
        config.put("enable.auto.commit", "false");

// use consumer for interacting with Apache Kafka
        List<KafkaConsumer> kafkaConsumers = new ArrayList<>();
        Map<String, IKafkaHandler> consumerHandlers = this.context.getBeansOfType(IKafkaHandler.class);
        for(String kafkaHandlerBean : consumerHandlers.keySet()){
            KafkaConsumer<String, String> consumer = KafkaConsumer.create(vertx, config);
            IKafkaHandler handler = consumerHandlers.get(kafkaHandlerBean);
            consumer.handler(message->handler.handle(message));
            consumer.subscribe(handler.topic());
            kafkaConsumers.add(consumer);
        }
        return kafkaConsumers;
    }

    @Bean
    public KafkaProducer kafkaProducer(){
        Map<String, String> config = new HashMap<>();
        config.put("bootstrap.servers", "localhost:9092");
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("acks", "1");

// use producer for interacting with Apache Kafka
        KafkaProducer<String, String> producer = KafkaProducer.create(vertx, config);
        return producer;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
