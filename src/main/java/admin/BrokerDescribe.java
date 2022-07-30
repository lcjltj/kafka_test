package admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeConfigsResult;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.config.ConfigResource;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class BrokerDescribe {
    private final static String BOOTSTRAP_SERVERS = "lcj0821.synology.me:9092";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        final AdminClient admin = AdminClient.create(configs);

        for (Node node : admin.describeCluster().nodes().get()) {
            ConfigResource configResource = new ConfigResource(ConfigResource.Type.BROKER, node.idString());
            DescribeConfigsResult describeConfigsResult = admin.describeConfigs(Collections.singleton(configResource));

            describeConfigsResult.all().get().forEach((broker, config) -> {
                config.entries().forEach(configEntry -> System.out.println(configEntry.name() + "=" + configEntry.value()));
            });
        }
    }
}
