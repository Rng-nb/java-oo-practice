package com.twu;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Manager manager;
    public static User user;
    public static HashMap<String, User> userHashMap = new HashMap<String, User>();

    public static void main(String[] args) {
        manager = new Manager();
        manager.setPersonName("admin");
        manager.setPassword("wyf1998");
        mainMenu();
    }

    public static void mainMenu() {
        String str_title = "欢迎来到热搜排行榜系统，请选择！";
        String str_manager = "1. 管理员";
        String str_user = "2. 普通用户";
        String str_exit = "3. 退出";

        Scanner sc_input = new Scanner(System.in);
        boolean flag_repeat = true;
        while(flag_repeat) {
            System.out.println(str_title + '\n' + str_manager + '\n' + str_user + '\n' + str_exit);
            int choose = sc_input.nextInt();
            switch (choose) {
                case 1 :
                    managerLogin();
                    break;
                case 2 :
                    userLogin();
                    break;
                case 3 :
                    flag_repeat = false;
                    break;
            }
        }
        sc_input.close();
    }

    public static void managerLogin() {
        Scanner sc_input = new Scanner(System.in);
        System.out.println("您好，请输入您的管理员用户名与密码" + '\n' + "用户名:");
        String input_manager_name = sc_input.next();
        while(!input_manager_name.equals(manager.getPersonName())) {
            System.out.println("用户名错误，请重新输入" + '\n' + "用户名:");
            input_manager_name = sc_input.next();
        }
        System.out.println("密码:");
        String input_manager_password = sc_input.next();
        while(!input_manager_password.equals(manager.getPassword())) {
            System.out.println("密码错误，请重新输入" + '\n' + "密码:");
            input_manager_password = sc_input.next();
        }
        sc_input.close();
    }

    public static void userLogin() {
        Scanner sc_input = new Scanner(System.in);
        System.out.println("您好，请输入您的用户名" + '\n' + "用户名:");
        String input_user_name = sc_input.next();
        if(userHashMap.containsKey(input_user_name))
            user = userHashMap.get(input_user_name);
        else {
            user = new User();
            userHashMap.put(input_user_name, user);
            user.setPersonName(input_user_name);
        }
    }
}
