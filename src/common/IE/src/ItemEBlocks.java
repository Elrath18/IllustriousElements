package IE.src;

import java.util.List;

import net.minecraft.src.BlockCloth;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemEBlocks extends ItemBlock
{
    public ItemEBlocks(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setIconIndex(0);
    }
	@Override
    public String getItemNameIS(ItemStack itemstack)
    {
		int meta = itemstack.getItemDamage();
		switch(meta)
		{
		case 0: return "Block 1";
		case 1: return "Block 2";
		}
        return "Eric's Blocks";
    }
    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
        {
    par3List.add(new ItemStack(this, 1, 0));
    par3List.add(new ItemStack(this, 1, 1));
      }
}



