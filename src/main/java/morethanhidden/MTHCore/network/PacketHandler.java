package morethanhidden.MTHCore.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler implements IMessageHandler<Message, IMessage> {

    @Override
    public IMessage onMessage(Message message, MessageContext ctx) {
        if (ctx.side == Side.CLIENT){
            return message.handleClient(ctx.getClientHandler());
        }
        return message.handleServer(ctx.getServerHandler());
    }

}
