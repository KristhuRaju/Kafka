package in.Raju.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.Raju.it.contans.AppContants;
import in.Raju.it.model.Order;

@Service
public class OderService {

	@Autowired
	private KafkaTemplate<String , Order> kafkaTemplate;
	
	public String Publishmsg(Order order) {
		kafkaTemplate.send(AppContants.TOPIC, order);
		return "Message published to kafka topic";
	}
}
