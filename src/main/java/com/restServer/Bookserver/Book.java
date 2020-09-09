package com.restServer.Bookserver;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Book {

    private @Id @GeneratedValue Long id;
    private String imageUrl;
    private String title;
    private String text;
    private String price;
    private String link;
    public Book() {}

    public Book(String title, String text, String price, String link, String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.text = text;
        this.price = price;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        return "Book{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price='" + price + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
