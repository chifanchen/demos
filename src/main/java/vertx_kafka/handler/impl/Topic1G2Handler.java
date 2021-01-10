package vertx_kafka.handler.impl;

import io.vertx.kafka.client.consumer.KafkaConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import vertx_kafka.annotation.MessageHandler;
import vertx_kafka.common.Message;
import vertx_kafka.handler.IKafkaHandler;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/9 20:23
 * @version:
 * @modified By:
 */
@Component
public class Topic1G2Handler implements IKafkaHandler<Message> {

    private static final Logger logger = LoggerFactory.getLogger(Topic1Handler.class);

    /**
     * msgType 需要和 handle里的参数类型相同
     * @param message
     */
    @MessageHandler(topic = "topic1",msgType = Message.class,consumerGroup = "group1")
    @Override
    public void handle(Message message) {
        logger.info("topic1-group1 handler {} 收到消息:{}",Topic1G2Handler.class,message);
    }
}
