package consumer;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;

public class RebalanceListener implements ConsumerRebalanceListener {
    @Override
    public void onPartitionsRevoked(final Collection<TopicPartition> partitions) {
        System.out.println("Partition are revoked" + partitions.toString());
    }

    @Override
    public void onPartitionsAssigned(final Collection<TopicPartition> partitions) {
        System.out.println("Partition are assigned" + partitions.toString());

    }
}
