package beto.banco.credito.configuracion;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	// Define bean FanoutExchange fanoutExchange
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("beto.productocreado.fanout");
	}
	
	// Define bean Queue userCreatedAccountQueue
	@Bean
	public Queue productoCreadoQueue() {
		return new Queue("beto.productocreado.queue", true);
	}


	// Define Binding binding1
	@Bean
	public Binding binding1(FanoutExchange fanoutExchange,
			Queue productoCreadoQueue) {
		
		return BindingBuilder
				.bind(productoCreadoQueue)
				.to(fanoutExchange);
	}
	
	@Bean
	public Queue usuarioCreadoQueue() {
		return new Queue("beto.usuariocreado.queue", true);
	}


}
