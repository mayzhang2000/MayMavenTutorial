package LockerRoom;

/**
 * Created by mayz985 on 1/4/17.
 */
public interface LockerRoomManagementInterface {



    //Adds a locker at a given x, y position, returns false if the position is not empty
    public boolean addLocker(int x, int y, String owner);



    //Removes the locker at a given x, y position and returns the locker, null if no locker was present
    public Locker removeLocker(int x, int y);


    //Given an x, y position, returns the name of the owner of the locker
    public String getLockerOwner(int x, int y);



    //Given the name of the locker's owner, return the x, y position of the locker
    public int getLockerLocationX(String owner);
    public int getLockerLocationY(String owner);
}
