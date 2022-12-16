package com.example.mydailyworkout.service;

public class LoginService {
    /*
    private SalesRep currentSalesRep;
    private boolean isValidUserName = false;
    private boolean isValidPassword = false;
    @Autowired
    private InputService inputService;
    @Autowired
    private Validate validate;
    @Autowired
    private SalesRepRepository salesRepRepository;
    @Autowired
    private Prints prints;
    public String login(){
        prints.printLogin();
        String userName;
        String password;
        String currentUser;
        do {
            userName = inputService.askUserName();
            isValidUserName = validate.isValidUserName(userName);
            if (!isValidUserName){
                printWithColor("Username does not exist. Please try again", ConsoleColors.RED);
            }
        }while (!isValidUserName);
        do {
            password = inputService.askPassword();
            isValidPassword = validate.isValidPassword(userName, password);
            if (!isValidPassword){
                printWithColor("Password does not match with username. Please try again", ConsoleColors.RED);
            }
        }while (!isValidPassword);
        var loggedSalesRep = salesRepRepository.getSalesRepByName(userName);
        this.setCurrentSalesRep(loggedSalesRep);
        System.out.println("Login successful");
        return userName;
    }*/
}
