package in.Raju.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.Raju.it.service.KafkaProducerService;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

	
	private KafkaProducerService kafkaProducerService;

	public KafkaProducerController(KafkaProducerService kafkaProducerService) {
		super();
		this.kafkaProducerService = kafkaProducerService;
	}
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducerService.sendmesssage(message);
		return ResponseEntity.ok("Message sent to Kafka Server");
	}
}
