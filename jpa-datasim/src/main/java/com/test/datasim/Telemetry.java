package com.test.datasim;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Telemetry {

    public enum EventType {login, browse, logout}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="cust_id", referencedColumnName = "id")
    private Customer custId;
    private Date eventTime;
    private EventType eventType;

    public Telemetry() {}
    public Telemetry(Customer custId, Date eventTime, EventType eventType) {
        this.custId = custId;
        this.eventTime = eventTime;
        this.eventType = eventType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
