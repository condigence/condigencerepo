package com.digitmarket.defaultstore;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
// @SpringBootApplication(exclude =
// org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
//@SpringBootApplication(scanBasePackages = { "com.digitmarket.defaultstore.search" })
@SpringBootApplication
public class Application extends SpringBootServletInitializer  {

	Logger log = Logger.getLogger(Application.class);

	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// application) {
	// return application.sources(Application.class);
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		log.info("Inside run() method");
////		Settings settings = Settings.builder().put("cluster.name", "app-cluster").put("client.transport.sniff", false)
////				.build();
//		//
//		// TransportClient client = new PreBuiltTransportClient(settings);
//		//
//		// client.addTransportAddress(new
//		// InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//		//
//		// // Add documents
//		// IndexResponse response = client.prepareIndex("test", "tests")
//		// .setSource(
//		// jsonBuilder().startObject()
//		// .field("message", "Hello!")
//		// .field("Date", new Date())
//		// .endObject()
//		// ).get();
//	}

}

// @SpringBootApplication
// public class Application implements CommandLineRunner {
//
// Logger log = Logger.getLogger(Application.class);
//
// public static void main(String args[]) {
// SpringApplication.run(Application.class, args);
// }
//
// @Override
// public void run(String... args) throws Exception {
// log.info("Inside run() method");
// Settings settings = Settings.builder().put("cluster.name", "app-cluster")
// .put("client.transport.sniff", true)
// .build();
//
// TransportClient client = new PreBuiltTransportClient(settings);
//
// client.addTransportAddress(new
// InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//
// // Add documents
// IndexResponse response = client.prepareIndex("test", "tests")
// .setSource(
// jsonBuilder().startObject()
// .field("message", "Hello!")
// .field("Date", new Date())
// .endObject()
// ).get();
// }
//
// }
