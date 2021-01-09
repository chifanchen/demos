# demos

尝试在 springboot 中集成 vertx-kafka-client,希望做到的效果是,可以像 springboot 其他注解一样方便使用。
可以用到vertx事件驱动的特性,让coder在编码中通过函数式编程的方式来实现各种事件的handler。

用户可以通过对 {IKafkaHandler} 接口的实现来进行consumer的使用。如下为示例说明：

通过注入producer即可实现一个默认配置的KafkaProducer,进行消息生产的代码。
