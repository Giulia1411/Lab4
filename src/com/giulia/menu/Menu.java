package com.giulia.menu;

// Father Invoker
abstract public class Menu {
    private Command command;

    public void set_command(Command c)
    {
        this.command = c;
    }

    public void execute() {
        command.execute();
    }
}
