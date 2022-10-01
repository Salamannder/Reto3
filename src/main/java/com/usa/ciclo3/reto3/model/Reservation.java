package com.usa.ciclo3.reto3.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ididReservation;
   

    private Date startDate;
    private Date devolutionDate;
    private String status="created";


    @ManyToOne
    @JoinColumn(name = "partyroomId")
    @JsonIgnoreProperties({ "reservation" })
    private Partyroom partyroom;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({ "reservation" })
    private Client client;

    @OneToMany(mappedBy = "reservation")
    @JsonIgnoreProperties({ "reservation" })
    private List<Score> score;

    public Integer getIdidReservation() {
        return ididReservation;
    }

    public void setIdidReservation(Integer ididReservation) {
        this.ididReservation = ididReservation;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

   
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 
    public Partyroom getPartyroom() {
        return partyroom;
    }

    public void setPartyroom(Partyroom partyroom) {
        this.partyroom = partyroom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }
}