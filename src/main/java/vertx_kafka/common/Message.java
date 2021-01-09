package vertx_kafka.common;

import lombok.Data;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/8 21:56
 * @version:
 * @modified By:
 */
@Data
public class Message<T> {

    private String messageId;
    private T data;
}
