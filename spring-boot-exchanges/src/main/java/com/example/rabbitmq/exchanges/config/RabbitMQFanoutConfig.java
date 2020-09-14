package com.example.rabbitmq.exchanges.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

	//	@Bean
	//	Queue marketingFanoutQueue() {
	//		return new Queue("marketingQueue", false);
	//	}
	//
	//	@Bean
	//	Queue financeFanoutQueue() {
	//		return new Queue("financeQueue", false);
	//	}
	//
	//	@Bean
	//	Queue adminFanoutQueue() {
	//		return new Queue("adminQueue", false);
	//	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanout-exchange");
	}

	@Bean
	Binding marketingFanoutBinding(Queue marketingQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(marketingQueue).to(fanoutExchange);
	}

	@Bean
	Binding financeFanoutBinding(Queue financeQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(financeQueue).to(fanoutExchange);
	}

	@Bean
	Binding adminFanoutBinding(Queue adminQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(adminQueue).to(fanoutExchange);
	}

}