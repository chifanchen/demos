package vertx_kafka.service;

import io.vertx.kafka.client.consumer.KafkaConsumer;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.stereotype.Service;

import java.util.logging.Handler;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/9 16:06
 * @version:
 * @modified By:
 */
@Service
public class ConsumerService implements ApplicationRunner {

    @Autowired
    KafkaConsumer consumer;

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        consumer.endHandler(endEvent->logger.info("consumer.end {}",endEvent.toString()));
        consumer.exceptionHandler(exeption->logger.error("consumer exception:{}",exeption.toString()));
        consumer.handler(message->logger.info("收到消息,message={}",message));
        consumer.subscribe("topic1");
    }
}
