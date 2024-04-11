package in.Raju.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Raju.it.model.Order;
import in.Raju.it.service.OderService;

@RestController
public class OrderController {

	@Autowired
	private OderService oderService;
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody Order order) {
		return oderService.Publishmsg(order);
	}
}
