package test.kafka2;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by YRP-Laptop on 2018/1/5.
 */
public class ProducerDemo {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();

        props.put("zk.connect", "192.168.239.128:2181,192.168.239.129:2181,192.168.239.130:2181");

        props.put("metadata.broker.list","192.168.239.128:9092,192.168.239.129:9092,192.168.239.130:9092");

        props.put("serializer.class", "kafka.serializer.StringEncoder");

        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<String, String>(config);



        // 发送业务消息

        // 读取文件 读取内存数据库 读socket端口

        for (int i = 1; i <= 100; i++) {

            Thread.sleep(2000);
//            "i said i love you baby for " + i + " times,will you have a nice day with me tomorrow"

            producer.send(new KeyedMessage<String, String>("test1",

                    "Kafka link java is successfully for " + i + " times."));

        }



    }
}
