package com.example.demo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
