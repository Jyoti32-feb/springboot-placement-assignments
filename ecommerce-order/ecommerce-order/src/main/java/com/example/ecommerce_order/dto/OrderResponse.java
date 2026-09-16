package com.example.ecommerce_order.dto;

public class OrderResponse {

    private String message;
    private int orderId;
    private String customerName;
    private double grossAmount;
    private double discountAmount;
    private double finalAmount;

    public OrderResponse() {
    }

    public OrderResponse(String message,
                         int orderId,
                         String customerName,
                         double grossAmount,
                         double discountAmount,
                         double finalAmount) {
        this.message = message;
        this.orderId = orderId;
        this.customerName = customerName;
        this.grossAmount = grossAmount;
        this.discountAmount = discountAmount;
        this.finalAmount = finalAmount;
    }

    public String getMessage() {
        return message;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getGrossAmount() {
        return grossAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setGrossAmount(double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
