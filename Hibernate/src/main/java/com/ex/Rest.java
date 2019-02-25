package com.ex;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

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
        AbonentInPhoneBook abinpb = new AbonentInPhoneBook();
        return (ArrayList<Abonent>)abinpb.getAllAbonent();
    }
}
