package com.example.ms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//		(
//		exclude = { DataSourceAutoConfiguration.class } // DB autoconfigu deaktiv edirik
//)
public class NotificationdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationdemoApplication.class, args);
	}
}
