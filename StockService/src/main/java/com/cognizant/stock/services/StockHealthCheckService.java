package com.cognizant.stock.services;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class StockHealthCheckService implements HealthIndicator {

	int healthCodeValue = 0;

	@Override
	public Health health() {
		System.out.println("Heath Indicator Value : " + healthCodeValue);
		if (healthCodeValue > 4 && healthCodeValue < 8) {
			Health.down().withDetail("ERROR_CODE_101", "Service is down");
		}
		healthCodeValue ++;
		return Health.up().build();
	}
}
