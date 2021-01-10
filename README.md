# intergrate springboot with vertx-kafka-client

#### 为什么尝试做这个集成

vertx是一套封装了netty的异步事件驱动的框架，netty采用的特殊的线程模型可以高效处理某些情况下的网络通讯，然而这套框架需要程序员使用函数编程的方式。
本项目主要是为了构建一个框架。熟悉springboot编程的程序员只需要通过注解或者接口编程的式就可以使用到 vertx-kafka-client。

#### 如何使用消费者
用户可以通过接口编程的方式的实现来进行 consumer 的使用。继承如下接口即可，使用 MessageHanlder 表明其 topic, 示例说明：
```java
public class Topic1Handler implements IKafkaHandler<Message> {

    private static final Logger logger = LoggerFactory.getLogger(Topic1Handler.class);

    /**
     * msgType 需要和 handle里的参数类型相同
     * @param message
     */
    @MessageHandler(topic = "topic1",msgType = Message.class)
    @Override
    public void handle(Message message) {
        logger.info("topic1 收到消息:{}",message);
    }
}
```


#### 如何使用生产者
通过注入producer即可实现一个默认配置的KafkaProducer,进行消息生产的代码。

```java
@Autowired
KafkaProducer producer;
```
