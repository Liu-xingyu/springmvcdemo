package test.kafka3;

/**
 * Created by YRP-Laptop on 2018/2/7.
 */
public class JavaKafkaConsumerHighAPITest {
    public static void main(String[] args) {
        String zookeeper = "192.168.239.129:2181";
        String groupId = "test-consumer-group";
        String topic = "test1";
        int threads = 1;

        JavaKafkaConsumerHighAPI example = new JavaKafkaConsumerHighAPI(topic, threads, zookeeper, groupId);
        new Thread(example).start();

        // 执行10秒后结束
        int sleepMillis = 1000;
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭
        example.shutdown();
    }
}
