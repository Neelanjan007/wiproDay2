package com.example.uberconsumer.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UberBooking {
	 private Long id;
	    private String driverName;
	    private String passengerName;
	    private String pickupLocation;
	    private String dropLocation;
	    private BigDecimal fare;
}
