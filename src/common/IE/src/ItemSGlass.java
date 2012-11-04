package IE.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockCloth;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemSGlass extends ItemBlock
{
    public ItemSGlass(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)

    public int getIconFromDamage(int par1)
    {
        return IllustriousElementsMain.blockSGlass.getBlockTextureFromSideAndMetadata(2, BlockCloth.getBlockFromDye(par1));
    }
    
    public int getMetadata(int par1)
    {
        return par1;
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        return    BlockSGlass.dyeColorNames[par1ItemStack.getItemDamage()] +" Stained Glass";
    }
}
