package com.team4.model.tuanModel;

public class CurrencyWallet {
    private int id;
    private String name;
    private Wallet wallet;

    public CurrencyWallet() {
    }

    public CurrencyWallet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD:src/main/java/com/team4/model/CurrencyWallet.java
    @Override
    public String toString() {
        return "CurrencyWallet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
=======
    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
>>>>>>> 70285c122a6a14d34f74703d5a13330a70e63144:src/main/java/com/team4/model/tuanModel/CurrencyWallet.java
    }
}
