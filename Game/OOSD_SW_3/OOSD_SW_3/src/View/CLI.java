package View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> messages = new LinkedList<>();


    public static void display(String message) {
        System.out.println(message);
    }
    public static String readFromuser(){
        return scanner.next();
    }
    public static void sendMessage(String m){
        messages.add(m);
    }
    public static void printAllMessages(){
        for (String s: messages) {
            System.out.println(s);
        }
        messages = new LinkedList<>();
    }


}
