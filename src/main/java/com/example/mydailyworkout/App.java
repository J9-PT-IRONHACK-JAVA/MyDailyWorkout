package com.example.mydailyworkout;

import com.example.mydailyworkout.service.InputService;
import com.example.mydailyworkout.utils.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component

public class App {

    @Autowired
    private ConsoleColors consoleColors;
    @Autowired
    private InputService inputService;

    public void  mainMenu(){

        String logedUser;
        Scanner sc = new Scanner(System.in);
        String input;

        //logedUser = loginService.login();
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Welcome to your fitnessApp");

        do {
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + " 1 -> Create custom workout\n 2 -> Find Exercise\n 3" +
                               " -> Show my exercices \n 4 -> Exit" + ConsoleColors.RESET );
            input = sc.nextLine();
            if(input.equals("4")){
                System.out.println("Yo esco chao chao...");
                System.exit(0);
            }
            inputService.main(sc, input);

        } while (true);
    }

}
