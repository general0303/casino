package com.company;
import java.util.Random;
import java.util.Scanner;

public class Casino implements Random1{
    private int m;
    Random r=new Random();
    Scanner s=new Scanner(System.in);
    static int bet;
    @Override
    public void Dice(Gambler g) {
        while (true) {
            System.out.print("Введите ставку. У вас есть " + g.getMoney() + "$\n");
            bet = s.nextInt();
            while (bet>g.getMoney() || bet<0){
                System.out.println("У вас столько нет");
                System.out.print("Введите ставку. У вас есть " + g.getMoney() + "$");
                bet = s.nextInt();
            }
            int dice1 = r.nextInt(20) + 1;
            int dice2 = r.nextInt(20) + 1;
            if (dice1 > dice2) {
                g.setMoney(g.getMoney() + bet/2);
                System.out.print("You win\n");
            }
            if (dice2 > dice1) {
                g.setMoney(g.getMoney() - bet);
                System.out.print("You lose\n");
            }
            if (g.getMoney() <= 0) {
                System.out.print("Now you are BOMJ");
                System.exit(0);
            }
        }
    }

    @Override
    public void Slots(Gambler g) {

    }

    @Override
    public void Roulette(Gambler g) throws InterruptedException {
        int[]a={0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 26, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
        while(true){
        System.out.print("Введите ставку. У вас есть " + g.getMoney() + "$\n");
        bet = s.nextInt();
        while (bet>g.getMoney() || bet<0){
            System.out.println("У вас столько нет");
            System.out.print("Введите ставку. У вас есть " + g.getMoney() + "$\n");
            bet = s.nextInt();
        }
        int roul = r.nextInt(100) + 300;
        System.out.print("Введите поле\n");
        int pol=s.nextInt();
        int d=0;
        while (a[d]!=pol)
            d++;
        System.out.print("Ваше поле - ");
        if (d==0)
            System.out.println("\u001B[32m"+a[d]);
        else if (d%2==0)
            System.out.println("\u001B[31m"+a[d]);
        else
            System.out.println("\u001B[30m"+a[d]);
        while (a.length<=roul) {
            for (int i = 0; i < a.length; i++) {
                if (i == 0)
                    System.out.print("\u001B[32m" + a[i] + " ");
                else if (i % 2 == 0)
                    System.out.print("\u001B[31m" + a[i] + " ");
                else
                    System.out.print("\u001B[30m" + a[i] + " ");
                Thread.sleep(50);
            }
            roul -= a.length;
        }
        for (int i = 0; i <= roul; i++) {
            if (i == 0)
                System.out.print("\u001B[32m" + a[i] + " ");
            else if (i % 2 == 0)
                System.out.print("\u001B[31m" + a[i] + " ");
            else
                System.out.print("\u001B[30m" + a[i] + " ");
            Thread.sleep(200);
        }
        System.out.print("\n"+"\u001B[37m"+"Выпало ");
        if (roul == 0)
            System.out.println("\u001B[32m" + a[roul] + " ");
        else if (roul % 2 == 0)
            System.out.println("\u001B[31m" + a[roul] + " ");
        else
            System.out.println("\u001B[30m" + a[roul] + " ");
        System.out.print("\u001B[37m");
        if (d==0 && roul==0){
            System.out.println("Вы сорвали джекпот");
            g.setMoney(g.getMoney() + bet*10);
        }
        else if (d==roul){
            System.out.println("Вы сорвали джекпот");
            g.setMoney(g.getMoney() + bet*10/2);
        }
        else if (d!=0 && roul!=0) {
            if (d % 2 == roul % 2) {
                System.out.println("You win");
                g.setMoney(g.getMoney() + bet / 2);
            } else{
                System.out.println("You lose");
                g.setMoney(g.getMoney() - bet);
            }
        }
        else if (d!=0 || roul!=0) {
            System.out.println("You lose");
            g.setMoney(g.getMoney() - bet);
        }
        if (g.getMoney() <= 0) {
            System.out.print("Now you are BOMJ");
            System.exit(0);
        }
        }
    }
}
