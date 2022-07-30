package admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

public class SimpleAdmin {
    private final static String BOOTSTRAP_SERVERS = "lcj0821.synology.me:9092";

    public static void main(String[] args) {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        final AdminClient admin = AdminClient.create(configs);
    }
}
