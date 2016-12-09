package morethanhidden.MTHCore.network;


import net.minecraft.entity.player.EntityPlayerMP;

public class Sync {

    static NetworkWrap networkWrapper;
    static Sync INSTANCE;

    public static void sendTo(Message packet, EntityPlayerMP player) {
        networkWrapper.network.sendTo(packet, player);
    }

}
