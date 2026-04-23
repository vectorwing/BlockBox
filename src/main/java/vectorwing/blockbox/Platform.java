package vectorwing.blockbox;

//? fabric {
import vectorwing.blockbox.fabric.FabricPlatformImpl;
//?}
//? neoforge {
/*import vectorwing.blockbox.blockbox.neoforge.NeoforgePlatformImpl;
*///?}

public interface Platform {

    //? fabric {
    Platform INSTANCE = new FabricPlatformImpl();
    //?}
    //? neoforge {
    /*Platform INSTANCE = new NeoforgePlatformImpl();
    *///?}


    boolean isModLoaded(String modid);
    String loader();

}
