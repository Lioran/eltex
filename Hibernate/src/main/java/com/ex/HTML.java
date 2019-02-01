package com.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
/**
 * Класс HTML-контроллера
 * @author Dmitrii
 * @version 1.0
 */
@Controller
class HTML{
    /**
     * Функция обрабатывает запрос на открытие html-страницы
     * @return index.html
     */
    @GetMapping("/")
    public String welcome(){
        return "index";
    }

    /**
     * Функция обрабатывает запрос на открытие html-страницы
     * @return list.html
     */
    @GetMapping("/list")
    public String getAllAbonent(){
        return "list";
    }
}
