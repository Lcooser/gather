package com.example.gather;

import org.springframework.boot.SpringApplication;

public class TestGatherApplication {

	public static void main(String[] args) {
		SpringApplication.from(GatherApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
