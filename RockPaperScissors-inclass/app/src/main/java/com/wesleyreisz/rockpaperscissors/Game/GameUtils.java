package com.wesleyreisz.rockpaperscissors.Game;

import android.graphics.Color;
import com.wesleyreisz.rockpaperscissors.R;

import java.util.Objects;
import java.util.Random;

/**
 * Created by wesleyreisz on 9/13/15.
 */
public class GameUtils {
    public static final String BEATS = "beats";
    public static final String LOSES_TO = "loses to";
    public static final String TIES = "ties";

    public static Integer getComputerChoice(){
        /*
        TODO: Implement a random number generator that returns of of the three games options.
         */
        Random rand = new Random();

        int n = rand.nextInt(3) + 1;
        if(n==1){
            return R.id.btnPaper;
        }else if(n==2){
            return R.id.btnRock;
        }else{
            return R.id.btnScissors;
        }

    }
    public interface GameItem{
        String eval(int computerChoice);
    }
    static class Paper implements GameItem{

        @Override
        public String eval(int computerChoice) {
            {
                if (Objects.equals(computerChoice, R.id.btnPaper)) {
                    return TIES;
                } else if (Objects.equals(computerChoice, R.id.btnRock)) {
                    return BEATS;
                } else {
                    return LOSES_TO;
                }
            }
        }
    }
    static class Rock implements GameItem{

        @Override
        public String eval(int computerChoice) {
            {
                {
                    if (Objects.equals(computerChoice, R.id.btnPaper)) {
                        return LOSES_TO;
                    } else if (Objects.equals(computerChoice, R.id.btnRock)) {
                        return TIES;
                    } else {
                        return BEATS;
                    }
                }
            }
        }
    }
    static class Scissors implements GameItem{

        @Override
        public String eval(int computerChoice) {
            {
                {
                    if (Objects.equals(computerChoice, R.id.btnPaper)) {
                        return BEATS;
                    } else if (Objects.equals(computerChoice, R.id.btnRock)) {
                        return LOSES_TO;
                    } else {
                        return TIES;
                    }
                }
            }
        }
    }
    public static String evaluateWinner(Integer playerSelectedChoice, final Integer computerSelectedChoice) {
        /*
         TODO: Create an Interface that has a super type method named eval.
         TODO: Create classes that implement the interface.
         TODO: Based on playerChoice, create an instance of that object (IE Rock)
         TODO: Call the eval method on that object passing in the computer's choice.
         TODO: Implement the logic for each of the game types to determine the winner.
         */



        //logic goes here

        //Variable to hold the item the player selects
        GameItem PlayerItem;

        if (playerSelectedChoice == R.id.btnPaper) {
            PlayerItem = new Paper();
        }
        else if (playerSelectedChoice == R.id.btnRock) {
            PlayerItem = new Rock();
        }
        else{
            PlayerItem = new Scissors();
        }

        return PlayerItem.eval(computerSelectedChoice);
        }



    public static Integer convertButtonToImage(Integer buttonChoice) {
        if(buttonChoice==R.id.btnRock){
            return R.drawable.rock;
        }else if (buttonChoice==R.id.btnPaper){
            return R.drawable.paper;
        }else{
            return R.drawable.scissors;
        }
    }

    public static int defineTextColor(String msg) {
        if(GameUtils.LOSES_TO.equalsIgnoreCase(msg)){
            return Color.RED;
        }else if(GameUtils.BEATS.equalsIgnoreCase(msg)){
            return Color.GREEN;
        }else{
            return Color.BLACK;
        }
    }
}

