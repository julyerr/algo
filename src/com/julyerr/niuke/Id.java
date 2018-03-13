package com.julyerr.niuke;

import java.util.Scanner;

public class Id {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line.replace(" ","");
            for (int i = 0; i < line.length(); i++) {
                if(i==6||i==14){
                    System.out.print(" ");
                }
                System.out.print(line.charAt(i));
            }
            System.out.println();
        }
    }
}
