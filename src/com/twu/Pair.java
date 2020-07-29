package com.twu;

public class Pair {
    private int id;
    private HotSearch hotSearch;

    public Pair(int id, HotSearch hotSearch) {
        this.id = id;
        this.hotSearch = hotSearch;
    }

    public int getId() {
        return id;
    }

    public HotSearch getHotSearch() {
        return hotSearch;
    }
}
