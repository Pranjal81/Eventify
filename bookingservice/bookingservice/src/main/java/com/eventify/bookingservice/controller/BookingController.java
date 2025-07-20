package com.eventify.bookingservice.controller;

import com.eventify.bookingservice.model.Booking;
import com.eventify.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topic.name}")
    private String topicName;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        booking.setBookingStatus("Confirmed");
        Booking savedBooking = bookingRepository.save(booking);

        String message = "Booking confirmed for " + booking.getUserName() + " for Event ID: " + booking.getEventId();
        kafkaTemplate.send(topicName, message);

        return savedBooking;
    }

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @DeleteMapping("/id")
    public String deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return "Booking Deleted Successfully";
    }
}
