package com.ex;
public class Abonent {
    public static int id = 0;
    private String Fio;
    private String Phone;
    private String Adress;

    public void setFio(String fio) {
        this.Fio = fio;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public void setAdress(String adress) {
        this.Adress = adress;
    }

    public String getAdress() {
        return this.Adress;
    }

    public String getFio() {
        return this.Fio;
    }

    public String getPhone() {
        return this.Phone;
    }
}
