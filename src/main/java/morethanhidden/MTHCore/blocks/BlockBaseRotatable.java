package morethanhidden.MTHCore.blocks;

import morethanhidden.MTHCore.api.IRotatable;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBaseRotatable extends BlockBase implements IRotatable{

	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	public BlockBaseRotatable(String modid, String unlocalisedname) {
		super(modid, unlocalisedname);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		setFacing(worldIn, pos, state, ishorizontal() ? placer.getHorizontalFacing().getOpposite() : EnumFacing.getDirectionFromEntityLiving(pos, placer));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
	}

	@Override
	public EnumFacing getFacing(IBlockState state) {
		return state.getValue(FACING);
	}

	@Override
	public boolean setFacing(World worldIn, BlockPos pos, IBlockState state, EnumFacing facing) {
		return worldIn.setBlockState(pos, state.withProperty(FACING, facing), 2);
	}

	@Override
	public Boolean ishorizontal() {
		return true;
	}
}
