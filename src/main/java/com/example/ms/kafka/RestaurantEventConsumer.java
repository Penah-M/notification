package com.example.ms.kafka;

import com.example.ms.yoxlama.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RestaurantEventConsumer {
    EmailService mailService;
    @KafkaListener(topics = "restaurant", groupId = "restaurant-service")
    public void consume(RestaurantEvent event) {
        log.info("mail sending -> {}", event);
        mailService.send("Godermek istdiyiniz email",event.getName(), event.getAddress());
        log.info("mail sended {}", event.getName());
    }
}
