package com.unab.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.core.SpringVersion;


@SpringBootApplication
public class Application2Application {

/*	 public static void main(String[] args) {
	      SpringApplication springApplication=new SpringApplication(Application2Application.class);
	      System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
	      springApplication.run(args);

	  }
*/
	public static void main(String[] args) {
		SpringApplication.run(Application2Application.class, args);
	}
}
