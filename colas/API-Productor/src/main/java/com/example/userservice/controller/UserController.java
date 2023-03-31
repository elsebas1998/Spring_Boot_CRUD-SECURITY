package com.example.userservice.controller;

import com.example.userservice.modelo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/Productor")
public class UserController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;
    @Autowired
    private TopicExchange topicExchange;
    @Autowired
    private FanoutExchange fanoutExchange;
    @Autowired
    private HeadersExchange headersExchange;


    //CRUD admin
    @PostMapping("/comida")
    public String sendComida(@RequestBody Comida comida){
        rabbitTemplate.convertAndSend(topicExchange.getName(), "extras.comida", comida);
        return "Message send successfully to comida";
    }

    @PostMapping("/bebida")
    public String sendBebida(@RequestBody Bebida bebida){
        rabbitTemplate.convertAndSend(topicExchange.getName(), "extras.bebida", bebida);
        return "Message send successfully to bebida";
    }

    @PostMapping("/recreacion")
    public String sendRecreacion(@RequestBody Recreacion recreacion){
        rabbitTemplate.convertAndSend(topicExchange.getName(), "extras.recreacion", recreacion);
        return "Message send successfully to recreacion";
    }

    @PostMapping("/servicio")
    public String sendServicio(@RequestBody Servicio servicio){
        rabbitTemplate.convertAndSend(topicExchange.getName(), "extras.servicio", servicio);
        return "Message send successfully to servicio";
    }

    //Tipo Habitacion
    @PostMapping("/tipoHabitacion")
    public String sendHeader(@RequestBody TipoHabitacion tipoHabitacion) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(); // instancia el objeto ObjectMapper
        String tipoHabitacionJson = mapper.writeValueAsString(tipoHabitacion); // convierte el objeto a JSON

        Message message = MessageBuilder
                .withBody(tipoHabitacionJson.getBytes())
                .setHeader("nombre", tipoHabitacion.getNombre())
                .build();
        rabbitTemplate.convertAndSend(headersExchange.getName(), "", message);
        return "Message send successfully to exchangeHeaders"+message;
    }

    //Reservas
    @PostMapping("/reserva")
    public String sendTipoHabitacion(@RequestBody Reserva reserva){
        rabbitTemplate.convertAndSend(directExchange.getName(), "reserva", reserva);
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", reserva);
        return "Message send successfully to reserva";
    }
}
