package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner s=new Scanner(System.in);
        Casino c=new Casino();
        System.out.println("Welcome to Monte-Carlo");
        System.out.println("Choose your game\n1) Dice\n2) Roulette\n3) Slots");
        Gambler g=new Gambler(4000);
        int m=s.nextInt();
        switch(m){
            case 1: {c.Dice(g); break;}
            case 2: {c.Roulette(g); break;}
            case 3: {c.Slots(g); break;}
        }
    }
}
