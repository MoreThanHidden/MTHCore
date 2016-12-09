package morethanhidden.MTHCore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block{

	public BlockBase(String modid, String unlocalisedname) {
		super(Material.ROCK);
		setUnlocalizedName(unlocalisedname);
		setRegistryName(new ResourceLocation(modid, getUnlocalizedName().substring(5)));
		setHardness(3);
	}


	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return  BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

}


