package sample;

import sample.databases.*;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.println("1 - Menu\n" + "2 - End\n");
        int a = scanner.nextInt();
        int i = 0;
        boolean b = true;
        while (b) {
            switch (a) {
                case 1: {
                    menu.startMenu();
                    break;
                }
/*                case 2:{
                    System.out.println("You have closed the programme. :D");
                    b = false;
                    break;
                }*/
            }
        }
    }
}