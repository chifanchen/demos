package vertx_kafka.handler.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import vertx_kafka.handler.IKafkaHandler;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/9 20:57
 * @version:
 * @modified By:
 */
@Component
public class Topic2Handler<String> implements IKafkaHandler<String> {

    private static final Logger logger = LoggerFactory.getLogger(Topic2Handler.class);

    @Override
    public void handle(String message) {
        logger.info("topic2 消息来了,message = {}",message);
    }

    @Override
    public java.lang.String topic() {
        return "topic2";
    }

}
