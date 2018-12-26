package yerenpeng.test.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;

import java.util.Properties;

/**
 * Created by YRP-Laptop on 2018/1/4.
 */
public class MyProducer extends Thread{

    private Producer<Integer, String> producer;
    private String topic;
    private Properties props = new Properties();
    private final int SLEEP = 1000 * 3;

    public MyProducer(String topic) {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "192.168.239.128:9092");
        producer = new Producer(new kafka.producer.ProducerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        int offsetNo = 1;
        while (true) {
            String msg = new String("Message_" + offsetNo);
            System.out.println("Send->[" + msg + "]");
            producer.send(new KeyedMessage(topic, msg));
            offsetNo++;
            try {
                sleep(SLEEP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
