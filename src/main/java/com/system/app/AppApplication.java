package com.system.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.system.app.entities.Order;
import com.system.app.services.OrderService;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var order = new Order(2282, 95.90, 0.0);
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("%s %.2f%n", "Valor total: R$", orderService.total(order));
	}

}
