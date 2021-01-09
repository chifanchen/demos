package vertx_kafka.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import vertx_kafka.annotation.MessageHandler;
import vertx_kafka.handler.IKafkaHandler;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/9 20:23
 * @version:
 * @modified By:
 */
@Component
public class Topic1Handler<String> implements IKafkaHandler<String> {

    private static final Logger logger = LoggerFactory.getLogger(Topic1Handler.class);

    @Override
    public void handle(String message) {
        logger.info("topic1 消息来了,message = {}",message);
    }

    @Override
    public java.lang.String topic() {
        return "topic1";
    }
}
