package vertx_kafka.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @description:
 * @author: 范晨
 * @date: Created in 2021/1/9 18:39
 * @version:
 * @modified By:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MessageHandler {

    @AliasFor("topic")
    String value() default "";

    /**
     * 消息主题
     * @return
     */
    @AliasFor("value")
    String topic() default "";

    /**
     * partition -1表示不指定 partition
     * @return
     */
    int partition() default -1;

    /**
     * kafka消息的type,默认为String类型
     * @return
     */
    Class msgType() default String.class;

    /**
     * consumer group
     * @return
     */
    String consumerGroup() default "";
}