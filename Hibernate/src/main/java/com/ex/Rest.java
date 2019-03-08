package com.ex;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс Rest-контроллера
 * @author Dmitrii
 * @version 1.0
 */
@RestController
class Rest{
    /**
     * Функция обрабатывает запрос на вывод слова "hello"
     * @return строка hello
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    /**
     * Функция обрабатывает запрос на вывод всех абонентов из базы данных
     * @return список абонентов
     */
    @RequestMapping("/getAllAbonent")
    public ArrayList<Abonent> getAll(){
        AbonentInPhoneBook abonentInPhoneBook = new AbonentInPhoneBook();
        return (ArrayList<Abonent>)abonentInPhoneBook.getAllAbonent();
    }

    /*@RequestMapping("/addAbonent")
    public void getAbonent(HashMap<String, String> WhatCame){
        AbonentInPhoneBook abonentInPhoneBook = new AbonentInPhoneBook();
        Abonent somebodyAbonent = new Abonent();
        somebodyAbonent.setFio(WhatCame.get("fio"));
        somebodyAbonent.setPhone(WhatCame.get("phone"));
        somebodyAbonent.setAdress(WhatCame.get("adress"));
        System.out.println(WhatCame.size()+" "+WhatCame.get("fio")+" "+WhatCame.get("phone")+" "+WhatCame.get("adress"));
        abonentInPhoneBook.save(somebodyAbonent);
    }*/
    @RequestMapping(value = "/addAbonent", method = RequestMethod.POST)
    public void getAbonent(String WhatCame){
        AbonentInPhoneBook abonentInPhoneBook = new AbonentInPhoneBook();
        Abonent somebodyAbonent = new Abonent();
        System.out.println(WhatCame);
        //abonentInPhoneBook.save(somebodyAbonent);
    }
}
