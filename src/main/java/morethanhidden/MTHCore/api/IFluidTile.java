package morethanhidden.MTHCore.api;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IFluidTile {

    @SideOnly(Side.CLIENT)
    public void updateFluid(FluidStack fluid);
}
