package com.neelanjan.controller;

import com.neelanjan.entity.Booking;
import com.neelanjan.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	 private final BookingService bookingService;

	    public BookingController(BookingService bookingService) {
	        this.bookingService = bookingService;
	    }

	    @PostMapping
	    public Booking createBooking(@RequestBody Booking booking) {
	        return bookingService.createBooking(booking);
	    }

	    @GetMapping
	    public List<Booking> getAllBookings() {
	        return bookingService.getAllBookings();
	    }
}
