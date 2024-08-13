package com.cathaybk.javaedu.lesson1.practice;

public class Triangle {

    public static void main(String[] args) {
        int length = 10;
        
        for (int j = 0; j <= length; j++) {//橫列
            for (int i = 0; i <=j; i++) {//直行
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}