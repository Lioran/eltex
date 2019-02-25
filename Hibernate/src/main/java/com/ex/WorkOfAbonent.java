package com.ex;

import java.util.Scanner;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Класс для работы с bабонентами в телефонной книге
 * @author Dmitrii
 * @version 1.0
 */
public class WorkOfAbonent{
    private final static Logger log = Logger.getLogger(WorkOfAbonent.class);

    /**
     * Точка входа программы
     * @param args - параметры запуска программы
     */
    public static void main(String args[]){
		AbonentInPhoneBook abonentInPhoneBook = new AbonentInPhoneBook();
			while(true){
			    log.info("Запуск меню");
                System.out.println("1. Добавить абонента");
                System.out.println("2. Удалить абонента");
                System.out.println("3. Показать всех абонентов");
                System.out.println("4. Найти абонента");
                Abonent somebody_abonent = new Abonent();
                Scanner scanner = new Scanner(System.in);
                String menu = scanner.next();
                switch (menu){
                    case "1":{
                        log.info("Выбор первого пункта");
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Введите ФИО, телефон и адрес");
                        somebody_abonent.id++;
                        somebody_abonent.setFio(scanner.next());
                        somebody_abonent.setPhone(scanner.next());
                        somebody_abonent.setAdress(scanner.next());
                        abonentInPhoneBook.save(somebody_abonent);
                    }break;
                    case "2":{
                        log.info("Выбор второго пункта");
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Введите ФИО, телефон и адрес");
                        somebody_abonent.setFio(scanner.next());
                        somebody_abonent.setPhone(scanner.next());
                        somebody_abonent.setAdress(scanner.next());
                        abonentInPhoneBook.delete(somebody_abonent);
                    }break;
                    case "3":{
                        log.info("Выбор третьего пункта");
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        List<Abonent> list = abonentInPhoneBook.getAllAbonent();
                        for(int i = 0; i < list.size(); i++){
                        	System.out.println("id"+list.get(i).id+" fio: "+list.get(i).getFio()+" phone: "+list.get(i).getPhone()+" adress: "+list.get(i).getAdress());
                        }
                    }break;
                    case "4":{
                        log.info("Выбор четвертого пункта");
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Введите ID");
                        somebody_abonent = abonentInPhoneBook.findById(scanner.nextInt());
                        System.out.println("id "+somebody_abonent.id+" fio: "+somebody_abonent.getFio()+" phone: "+somebody_abonent.getPhone()+" adress: "+somebody_abonent.getAdress());
                    }break;
                    case "exit":{
                        log.info("Выход из меню. Конец программы");
                        return;
                    }
                }
            }
	}
}