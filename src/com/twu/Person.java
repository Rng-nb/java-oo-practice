package com.twu;

import java.util.Comparator;
import java.util.List;

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
        hotSearchList.sort(new Comparator<HotSearch>() {
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
        for (int i = 0; i < hotSearchList.size(); ++i) {
            HotSearch output_tmp = hotSearchList.get(i);
            System.out.println(i + "  " + output_tmp.getNameHotSearch() + "  " + output_tmp.getTicketHotSearch());
        }
    }

    public void insertHotSearch(List<HotSearch> hotSearchList, String hotSearchName) {
        HotSearch newHotSearch = new HotSearch();
        newHotSearch.setNameHotSearch(hotSearchName);
        hotSearchList.add(newHotSearch);
    }
}
