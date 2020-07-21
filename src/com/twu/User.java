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

    public void buyHotSearch() {

    }
}
