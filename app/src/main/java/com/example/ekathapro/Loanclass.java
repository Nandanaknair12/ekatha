package com.example.ekathapro;

public class Loanclass
{
    String date,username;
    int amount;
    Boolean status;

    public Loanclass()
    {
        status=false;
        amount=0;
    }

    public Loanclass(String date, String username, Boolean status, int amount) {
        this.date = date;
        this.username = username;
        this.status = status;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
