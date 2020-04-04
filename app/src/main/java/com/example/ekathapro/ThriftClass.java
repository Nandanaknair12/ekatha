package com.example.ekathapro;

public class ThriftClass {
    String Date;
    int amount;

    public ThriftClass() {
    }

    public ThriftClass(String date, int amount) {
        Date = date;
        this.amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
