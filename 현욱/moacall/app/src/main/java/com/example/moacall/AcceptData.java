package com.example.moacall;

import java.time.LocalDateTime;

public class AcceptData {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime acceptTime;
    private Address foodAddress;
    private Address clientAddress;
    private String clientMemo;
    private int clientPrice;
    private int deliveryPrice;
    private DeliveryStatus status;
    

    public AcceptData(Long id, LocalDateTime startTime, LocalDateTime acceptTime, Address foodAddress, Address clientAddress, String clientMemo, int clientPrice, int deliveryPrice, DeliveryStatus status) {
        this.id = id;
        this.startTime = startTime;
        this.acceptTime = acceptTime;
        this.foodAddress = foodAddress;
        this.clientAddress = clientAddress;
        this.clientMemo = clientMemo;
        this.clientPrice = clientPrice;
        this.deliveryPrice = deliveryPrice;
        this.status = status;
    }


    public LocalDateTime getAcceptTime() {
        return acceptTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getFoodAddress() {
        return foodAddress.toString();
    }

    public String getClientAddress() {
        return clientAddress.toString();
    }

    public String getClientMemo() {
        return clientMemo;
    }

    public int getClientPrice() {
        return clientPrice;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public DeliveryStatus getStatus() {
        return status;
    }
}
