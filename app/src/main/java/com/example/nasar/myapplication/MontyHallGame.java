package com.example.nasar.myapplication;

import java.util.Random;

/**
 * Created by nasar on 5/10/15.
 */
public class MontyHallGame implements MontyHall{
    private  int prizeDoor;
    private int userDoor;
    private int dummyDoor;
    private Random rand;
    private final int numDoors = 3;
    private int switchWin,switchLosses;
    private int stayWin, stayLosses;
    private boolean switched,stayed;


    MontyHallGame(){

        userDoor = -1;
        switchWin=0;
        switchLosses =0;
        stayLosses = 0;
        stayWin = 0;
        switched = false;
        stayed = false;
        }

    @Override
    public void switchDoor() {
        switched = true;
        stayed = false;
        if(userDoor ==1 && dummyDoor == 2)
            userDoor = 3;
        else if (userDoor ==1 && dummyDoor == 3)
            userDoor = 2;
        else if (userDoor ==2 && dummyDoor == 3)
            userDoor = 1;
        else if (userDoor ==2 && dummyDoor == 1)
            userDoor = 3;
        else if (userDoor ==3 && dummyDoor == 2)
            userDoor = 1;
        else
            userDoor = 2;

    }

    @Override
    public void stay() {
        stayed = true;
        switched = false;
    }

    @Override
    public void setUserDoor(int door) {
        userDoor = door;
        rand = new Random();
        prizeDoor = rand.nextInt(numDoors)+1;
        if(userDoor != 1 && prizeDoor != 1)
            dummyDoor = 1;

        else if(userDoor != 2 && prizeDoor != 2)
            dummyDoor= 2;
        else
            dummyDoor = 3;

    }

    @Override
    public int getUserDoor() { return userDoor;}

    @Override
    public int getPrizeDoor() {
        return prizeDoor;
    }

    public boolean userWon(){
         if(userDoor == prizeDoor){
             if(switched){
                 switchWin++;

             }
             else
               stayWin++;
            return true;
         }

        if(switched){
          switchLosses++;
        }
        else
            stayLosses++;
        return false;
    }

    public int getSwitchWin() {
        return switchWin;
    }

    public int getSwitchLosses() {
        return switchLosses;
    }

    public int getStayWin() {
        return stayWin;
    }

    public int getStayLosses() {
        return stayLosses;
    }
    //    public ArrayList<Integer> stats(){
//        // percent of wins when switched door
//
//        // percent of wins when stayed (not switched)
//
//    }

    public int revealDummyDoor(){ return dummyDoor;}
}
