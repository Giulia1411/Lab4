package com.giulia.controller;

import java.util.Scanner;

public class Controller {

    protected int user_choose(int amount_commands)
    {
        System.out.print("Your choose: ");
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt())
        {
            System.out.print("Error. Try again: ");
        }
        int choose = in.nextInt();
        while(choose > amount_commands && choose < 0)
        {
            System.out.print("Unknown command. Try again: ");
            while(!in.hasNextInt())
            {
                System.out.print("Error. Try again: ");
            }
            choose = in.nextInt();
        }
        return choose;
    }
}
