package com.ex;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *Класс Application
 * @author Dmitrii
 * @version 1.1
 */
@SpringBootApplication
@ComponentScan
public class Application{
    final static Logger log = Logger.getLogger(Application.class);
    /**
     * Точка входа программы
     * @param args - параметры для запуска
     */
    public static void main(String []args){
        log.info("Запуск приложения");
        SpringApplication.run(Application.class, args);
    }
}
