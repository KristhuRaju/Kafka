package in.Raju.it.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import in.Raju.it.contans.AppContants;
import in.Raju.it.model.Order;

@Configuration
public class KafkaProduceConfig {

	@Bean
	public ProducerFactory<String , Order> producerFactory(){
		Map<String, Object> configpro= new HashMap<>();
		
		configpro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppContants.HOST);
		configpro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configpro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		 return new DefaultKafkaProducerFactory<>(configpro);
	}
	
	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
}
