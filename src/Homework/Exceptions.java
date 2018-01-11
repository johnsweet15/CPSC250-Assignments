package Homework;

import java.io.IOException;

public class Exceptions {
	public static void main(String[] args) {
        foo();
    }
    public static void foo() {
        try {
            System.out.print("1");
            goo();
            System.out.print("2");
        } catch (IOException e) {
            System.out.print("3");
            return;
        } catch (Exception e) {
            System.out.print("4");
        } finally {
            System.out.print("5");
        }
        System.out.print("6");
    }
    
    public static void goo() throws Exception {
        throw new IOException();
    }


}


