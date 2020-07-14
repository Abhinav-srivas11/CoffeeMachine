package com.abhinav;
import java.util.*;
public class CoffeeMachine {
    enum CoffeeType {
        ESPRESSO(1),
        LATTE(2),
        CAPPUCCINO(3);
        private int coffeeType;

        public int getCoffeeType(){
            return coffeeType;
        }

        private  CoffeeType(int inputFromUser){
            this.coffeeType = inputFromUser;
        }
    }

    static final int waterEspresso = 250;
    static final int milkEspresso = 50;
    static final int beansEspresso = 16;
    static final int espressoPrice = 4;
    static final int waterLatte = 350;
    static final int milkLatte = 75;
    static final int beansLatte = 20;
    static final int lattePrice = 7;
    static final int waterCapp = 200;
    static final int milkCapp = 100;
    static final int beansCapp = 12;
    static final int cappPrice = 6;
    static int waterPresent = 400; static int milkPresent = 540;static int beansPresent = 120;
    static int cupsAvailable = 9; static int moneyPresent = 550;
    public static Scanner s;

    public static void main(String[] args) {
        boolean exitFlag = false;
        s = new Scanner(System.in);
        while(!exitFlag){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = s.nextLine();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
                    String m = s.nextLine();
                    if(m.equals("back")){
                        break;
                    }
                    else {
                        int coffeeType = Integer.parseInt(m);

                        if(checkIngredients()){
                            System.out.println("I have enough resources, making you a coffee!");
                            if(coffeeType == 1){
                                espresso();
                            } else if(coffeeType == 2){
                                latte();
                            } else {
                                cappuccino();
                            }
                            break;
                        }
                    }
                    break;

                case "fill":
                    fill();
                    break;

                case "take":
                    take();
                    break;

                case "remaining":
                    currentStatus();
                    break;

                case "exit":
                    exitFlag = true;
                    break;
            }
        }
    }
    // define function to check if all ingredients are available to make
    private static boolean checkIngredients(){

        if(waterPresent<waterEspresso || waterPresent<waterCapp || waterPresent<waterLatte){
            System.out.println("Sorry, not enough water!"); return false;
        }
        if(milkPresent<milkEspresso || milkPresent<milkCapp || milkPresent<milkLatte) {
            System.out.println("Sorry, not enough milk!"); return false;
        }
        if(cupsAvailable < 1){
            System.out.println("Sorry, not enough cups");return false;
        }
        if( beansPresent<beansEspresso || beansPresent<beansCapp || beansPresent < beansLatte){
            System.out.println("Sorry, not enough beans");return false;
        }
        return true;
    }
    //defining functions for buying,filling and take
    private static void espresso(){

        waterPresent-=waterEspresso;
        beansPresent-=beansEspresso;
        cupsAvailable--;
        moneyPresent+=espressoPrice;
        System.out.println("I have enough resources, making you a coffee!");

    }

    private static void latte(){
        waterPresent-=waterLatte;
        milkPresent-=milkLatte;
        beansPresent-=beansLatte;
        cupsAvailable--;
        moneyPresent+=lattePrice;

        // currentStatus();

    }

    private static void cappuccino(){
        waterPresent-=waterCapp;
        milkPresent-=milkCapp;
        beansPresent-=beansCapp;
        cupsAvailable--;
        moneyPresent+=cappPrice;
        // currentStatus();
    }

    private static void fill(){
        System.out.println("Write how many ml of water do you want to add:");
        waterPresent += s.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkPresent += s.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beansPresent += s.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cupsAvailable += s.nextInt();
    }

    private static void take(){
        System.out.println("I gave you $"+ moneyPresent);
        moneyPresent = 0;
    }

    private static void currentStatus(){
        System.out.println("The coffee machine has:");
        System.out.println(waterPresent+" of water");
        System.out.println(milkPresent+" of milk");
        System.out.println(beansPresent+" of coffee beans");
        System.out.println(cupsAvailable+" of disposable cups");
        System.out.println(moneyPresent+" of money");
    }
}
