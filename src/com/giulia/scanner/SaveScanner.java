package com.giulia.scanner;

import java.util.Scanner;

public class SaveScanner {
    private Scanner in;

    public int scan_int()
    {
        int value;
        in = new Scanner(System.in);
        while(!in.hasNextInt())
        {
            in.next();
            System.out.print("Retry: ");
        }
        value = in.nextInt();
        //in.close();
        return value;
    }

    public String scan_line()
    {
        in = new Scanner(System.in);
        String line;
        line = in.nextLine();
        return line;
    }

    public double scan_double()
    {
        double value;
        in = new Scanner(System.in);
        while(!in.hasNextDouble())
        {
            in.next();
            System.out.print("Retry: ");
        }
        value = in.nextDouble();
        //in.close();
        return value;
    }
}
