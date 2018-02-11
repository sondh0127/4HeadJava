package com.fundamental.java;

import java.util.ArrayList;

public class DotComBust {

    private GamerHelper helper = new GamerHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        // first make some dotcoms and give them locations
        DotCom one = new DotCom();
        one.setDotName("Pets.com");
        DotCom two = new DotCom();
        two.setDotName("Go2.com");
        DotCom three = new DotCom();
        three.setDotName("eToys.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, Go2.com, eToys.com");
        System.out.println("Try to sink them all in fewest number of guesses");


        for (DotCom dotComToSet: dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }

    }

    public void startPlaying() {
        System.out.println("startPlaying");
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a number:");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (DotCom dotComToTest: dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("hit")) {
                break;
            }
            if (result.equals("kill")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }

        System.out.println(result);

    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. "+ numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

}
