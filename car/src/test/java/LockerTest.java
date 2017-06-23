import LockerRoom.LockerRoomManagementInterface;
import LockerRoom.LockerRoomMgr;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mayz985 on 1/4/17.
 */
public class LockerTest {
    @Test
    public void testLocker() {
        LockerRoomManagementInterface mgr = new LockerRoomMgr();

        //Add a locker and verify there is a locker.
        mgr.addLocker(0, 0, "first");

        Assert.assertEquals(mgr.getLockerOwner(0, 0), "first");
        Assert.assertEquals(mgr.getLockerLocationX("first"), 0);
        Assert.assertEquals(mgr.getLockerLocationY("first"), 0);

        //Delete a locker and verify it is deleted.
        mgr.removeLocker(0,0);
        Assert.assertEquals(mgr.getLockerOwner(0,0), null);
        Assert.assertEquals(mgr.getLockerLocationX("first"), -1);
        Assert.assertEquals(mgr.getLockerLocationY("first"), -1);


    }

}
