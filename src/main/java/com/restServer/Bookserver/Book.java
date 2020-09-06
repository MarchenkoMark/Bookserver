package com.restServer.Bookserver;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Book {

    private @Id @GeneratedValue Long id;
    private String title;
    private String text;

    public Book() {}

    public Book(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;
        Book book = (Book) o;
        return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title)
                && Objects.equals(this.text, book.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.title);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + this.id + ", title='" + this.title + '\'' + ", role='" + this.text + '\'' + '}';
    }
}
