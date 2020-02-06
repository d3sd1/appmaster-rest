package com.d3sd1.appmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AppmasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppmasterApplication.class, args);
	}

}

//TODO: revisar al inicio si tiene cordova/node/npm activado: https://tecadmin.net/install-cordova-on-debian/ (si no, instalarlo)