package morethanhidden.MTHCore.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IRotatable {

    //Get Block facing
    EnumFacing getFacing(IBlockState state);
    //Set Block facing
    boolean setFacing(World worldIn, BlockPos pos, IBlockState state, EnumFacing facing);

    //True if only Horizontal Facing
    Boolean ishorizontal();

}
