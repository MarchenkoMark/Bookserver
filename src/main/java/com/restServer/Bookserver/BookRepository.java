package com.restServer.Bookserver;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepository extends JpaRepository<Book, Long> {

}
