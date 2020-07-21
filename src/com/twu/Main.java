package com.twu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        String str_title = "欢迎来到热搜排行榜系统，请选择！！！";
        String str_manager = "1. 管理员";
        String str_user = "2. 普通用户";
        String str_exit = "3. 退出";
        String str_manager_menu = "您好，请输入您的管理员用户名与密码";
        String str_output_name = "用户名:";
        String str_output_password = "密码:";

        Scanner sc_input = new Scanner(System.in);
        boolean flag_repeat = true;
        while(flag_repeat) {
            System.out.println(str_title + '\n' + str_manager + '\n' + str_user + '\n' + str_exit);
            int choose = sc_input.nextInt();
            switch (choose) {
                case 1 :
                    System.out.println(str_manager_menu + '\n' + str_output_name);
                    String input_manager_name = sc_input.next();
                    System.out.println(str_output_password);
                    String input_manager_password = sc_input.next();
                    break;
                case 2 :
                    break;
                case 3 :
                    flag_repeat = false;
                    break;
            }
        }
    }
}
