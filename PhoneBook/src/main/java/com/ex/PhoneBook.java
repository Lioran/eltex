package com.ex;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String args[]){
        ArrayList<Abonent> list_of_abonent = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String menu;
        while (true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1. Добавить абонента");
            System.out.println("2. Удалить абонента");
            System.out.println("3. Показать всех абонентов");
            System.out.println("4. Найти абонента");
            Abonent somebody_abonent = new Abonent();
            menu = scanner.next();
            switch (menu){
                case "1":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Введите ФИО, телефон и адрес");
                    somebody_abonent.id++;
                    somebody_abonent.setFio(scanner.next());
                    somebody_abonent.setPhone(scanner.next());
                    somebody_abonent.setAdress(scanner.next());
                    list_of_abonent.add(somebody_abonent);
                }break;
                case "2":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Какого по счету удалить?");
                    list_of_abonent.remove(scanner.nextInt()-1);
                    somebody_abonent.id--;
                }break;
                case "3":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    for(int i = 0; i < list_of_abonent.size(); i++){
                        System.out.println((i+1)+" "+list_of_abonent.get(i).getFio()+" "+list_of_abonent.get(i).getPhone()+" "+list_of_abonent.get(i).getAdress());
                    }
                    System.out.println(" ");
                }break;
                case "4":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Введите ФИО");
                    String fio = scanner.next();
                    for(int i = 0; i < list_of_abonent.size(); i++){
                        if(list_of_abonent.get(i).getFio().equals(fio))
                            System.out.println((i+1)+" "+list_of_abonent.get(i).getFio()+" "+list_of_abonent.get(i).getPhone()+" "+list_of_abonent.get(i).getAdress());
                    }
                }break;
                case "exit":{
                    return;
                }
            }
        }
    }
}
