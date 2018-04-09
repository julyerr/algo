package com.julyerr.realInterview.exams.jd.chunzhao2018;

import java.util.Scanner;
import java.util.Stack;

public class KuoHao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            while(n-->0){
                String line = scanner.next();
                int left =0;
                int right =0;
                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i)=='('){
                        left++;
                    }else{
                        right++;
                    }
                }
                if(left!=right){
                    System.out.println("No");
                }else{
                    Stack<Character> stack = new Stack<>();
                    int more=0;
                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if(c=='('){
                            stack.add(c);
                        }else{
                            if(stack.isEmpty()){
                                stack.add(c);
                            }else if(stack.peek()=='('){
                                stack.pop();
                            }
                        }
                    }
                    if(stack.size()<=2){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }
            }
        }
    }
}
/*
2
())(
)))(((
* */