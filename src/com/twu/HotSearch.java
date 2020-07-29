package com.twu;

public class HotSearch {
    private String nameHotSearch;
    private int ticketHotSearch;
    private int privce;
    private boolean isSuperHotSearch;
    private boolean isBuyHotSearch;

    public HotSearch() {
        privce = 0;
        ticketHotSearch = 0;
        isSuperHotSearch = false;
        isBuyHotSearch = false;
    }

    public String getNameHotSearch() {
        return nameHotSearch;
    }

    public void setNameHotSearch(String nameHotSearch) {
        this.nameHotSearch = nameHotSearch;
    }

    public int getTicketHotSearch() {
        return ticketHotSearch;
    }

    public void setTicketHotSearch(int ticketHotSearch) {
        this.ticketHotSearch = ticketHotSearch;
    }

    public boolean isSuperHotSearch() {
        return isSuperHotSearch;
    }
    public boolean isBuyHotSearch() {
        return isBuyHotSearch;
    }
    public int getPrivce() {
        return  this.privce;
    }

    public void setPrivce(int privce) {
        this.privce = privce;
    }
    public void setSuperHotSearch(boolean isSuperHotSearch) {
        this.isSuperHotSearch = isSuperHotSearch;
    }
    public void setBuyHotSearch(boolean isBuyHotSearch) {
        this.isBuyHotSearch = isBuyHotSearch;
    }
}
