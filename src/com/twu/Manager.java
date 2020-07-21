package com.twu;

import java.util.List;

public class Manager extends Person {
    private String password;

    public Manager() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void insertSuperHotSearch(List<HotSearch> hotSearchList, String insertHotSearchName) {
        HotSearch newHotSearch = new HotSearch();
        newHotSearch.setNameHotSearch(insertHotSearchName);
        newHotSearch.setSuperHotSearch(true);
        hotSearchList.add(newHotSearch);
    }
}
