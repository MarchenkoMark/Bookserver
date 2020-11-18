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
            log.info("Preloading " + repository.save(new Book("Java Core", "Core Java, Eleventh Edition, is the definitive guide to writing robust, maintainable code.", 50, "https://rozetka.com.ua/185247917/p185247917/", "/assets/img/java.jpg")));
            log.info("Preloading " + repository.save(new Book("FEYNMAN", "Legendary lectures", 20, "http://www.all-fizika.com/article/index.php?id_article=35", "/assets/img/feynman.jpg")));
            log.info("Preloading " + repository.save(new Book("HAWKING", "Everything about time", 35, "https://rozetka.com.ua/226805749/p226805749/?gclid=Cj0KCQiAqdP9BRDVARIsAGSZ8AkMNWUILQRbWStYevFXkytJGIKmMcer3dQRlyQusoCn62Gri1FnW3EaAlK1EALw_wcB", "/assets/img/hoking.jpg")));
            log.info("Preloading " + repository.save(new Book("LANDAU", "Best formulae book", 25, "https://www.labirint.ru/books/509922/", "/assets/img/landau.jpg")));
            log.info("Preloading " + repository.save(new Book("Neil Tyson", "Astrophysics for people in a hurry", 10, "https://www.amazon.com/Astrophysics-People-Hurry-deGrasse-Tyson/dp/0393609391", "/assets/img/astrophysics.jpg")));
            log.info("Preloading " + repository.save(new Book("ELOQUENT JAVASCRIPT", "Legendary lectures", 0, "https://eloquentjavascript.net", "/assets/img/javascript.jpg")));
        };
    }
}
