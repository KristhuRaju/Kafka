package in.Raju.it.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import in.Raju.it.contantes.AppConstants;

@Service
public class KafKaConsumerService {

	private static final Logger LOGGER=LoggerFactory.getLogger(KafKaConsumerService.class);
	
	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	public void consume (String message) {
		LOGGER.info(String.format("Meaage Recivied -> %s",message));
	}
}
