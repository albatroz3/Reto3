package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "costume")
public class Costume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String brand;
    private Integer year;
    private String description;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("costumes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "costume")
    @JsonIgnoreProperties({"costume", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "costume")
    @JsonIgnoreProperties({"costume", "message"})
    private List<Reservation> reservations;

    public Integer getId() {
        return Id;
    }

    public String getBrand() {
        return brand;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setId(Integer id) {
        Id = id;
    }
}



