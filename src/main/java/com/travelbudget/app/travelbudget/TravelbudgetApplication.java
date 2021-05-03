package com.travelbudget.app.travelbudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TravelbudgetApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TravelbudgetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO trip (idtrip, name) VALUES(?,?)";
		int result = jdbcTemplate.update(sql, "1","bali");
		if (result > 0) System.out.println("A new row has been inserted");
	}
}
