package pl.kris.invoicespringmvc.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    private Long id;
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // formatuje datę z parametru w endpoint i określa jaki format
    private LocalDate date;
    private String name;

    public Invoice(Long id, BigDecimal price, LocalDate date, String name) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
