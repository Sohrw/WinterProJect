package com.example.moacall;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AcceptData implements Serializable {

    @SerializedName("orderId")
    private Long id;

    @SerializedName("orderDate")
    private String startTime;

    private String acceptTime;

    @SerializedName("foodAddress")
    private Address foodAddress;

    @SerializedName("clientAddress")
    private Address clientAddress;
    @SerializedName("memo")
    private String clientMemo;
    @SerializedName("totalPrice")
    private int clientPrice;
    @SerializedName("deliveryPrice")
    private int deliveryPrice;
    @SerializedName("orderStatus")
    private DeliveryStatus status;
    @SerializedName("paymentType")
    private PaymentType paymentType;
    

    public AcceptData(Long id, String startTime, String acceptTime, Address foodAddress, Address clientAddress, String clientMemo, int clientPrice, int deliveryPrice, DeliveryStatus status, PaymentType paymentType) {
        this.id = id;
        this.startTime = startTime;
        this.acceptTime = acceptTime;
        this.foodAddress = foodAddress;
        this.clientAddress = clientAddress;
        this.clientMemo = clientMemo;
        this.clientPrice = clientPrice;
        this.deliveryPrice = deliveryPrice;
        this.status = status;
        this.paymentType = paymentType;
    }


    public String getAcceptTime() {
        return acceptTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public void setFoodAddress(Address foodAddress) {
        this.foodAddress = foodAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setClientMemo(String clientMemo) {
        this.clientMemo = clientMemo;
    }

    public void setClientPrice(int clientPrice) {
        this.clientPrice = clientPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public String getStartTime() {
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
