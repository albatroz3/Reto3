package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "costume_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Costume costume;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getIdMessage() {
        return IdMessage;
    }

    public void setIdMessage(Integer idMessage) {
        IdMessage = idMessage;
    }

    public Object getId() {
        return null;
    }
}
