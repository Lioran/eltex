package com.ex;

import java.sql.*;
import java.util.Scanner;

public class JavaToMySql {
    private static final String url = "jdbc:mysql://localhost:3306/phonebook";
    private static final String user = "Dimas";
    private static final String password = "YOUR_PASSWORD";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static String addToJDBC(Abonent ab){
        String query = "INSERT INTO abonents (fio, phone, adress) VALUE('"+ab.getFio()+"','"+ab.getPhone()+"','"+ab.getAdress()+"');";
        return query;
    }
    public static String delToJDBC(int num){
        String query = "DELETE FROM abonents WHERE id = "+num+";";
        return query;
    }
    public static String allToJDBC(){
        String query = "SELECT * FROM abonents;";
        return query;
    }
    public static String searchToJDBC(String fio){
        String query = "SELECT * FROM abonents WHERE fio = "+fio+";";
        return query;
    }
    public final static void main(String[] args){
        try{
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            String query = "", s;
            while(true){
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
                        ab.setFio(scanner.next());
                        ab.setPhone(scanner.next());
                        ab.setAdress(scanner.next());
                        query = addToJDBC(ab);
                        stmt.executeUpdate(query);

                    }break;
                    case "2":{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Какого по счету удалить?");
                        query = delToJDBC(scanner.nextInt());
                        stmt.executeUpdate(query);
                    }break;
                    case "3":{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        query = allToJDBC();
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String fio = rs.getString("fio");
                            String phone = rs.getString("phone");
                            String adress = rs.getString("adress");
                            System.out.println(id+" fio: "+fio+" phone: "+phone+" adress: "+adress);
                        }
                    }break;
                    case "4":{
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Введите ФИО");
                        String fio_s = scanner.next();
                        query = searchToJDBC(fio_s);
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            String fio = rs.getString(2);
                            String phone = rs.getString(3);
                            String adress = rs.getString(4);
                            System.out.println(id+" fio: "+fio+" phone: "+phone+" adress: "+adress);
                        }
                    }break;
                    case "exit":{
                        return;
                    }
                }
            }
        }catch(SQLException sqlEx){
            sqlEx.printStackTrace();

        }finally {
            try { con.close(); } catch(SQLException se) { System.out.println(se.toString()); }
            try { stmt.close(); } catch(SQLException se) { System.out.println(se.toString()); }
            try { rs.close(); } catch(SQLException se) { System.out.println(se.toString()); }
        }
    }
}
