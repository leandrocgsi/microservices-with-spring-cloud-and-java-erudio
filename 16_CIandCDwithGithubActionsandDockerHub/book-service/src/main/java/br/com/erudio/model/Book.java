package br.com.erudio.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 180)
    private String author;

    @Column(nullable = false, length = 250)
    private String title;

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(nullable = false)
    private Double price;

    @Transient
    private String currency;

    @Transient
    private String environment;

    public Book(){}

    public Book(Long id, String author, String title,
                Date launchDate, Double price,
                String currency, String environment) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.launchDate = launchDate;
        this.price = price;
        this.currency = currency;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getLaunchDate(), book.getLaunchDate()) && Objects.equals(getPrice(), book.getPrice()) && Objects.equals(getCurrency(), book.getCurrency()) && Objects.equals(getEnvironment(), book.getEnvironment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getTitle(), getLaunchDate(), getPrice(), getCurrency(), getEnvironment());
    }
}
