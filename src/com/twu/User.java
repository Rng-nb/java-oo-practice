package com.twu;

import java.util.List;
import java.util.Scanner;

public class User extends Person {
    private int ticketNumber;

    public User() {
        setTicketNumber(10);
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void giveTicKetToHotSearch(HotSearch ticketHotSearch, int ticketNumberGive) {
        //更新热度
        int nowTicketNumber = ticketHotSearch.getTicketHotSearch();
        if(ticketHotSearch.isSuperHotSearch()) {
            ticketNumberGive = 2 * ticketNumberGive;
        }
        ticketHotSearch.setTicketHotSearch(nowTicketNumber + ticketNumberGive);
    }

    public void buyHotSearch(List<HotSearch> hotSearchlist, int buyHotSerchIdAim, HotSearch buyHotSearch) {
        //判断购买的名次是否是当前所处的位置，不需要进行删除
        int buyHotSearchIdNow = hotSearchlist.indexOf(buyHotSearch);
        if(buyHotSearchIdNow != buyHotSerchIdAim -1) {
            //购买名称与当前名次不一致，删除购买名称处的热搜
            hotSearchlist.remove(buyHotSerchIdAim - 1);
            hotSearchlist.add(buyHotSerchIdAim - 1, buyHotSearch);
            hotSearchlist.remove(buyHotSearchIdNow);
        }
    }
}
