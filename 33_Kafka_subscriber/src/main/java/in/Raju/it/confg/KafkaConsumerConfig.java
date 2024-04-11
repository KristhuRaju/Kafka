package in.Raju.it.confg;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import in.Raju.it.contentssub.Sub_AppContents;
import in.Raju.it.model.Orders;

@Configuration
public class KafkaConsumerConfig {

	@Bean 
	public ConsumerFactory<String , Orders> consumerFactory(){
		Map<String, Object > consumerprop= new HashMap<String, Object>();
		consumerprop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Sub_AppContents.HOST);
		consumerprop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(consumerprop, new StringDeserializer(), new  JsonDeserializer<>());
		
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String , Orders> kafkaListener(){
		 ConcurrentKafkaListenerContainerFactory<String , Orders> factory= 
				 new ConcurrentKafkaListenerContainerFactory<>();
		 factory.setConsumerFactory(consumerFactory());
		 return factory;
	}
}
