package com.twu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SearchSystem {
    private final Manager manager;
    private User user;
    private final HashMap<String, User> userHashMap;
    private final List<HotSearch> hotSearchList;

    public SearchSystem() {
        userHashMap = new HashMap<String, User>();
        hotSearchList = new ArrayList<HotSearch>();
        manager = new Manager();
        manager.setPersonName("admin");
        manager.setPassword("admin123");
    }

    //主菜单界面，进行角色身份选择
    public void mainMenu() {
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
    public void managerLogin() {
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
    public void managerMenu() {
        Scanner sc_manager = new Scanner(System.in);
        int manager_choose;
        do {
            System.out.println("您好" + manager.getPersonName() + ", 请选择！");
            System.out.println("1. 查看热搜排行榜" + '\n' + "2. 添加热搜" + '\n' + "3. 添加超级热搜" + '\n' + "4. 退出");
            manager_choose = sc_manager.nextInt();
            switch (manager_choose) {
                case 1:
                    if(hotSearchList.size() <= 0) {
                        System.out.println("热搜榜为空");
                        break;
                    }
                    manager.getTHotSearch(hotSearchList);
                    break;
                case 2:
                    System.out.println("请输入添加的热搜名:");
                    String insertHotSearchName = sc_manager.next();
                    manager.insertHotSearch(hotSearchList, insertHotSearchName);
                    break;
                case 3:
                    System.out.println("请输入添加的超级热搜名:");
                    String insertSuperHotSearchName = sc_manager.next();
                    manager.insertSuperHotSearch(hotSearchList, insertSuperHotSearchName);
                    break;
                case 4:
                    break;
            }
        }while (manager_choose != 4);
    }
    //用户登陆身份验证
    public void userLogin() {
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
        userMenu();
    }
    //用户菜单
    public void userMenu() {
        Scanner sc_user = new Scanner(System.in);
        int user_choose;
        do {
            System.out.println("您好" + user.getPersonName() + ", 请选择！");
            System.out.println("1. 查看热搜排行榜" + '\n' + "2. 给热搜事件投票" + '\n'
                    + "3. 购买热搜" + '\n' + "4. 添加热搜" + '\n' + "5. 退出");
            user_choose = sc_user.nextInt();
            switch (user_choose) {
                case 1:
                    if(hotSearchList.size() <= 0) {
                        System.out.println("热搜榜为空");
                        break;
                    }
                    user.getTHotSearch(hotSearchList);
                    break;
                case 2:
                    if(hotSearchList.size() <= 0) {
                        System.out.println("热搜榜为空，无法投票!");
                        break;
                    }
                    System.out.println("请选择投票的热搜");
                    user.getTHotSearch(hotSearchList);
                    int ticket_choose = sc_user.nextInt();
                    HotSearch ticketHotSearch = hotSearchList.get(ticket_choose - 1);
                    System.out.println("您选择的热搜是: " + "\"" + ticketHotSearch.getNameHotSearch() + "\"");
                    System.out.println("请输入您要投的票数(共"+ user.getTicketNumber() +"票):");
                    int ticket_number_give = sc_user.nextInt();
                    if(ticket_number_give > user.getTicketNumber()) {
                        System.out.println("投票失败，票数不足");
                    }
                    else {
                        System.out.println("投票成功");
                        user.setTicketNumber(user.getTicketNumber() - ticket_number_give);
                        user.giveTicKetToHotSearch(ticketHotSearch, ticket_number_give);
                    }
                    break;
                case 3:
                    if(hotSearchList.size() <= 0) {
                        System.out.println("热搜榜为空，无法购买！");
                        break;
                    }
                    System.out.println("请选择购买的热搜");
                    user.getTHotSearch(hotSearchList);
                    int buy_choose = sc_user.nextInt();
                    HotSearch buyHotSearch = hotSearchList.get(buy_choose - 1);
                    System.out.println("您选择的热搜是: " + "\"" + buyHotSearch.getNameHotSearch()  + "\"");
                    System.out.println("请输入您购买的热搜排名: " );
                    int buy_aim_id = sc_user.nextInt();
                    System.out.println("请输入您购买的金额(当前"+ buyHotSearch.getPrivce() +"元):");
                    int buy_money_give = sc_user.nextInt();
                    if(buy_money_give < buyHotSearch.getPrivce()) {
                        System.out.println("购买失败！");
                    }
                    else {
                        System.out.println("购买成功");
                        buyHotSearch.setPrivce(buy_money_give);
                        buyHotSearch.setBuyHotSearch(true);
                        user.buyHotSearch(hotSearchList, buy_aim_id, buyHotSearch);
                    }
                    break;
                case 4:
                    System.out.println("请输入添加的热搜名:");
                    String insertHotSearchName = sc_user.next();
                    user.insertHotSearch(hotSearchList, insertHotSearchName);
                    break;
                case 5:
                    break;
            }
        }while (user_choose != 5);
    }
}
