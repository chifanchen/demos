package vertx_kafka.handler;

import vertx_kafka.annotation.MessageHandler;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/9 20:21
 * @version:
 * @modified By:
 */
public interface IKafkaHandler<T> {

    /**
     * 处理message的接口
     * @param message
     */
    void handle(T message);
}
