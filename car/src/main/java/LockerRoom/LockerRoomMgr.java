package LockerRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayz985 on 1/4/17.
 */
public class LockerRoomMgr implements LockerRoomManagementInterface{
    //Adds a locker at a given x, y position, returns false if the position is not empty
    List<Locker> allLockers = new ArrayList<>();
    public boolean addLocker(int x, int y, String owner){
        //go through the list of lockers to find if x y has a locker already.
        boolean exist = false;
        for (Locker locker: allLockers) {
            if (locker.x == x && locker.y == y) exist = true;
        }

        if (exist) return false;
        allLockers.add(new Locker(x, y, owner));
        return true;
    }



    //Removes the locker at a given x, y position and returns the locker, null if no locker was present
    public Locker removeLocker(int x, int y){
        for (Locker locker: allLockers) {
            if (locker.x == x && locker.y == y) {
                allLockers.remove(locker);
                return locker;
            }
        }
        return null;
    }


    //Given an x, y position, returns the name of the owner of the locker
    public String getLockerOwner(int x, int y){
        for (Locker locker: allLockers) {
            if (locker.x == x && locker.y == y) {

                return locker.name;
            }
        }
        return null;
    }



    //Given the name of the locker's owner, return the x, y position of the locker
    public int getLockerLocationX(String owner){
        for (Locker locker: allLockers) {
            if (locker.name.equalsIgnoreCase(owner)) {

                return locker.x;
            }
        }
        return -1;

    }
    public int getLockerLocationY(String owner){
        for (Locker locker: allLockers) {
            if (locker.name.equalsIgnoreCase(owner)) {

                return locker.y;
            }
        }
        return -1;
    }
}
