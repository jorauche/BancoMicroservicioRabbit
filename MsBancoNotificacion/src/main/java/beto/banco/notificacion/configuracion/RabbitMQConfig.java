package beto.banco.notificacion.configuracion;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("beto.notificacionproducto.fanout");
	}
	
	@Bean
	public Queue notificacionProductoQueue() {
		return new Queue("beto.notificacionproducto.queue", true);
	}
	
	// Define Binding binding1
	@Bean
	public Binding binding1(FanoutExchange fanoutExchange,
			Queue notificacionProductoQueue) {
		
		return BindingBuilder
				.bind(notificacionProductoQueue)
				.to(fanoutExchange);
	}
	
	@Bean
	public Queue productoCreadoQueue() {
		return new Queue("beto.productocreado.queue", true);
	}
	
	
}
