package com.julyerr.niuke;

import java.util.Scanner;

public class ExtractExtension {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int index = line.lastIndexOf(".");
            if(index == -1){
                System.out.println("null");
            }else{
                System.out.println(line.substring(index+1));
            }
        }
    }
}
