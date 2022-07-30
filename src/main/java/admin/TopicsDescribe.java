package admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeConfigsResult;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.config.ConfigResource;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class TopicsDescribe {
    private final static String BOOTSTRAP_SERVERS = "lcj0821.synology.me:9092";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);


        try (AdminClient admin = AdminClient.create(configs)) {
            Map<String, TopicDescription> topic = admin.describeTopics(Collections.singleton("test")).all().get();
            System.out.println(topic);
        }
    }
}
