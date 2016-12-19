package morethanhidden.MTHCore.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkWrap {

    public final SimpleNetworkWrapper network;
    protected final PacketHandler handler;
    private int id = 0;

    public NetworkWrap(String channelName) {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
        handler = new PacketHandler();
    }

    public void registerPacketClient(Class<? extends Message> packetClazz) {
        registerPacket(packetClazz, Side.CLIENT);
    }

    private void registerPacket(Class<? extends Message> packetClazz, Side side) {
        network.registerMessage(handler, packetClazz, id++, side);
    }

    public static void sendToClients(WorldServer world, BlockPos pos, Message packet, NetworkWrap net) {
        Chunk chunk = world.getChunkFromBlockCoords(pos);
        for(EntityPlayer player : world.playerEntities) {
            // only send to relevant players
            if(!(player instanceof EntityPlayerMP)) {
                continue;
            }
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            if(world.getPlayerChunkMap().isPlayerWatchingChunk(playerMP, chunk.xPosition, chunk.zPosition)) {
                net.network.sendTo(packet, playerMP);
            }
        }
    }

}
