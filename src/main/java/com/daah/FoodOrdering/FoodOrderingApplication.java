package com.daah.FoodOrdering;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodOrderingApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = FoodOrderingApplication.class.getClassLoader();

		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount =
				new FileInputStream("src/main/resources/serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);


		SpringApplication.run(FoodOrderingApplication.class, args);
	}

}
