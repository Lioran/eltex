package com.ex;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hibernate_abonents")
public class Abonent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id = 1;

    @Column(name = "fio")
    private String Fio;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "adress")
    private String Adress;

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.Fio = fio;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public void setAdress(String adress) {
        this.Adress = adress;
    }

    public Integer getId() { return this.id; }

    public String getAdress() {
        return this.Adress;
    }

    public String getFio() {
        return this.Fio;
    }

    public String getPhone() {
        return this.Phone;
    }

    public Abonent() {}

    public Abonent(String fio, String phone, String adress){
        this.Fio = fio;
        this.Phone = phone;
        this.Adress = adress;
    }
}
