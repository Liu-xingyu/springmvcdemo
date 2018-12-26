package yerenpeng.test.kafka;

/**
 * Created by YRP-Laptop on 2018/1/4.
 */
public class ConfigureAPI {

    public interface KafkaProperties {
        public final static String ZK = "192.168.239.128:2181,192.168.239.129:2181,192.168.239.130:2181";
        public final static String GROUP_ID = "test-consumer-group";
        public final static String TOPIC = "test1";
        public final static String BROKER_LIST = "192.168.239.128:9092,192.168.239.129:9092,192.168.239.130:9092";
        public final static int BUFFER_SIZE = 64 * 1024;
        public final static int TIMEOUT = 30000;
        public final static int INTERVAL = 1000;
    }
}
