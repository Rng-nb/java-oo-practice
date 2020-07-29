package com.twu;

import java.util.*;

public class Person {
    private String personName;

    public Person() {

    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void getTHotSearch(List<HotSearch> hotSearchList) {
        List<HotSearch> hotSearchListWithoutBuyHotSearch = new ArrayList<HotSearch>();
        List<Pair> hotSerarchListBuyHotSearch = new ArrayList<Pair>();
        for(int i = 0; i < hotSearchList.size(); ++ i) {
            if(hotSearchList.get(i).isBuyHotSearch() == false)
                hotSearchListWithoutBuyHotSearch.add(hotSearchList.get(i));
            else {
                Pair buyHotSearch = new Pair(i, hotSearchList.get(i));
                hotSerarchListBuyHotSearch.add(buyHotSearch);
            }
        }

        hotSearchListWithoutBuyHotSearch.sort(new Comparator<HotSearch>() {
            @Override
            public int compare(HotSearch o1, HotSearch o2) {
                if(o1.getTicketHotSearch() > o2.getTicketHotSearch())
                    return -1;
                else if(o1.getTicketHotSearch() == o2.getTicketHotSearch())
                    return 0;
                else
                    return 1;
            }
        });

        hotSearchList.clear();
        for(int i = 0; i < hotSearchListWithoutBuyHotSearch.size(); ++i)
            hotSearchList.add(hotSearchListWithoutBuyHotSearch.get(i));

        for(int i = 0; i < hotSerarchListBuyHotSearch.size(); ++i) {
            int id = hotSerarchListBuyHotSearch.get(i).getId();
            HotSearch hotSearch = hotSerarchListBuyHotSearch.get(i).getHotSearch();
            hotSearchList.add(id, hotSearch);
        }

        for (int i = 0; i < hotSearchList.size(); ++i) {
            HotSearch output_tmp = hotSearchList.get(i);
            System.out.println(i + 1 + "  " + output_tmp.getNameHotSearch() + "  " + output_tmp.getTicketHotSearch());
        }
    }

    public void insertHotSearch(List<HotSearch> hotSearchList, String hotSearchName) {
        HotSearch newHotSearch = new HotSearch();
        newHotSearch.setNameHotSearch(hotSearchName);
        hotSearchList.add(newHotSearch);
    }
}
