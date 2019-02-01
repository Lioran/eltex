package com.ex;

import javax.persistence.*;
import java.io.Serializable;
/**
 *Класс абонент
 * @author Dmitrii
 * @version 1.1
 */
@Entity
@Table(name = "hibernate_abonents")
public class Abonent implements Serializable {
    /**Поле индетификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id = 1;

    /**Поле фио */
    @Column(name = "fio")
    private String Fio;

    /**Поле телефон */
    @Column(name = "phone")
    private String Phone;

    /**Поле адресс */
    @Column(name = "adress")
    private String Adress;

    /**
     * Функция определения значения поля {@link Abonent#id}
     * @param id - индетификатор
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Функция определения значения поля {@link Abonent#Fio}
     * @param fio - фио абонента
     */
    public void setFio(String fio) {
        this.Fio = fio;
    }

    /**
     * Функция определения значения поля {@link Abonent#Phone}
     * @param phone - телефон абонента
     */
    public void setPhone(String phone) {
        this.Phone = phone;
    }

    /**
     * Функция определения значения поля {@link Abonent#Adress}
     * @param adress - адрес абонента
     */
    public void setAdress(String adress) {
        this.Adress = adress;
    }

    /**
     * Функция получения значения поля {@link Abonent#id}
     * @return возвращает индетификатор абонента
     */
    private Integer getId() { return this.id; }

    /**
     * Функция получения значения поля {@link Abonent#Adress}
     * @return возвращает адрес абонента
     */
    public String getAdress() {
        return this.Adress;
    }

    /**
     * Функция получения значения поля {@link Abonent#Fio}
     * @return возвращает фио абонента
     */
    public String getFio() {
        return this.Fio;
    }

    /**
     * Функция получения значения поля {@link Abonent#Phone}
     * @return возвращает телефон абонента
     */
    public String getPhone() {
        return this.Phone;
    }

    /**
     * Конструктор - создание нового абонента
     * @see Abonent#Abonent(String, String, String)
     */
    public Abonent() {}

    /**
     * Конструктор - создание нового абонента с параметрами
     * @param fio - фио абонента
     * @param phone - телефон абонента
     * @param adress - адрес абонента
     * @see Abonent#Abonent()
     */
    public Abonent(String fio, String phone, String adress){
        this.Fio = fio;
        this.Phone = phone;
        this.Adress = adress;
    }
}
