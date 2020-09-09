package com.restServer.Bookserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Book("Java Core", "Core Java, Eleventh Edition, is the definitive guide to writing robust, maintainable code.", "$50", "https://eloquentjavascript.net", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fvk.com%2Fwall-54530371_235840&psig=AOvVaw1bOXxvA-Y6NLYR2erhE5sE&ust=1599736594323000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIChmK_52-sCFQAAAAAdAAAAABAD")));
            log.info("Preloading " + repository.save(new Book("FEYNMAN", "Legendary lectures", "$20", "https://www.google.com.ua/?hl=ru", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fvk.com%2Fwall-54530371_235840&psig=AOvVaw1bOXxvA-Y6NLYR2erhE5sE&ust=1599736594323000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIChmK_52-sCFQAAAAAdAAAAABAD")));
            log.info("Preloading " + repository.save(new Book("HAWKING", "Everything about time", "$35", "https://www.google.com.ua/?hl=ru", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fvk.com%2Fwall-54530371_235840&psig=AOvVaw1bOXxvA-Y6NLYR2erhE5sE&ust=1599736594323000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIChmK_52-sCFQAAAAAdAAAAABAD")));
            log.info("Preloading " + repository.save(new Book("LANDAU", "Best formulae book", "$10", "https://www.google.com.ua/?hl=ru", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fvk.com%2Fwall-54530371_235840&psig=AOvVaw1bOXxvA-Y6NLYR2erhE5sE&ust=1599736594323000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIChmK_52-sCFQAAAAAdAAAAABAD")));
            log.info("Preloading " + repository.save(new Book("ELOQUENT JAVASCRIPT", "Legendary lectures", "$00", "https://www.google.com.ua/?hl=ru", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fvk.com%2Fwall-54530371_235840&psig=AOvVaw1bOXxvA-Y6NLYR2erhE5sE&ust=1599736594323000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIChmK_52-sCFQAAAAAdAAAAABAD")));
        };
    }
        /*
            [
            {"id" : 0, "imageUrl" : "/assets/img/java.jpg", "title" : "Java Core", "text": "Core Java, Eleventh Edition, is the definitive guide to writing robust, maintainable code.", "price": "$50", "link":  "https://eloquentjavascript.net"},
            {"id" : 1, "imageUrl" : "/assets/img/feynman.jpg", "title" : "FEYNMAN", "text": "Legendary lectures", "price": "$20", "link":  "https://www.google.com.ua/?hl=ru"},
            {"id" : 2, "imageUrl" : "/assets/img/hoking.jpg", "title" : "HAWKING", "text": "Everything about time", "price": "$35", "link":  "https://www.google.com.ua/?hl=ru"},
            {"id" : 3, "imageUrl" : "/assets/img/landau.jpg", "title" : "LANDAU", "text": "Best formulae book", "price": "$10", "link":  "https://www.google.com.ua/?hl=ru"},
            {"id" : 4, "imageUrl" : "/assets/img/6013269360.jpg", "title" : "ALGORITHMS", "text": "Lorem ipsum dolor sit amet", "price": "$15", "link":  "https://www.google.com.ua/?hl=ru"},
            {"id" : 5, "imageUrl" : "/assets/img/astrophysics.jpg", "title" : "Neil Tyson", "text": "Astrophysics for people in a hurry", "price": "$25", "link":  "https://www.google.com.ua/?hl=ru"},
            {"id" : 6, "imageUrl" : "/assets/img/javascript.jpg", "title" : "Eloquent javascript", "text": "The best free online JavaScript book", "price": "$00", "link":  "https://eloquentjavascript.net"}
            ]
         */
}
