package yerenpeng.test.kafka;

/**
 * Created by YRP-Laptop on 2018/1/4.
 */
public class KafkaClient {

    public static void main(String[] args) {
        MyProducer pro = new MyProducer(ConfigureAPI.KafkaProperties.TOPIC);
        pro.start();

        MyConsumer con = new MyConsumer(ConfigureAPI.KafkaProperties.TOPIC);
        con.start();
    }
}
