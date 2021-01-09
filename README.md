# demos

尝试在 springboot 中集成 vertx-kafka-client,希望做到的效果是,可以像 springboot 其他注解一样方便使用。
可以用到vertx事件驱动的特性,让coder在编码中通过函数式编程的方式来实现各种事件的handler。


@KafkaConsumer
public void handle(Message message){
}

