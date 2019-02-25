package com.ex;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

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

    @RequestMapping("/addAbonent")
    public void getAbonent(Map<String, String>WhatCame){
        AbonentInPhoneBook abonentInPhoneBook = new AbonentInPhoneBook();
        Abonent somebodyAbonent = new Abonent();
        somebodyAbonent.setFio(WhatCame.get("fio"));
        somebodyAbonent.setPhone(WhatCame.get("phone"));
        somebodyAbonent.setAdress(WhatCame.get("adress"));
        System.out.println(WhatCame.size()+" "+WhatCame.get("fio")+" "+WhatCame.get("phone")+" "+WhatCame.get("adress"));
        abonentInPhoneBook.save(somebodyAbonent);
    }
}
