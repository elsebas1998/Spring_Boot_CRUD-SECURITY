package com.example.userservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class RabbitMQConfig {
    public static final String BEBIDA = "extras.bebida";
    public static final String COMIDA = "extras.comida";
    public static final String RECREACION = "extras.recreacion";
    public static final String SERVICIO = "extras.servicio";
    public static final String TIPOHABITACION = "tipoHabitacion";
    public static final String RESERVA = "reserva";
    //Colas
    @Bean
    Queue bebida(){
        return new Queue(BEBIDA, false);
    }

    @Bean
    Queue comida(){
        return new Queue(COMIDA, false);
    }

    @Bean
    Queue recreacion(){
        return new Queue(RECREACION, false);
    }

    @Bean
    Queue servicio(){
        return new Queue(SERVICIO, false);
    }

    @Bean
    Queue tipoHabitacionDoble(){
        return new Queue("tipoHabitacionSimple", false);
    }
    @Bean
    Queue tipoHabitacionSimple(){
        return new Queue("tipoHabitacionDoble", false);
    }
    @Bean
    Queue reserva(){
        return new Queue(RESERVA, false);
    }
    @Bean
    Queue respaldoA(){
        return new Queue("respaldoA", false);
    }
    @Bean
    Queue respaldoB(){
        return new Queue("respaldoB", false);
    }

    //EXCHANGES
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("exchange.topic");
    }
    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange("exchange.header");
    }
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("exchange.direct");
    }
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("exchange.fanout");
    }
    //Binding Direct
    @Bean
    Binding bindingReserva(Queue reserva, DirectExchange directExchange){
        return BindingBuilder.bind(reserva)
                .to(directExchange)
                .with(RESERVA);
    }
    @Bean
    public Binding bindingFanoutA(Queue respaldoA, FanoutExchange exchangeFanout) {
        return BindingBuilder.bind(respaldoA).to(exchangeFanout);
    }
    @Bean
    public Binding bindingFanoutB(Queue respaldoB, FanoutExchange exchangeFanout) {
        return BindingBuilder.bind(respaldoB).to(exchangeFanout);
    }
    //Binding Header
    @Bean
    public Binding bindingTipoHabitacionSimple(HeadersExchange exchangeHeaders, Queue tipoHabitacionDoble) {
        Map<String, Object> headerValues = new HashMap<>();
        headerValues.put("nombre", "simple");
        return BindingBuilder.bind(tipoHabitacionDoble)
                .to(exchangeHeaders)
                .whereAny(headerValues)
                .match();
    }
    @Bean
    public Binding bindingTipoHabitacionDoble(HeadersExchange exchangeHeaders, Queue tipoHabitacionSimple) {
        Map<String, Object> headerValues = new HashMap<>();
        headerValues.put("nombre", "doble");
        return BindingBuilder.bind(tipoHabitacionSimple)
                .to(exchangeHeaders)
                .whereAny(headerValues)
                .match();
    }

    //Binding Topic
    @Bean
    Binding bindingComida(Queue comida, TopicExchange topicExchange){
        return BindingBuilder.bind(comida)
                .to(topicExchange)
                .with("extras.comida");
    }

    @Bean
    Binding bindingRecreacion(Queue recreacion, TopicExchange topicExchange){
        return BindingBuilder.bind(recreacion)
                .to(topicExchange)
                .with("extras.recreacion");
    }

    @Bean
    Binding bindingServicio(Queue servicio, TopicExchange topicExchange){
        return BindingBuilder.bind(servicio)
                .to(topicExchange)
                .with("extras.servicio");
    }

    @Bean
    Binding bindingBebida(Queue bebida, TopicExchange topicExchange){
        return BindingBuilder.bind(bebida)
                .to(topicExchange)
                .with("extras.bebida");
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}