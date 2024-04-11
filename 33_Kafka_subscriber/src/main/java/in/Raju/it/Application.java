package in.Raju.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.Raju.it.contentssub.Sub_AppContents;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@KafkaListener(topics = Sub_AppContents.TOPIC, groupId ="group_rajuit_order")
	public void SubscribeMsg(String order) {
		System.out.println("*** Msg Recieved From Kafka *** :: ");
		System.out.println(order);
	}

}
