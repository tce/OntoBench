package de.linkvt.bachelor;

import de.linkvt.bachelor.config.OwlApiConfig;
import de.linkvt.bachelor.config.PersistenceConfig;
import de.linkvt.bachelor.config.WebMvcConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * The entry point of the application.
 */
@SpringBootApplication
@Import({WebMvcConfig.class, OwlApiConfig.class, PersistenceConfig.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
