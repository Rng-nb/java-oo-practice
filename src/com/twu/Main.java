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

        Scanner sc_input = new Scanner(System.in);
        while(true) {
            System.out.println(str_title + '\n' + str_manager + '\n' + str_user + '\n' + str_exit);
            int choose = sc_input.nextInt();
            switch (choose) {
                case 1 :
                    break;
                case 2 :
                    break;
                case 3 :
                    break;
            }
        }
    }
}
