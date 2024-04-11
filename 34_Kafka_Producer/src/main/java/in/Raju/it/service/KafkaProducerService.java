package in.Raju.it.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.Raju.it.contantes.AppConstants;

@Service

public class KafkaProducerService {

	private static final org.slf4j.Logger  Logger= LoggerFactory .getLogger(KafkaProducerService.class);
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendmesssage(String message) {
		Logger.info(String.format("Message sent -> %s", message));
		kafkaTemplate.send(AppConstants.TOPIC_NAME,message);
		
	}
	
}
