package com.giulia.menu.all_airlines;

import com.giulia.menu.Menu;

public class AllAirlinesMenu extends Menu {

    public int command_list()
    {
        System.out.println("-----Airlines menu-----");
        System.out.println("1.About" +
                "\n2.Show list of airlines " +
                "\n3.Create airline" +
                "\n4.Delete airline" +
                "\n5.Select airline and actions" +
                "\n6.Load database"+
                "\n0.Exit program.");
        return 7;
    }

}
