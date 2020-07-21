package com.twu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Manager manager;
    public static User user;
    public static HashMap<String, User> userHashMap = new HashMap<String, User>();
    public static List<HotSearch> hotSearchList = new ArrayList<HotSearch>();

    public static void main(String[] args) {
        manager = new Manager();
        manager.setPersonName("admin");
        manager.setPassword("wyf1998");
        mainMenu();
    }

    //主菜单界面，进行角色身份选择
    public static void mainMenu() {
        Scanner sc_input = new Scanner(System.in);
        int choose;
        do {
            System.out.println("欢迎来到热搜排行榜系统，请选择！" + '\n' + "1. 管理员" + '\n' + "2. 普通用户" + '\n' + "3. 退出");
            choose = sc_input.nextInt();
            switch (choose) {
                case 1 :
                    managerLogin();
                    break;
                case 2 :
                    userLogin();
                    break;
                case 3 :
                    break;
            }
        }while (choose != 3);
    }

    //管理员登陆身份验证
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
        managerMenu();
    }

    //管理员菜单
    public static void managerMenu() {
        Scanner sc_manager = new Scanner(System.in);
        int manager_choose;
        do {
            System.out.println("您好" + manager.getPersonName() + ", 请选择！");
            System.out.println("1. 查看热搜排行榜" + '\n' + "2. 添加热搜" + '\n' + "3. 添加超级热搜" + '\n' + "4. 退出");
            manager_choose = sc_manager.nextInt();
            switch (manager_choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }while (manager_choose != 4);
    }
    //用户登陆身份验证
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
