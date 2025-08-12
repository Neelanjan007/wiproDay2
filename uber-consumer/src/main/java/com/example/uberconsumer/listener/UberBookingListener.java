package com.example.uberconsumer.listener;

import com.example.uberconsumer.model.UberBooking;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UberBookingListener {

    @KafkaListener(topics = "uber-booking-topic", groupId = "uber-group")
    public void consumeUberBooking(UberBooking booking) {
        System.out.println("🚖 Booking Received: " + booking);
    }
}
