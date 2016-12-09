package morethanhidden.MTHCore.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class Message implements IMessage {

    public Message() {
    }

    public IMessage handleClient(final NetHandlerPlayClient netHandler) {
        return null;
    }

    public IMessage handleServer(final NetHandlerPlayServer netHandler) {
        return null;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }
}
