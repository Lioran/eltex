package com.ex;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String args[]){
        ArrayList<Abonent> pb = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1. Добавить абонента");
            System.out.println("2. Удалить абонента");
            System.out.println("3. Показать всех абонентов");
            System.out.println("4. Найти абонента");
            Abonent ab = new Abonent();
            s = scanner.next();
            switch (s){
                case "1":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Введите ФИО, телефон и адрес");
                    ab.id++;
                    ab.setFio(scanner.next());
                    ab.setPhone(scanner.next());
                    ab.setAdress(scanner.next());
                    pb.add(ab);
                }break;
                case "2":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Какого по счету удалить?");
                    pb.remove(scanner.nextInt()-1);
                    ab.id--;
                }break;
                case "3":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    for(int i = 0; i < pb.size(); i++){
                        System.out.println((i+1)+" "+pb.get(i).getFio()+" "+pb.get(i).getPhone()+" "+pb.get(i).getAdress());
                    }
                    System.out.println(" ");
                }break;
                case "4":{
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Введите ФИО");
                    String fio = scanner.next();
                    for(int i = 0; i < pb.size(); i++){
                        if(pb.get(i).getFio().equals(fio))
                            System.out.println((i+1)+" "+pb.get(i).getFio()+" "+pb.get(i).getPhone()+" "+pb.get(i).getAdress());
                    }
                }break;
                case "exit":{
                    return;
                }
            }
        }
    }
}
