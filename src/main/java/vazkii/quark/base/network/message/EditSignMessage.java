package vazkii.quark.base.network.message;

import net.minecraft.core.BlockPos;
import net.minecraftforge.network.NetworkEvent;
import vazkii.arl.network.IMessage;
import vazkii.quark.content.tweaks.module.SignEditingModule;

public class EditSignMessage implements IMessage {

	private static final long serialVersionUID = -329145938273036832L;

	public BlockPos pos;
	
	public EditSignMessage() { }
	
	public EditSignMessage(BlockPos pos) {
		this.pos = pos;
	}
	
	@Override
	public boolean receive(NetworkEvent.Context context) {
		context.enqueueWork(() -> SignEditingModule.openSignGuiClient(pos));
		
		return true;
	}
	
}
