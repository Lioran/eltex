package com.ex;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
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

    @RequestMapping(value = "/addAbonent", method = RequestMethod.POST)
    public void getAbonent(@RequestBody String inputStr){
        try{
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, String> jsonStr;
            jsonStr = mapper.readValue(inputStr, new TypeReference<HashMap<String, String>>(){});
            AbonentInPhoneBook abonentInPhoneBook = new AbonentInPhoneBook();
            Abonent somebodyAbonent = new Abonent();
            somebodyAbonent.setFio(jsonStr.get("fio"));
            somebodyAbonent.setPhone(jsonStr.get("phone"));
            somebodyAbonent.setAdress(jsonStr.get("adress"));
            abonentInPhoneBook.save(somebodyAbonent);
        }
        catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
