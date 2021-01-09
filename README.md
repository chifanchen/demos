# intergrate springboot with-vertx-kafka-client

#### 为什么尝试做这个集成

vertx是一套封装了netty的异步事件驱动的框架，netty采用的特殊的线程模型可以高效处理某些情况下的网络通讯，然而这套框架需要程序员使用函数编程的方式。
本项目主要是为了构建一个框架。熟悉springboot编程的程序员只需要通过注解或者接口编程的式就可以使用到 vertx-kafka-client。

#### 如何使用消费者
用户可以通过对 {IKafkaHandler} 接口的实现来进行consumer的使用。如下为示例说明：

#### 如何使用生产者
通过注入producer即可实现一个默认配置的KafkaProducer,进行消息生产的代码。
