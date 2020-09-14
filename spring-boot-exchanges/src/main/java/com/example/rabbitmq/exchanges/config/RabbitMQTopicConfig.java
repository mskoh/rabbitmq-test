package com.example.rabbitmq.exchanges.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

	//	@Bean
	//	Queue marketingTopicQueue() {
	//		return new Queue("marketingQueue", false);
	//	}
	//
	//	@Bean
	//	Queue financeTopicQueue() {
	//		return new Queue("financeQueue", false);
	//	}
	//
	//	@Bean
	//	Queue adminTopicQueue() {
	//		return new Queue("adminQueue", false);
	//	}
	//
	@Bean
	Queue allQueue() {
		return new Queue("allQueue", false);
	}

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange("topic-exchange");
	}

	@Bean
	Binding marketingTopicBinding(Queue marketingQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(marketingQueue).to(topicExchange).with("queue.marketing");
	}

	@Bean
	Binding financeTopicBinding(Queue financeQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(financeQueue).to(topicExchange).with("queue.finance");
	}

	@Bean
	Binding adminTopicBinding(Queue adminQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(adminQueue).to(topicExchange).with("queue.admin");
	}

	@Bean
	Binding allTopicBinding(Queue allQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
	}

}
