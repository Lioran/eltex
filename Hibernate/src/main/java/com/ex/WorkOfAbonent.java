package com.ex;

import com.ex.Abonent;
import com.ex.AbonentInPhoneBook;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkOfAbonent{
	public static void main(String args[])throws SQLException{
		AbonentInPhoneBook abinpb = new AbonentInPhoneBook();
			while(true){
                System.out.println("1. Добавить абонента");
                System.out.println("2. Удалить абонента");
                System.out.println("3. Показать всех абонентов");
                System.out.println("4. Найти абонента");
                Abonent ab = new Abonent();
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                switch (s){
                    case "1":{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Введите ФИО, телефон и адрес");
                        ab.setFio(scanner.next());
                        ab.setPhone(scanner.next());
                        ab.setAdress(scanner.next());
                        abinpb.save(ab);
                    }break;
                    case "2":{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Введите ФИО, телефон и адрес");
                        ab.setFio(scanner.next());
                        ab.setPhone(scanner.next());
                        ab.setAdress(scanner.next());
                        abinpb.delete(ab);
                    }break;
                    case "3":{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        ArrayList<Abonent> list = new ArrayList<Abonent>();
                        list = (ArrayList<Abonent>)abinpb.getAllAbonent();
                        Abonent it = new Abonent();
                        for(int i = 0; i < list.size(); i++){
                        	System.out.println("id"+list.get(i).id+" fio: "+list.get(i).getFio()+" phone: "+list.get(i).getPhone()+" adress: "+list.get(i).getAdress());
                        }
                    }break;
                    case "4":{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Введите ID");
                        ab = abinpb.findById(scanner.nextInt());
                        System.out.println("id "+ab.id+" fio: "+ab.getFio()+" phone: "+ab.getPhone()+" adress: "+ab.getAdress());
                    }break;
                    case "exit":{
                        return;
                    }
                }
            }
	}
}