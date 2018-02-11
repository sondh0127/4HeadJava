package com.fundamental.java;

import java.util.ArrayList;

public class DotCom {
    private String dotName;
    private ArrayList<String> locationCells = new ArrayList<String>();
    //    private int numOfHits = 0;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public String checkYourself(String userInput) {
//        int guess = Integer.parseInt(userInput);
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + dotName + " : ( ");
            } else {
                result = "hit";
            }
        }

//        System.out.println(result);
        return result;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }
}
