package IE.src;

import net.minecraft.src.BlockCloth;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

	public class ItemCSand extends ItemBlock
	{
	    public ItemCSand(int par1)
	    {
	        super(par1);
	        this.setMaxDamage(0);
	        this.setHasSubtypes(true);
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * Gets an icon index based on an item's damage value
	     */
	    public int getIconFromDamage(int par1)
	    {
	        return IllustriousElementsMain.blockCSand.getBlockTextureFromSideAndMetadata(2, BlockCloth.getBlockFromDye(par1));
	    }

	    /**
	     * Returns the metadata of the block which this Item (ItemBlock) can place
	     */
	    public int getMetadata(int par1)
	    {
	        return par1;
	    }

	    public String getItemNameIS(ItemStack par1ItemStack)
	    {
	        return    BlockCSand.dyeColorNames[BlockCSand.getBlockFromDye(par1ItemStack.getItemDamage())]+"Sand";
	    }
	    
	}


