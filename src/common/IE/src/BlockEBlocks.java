package IE.src;

import java.util.List;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.List;
	import java.util.Random;

	import cpw.mods.fml.common.Side;
	import cpw.mods.fml.common.asm.SideOnly;
	import net.minecraft.src.Block;
	import net.minecraft.src.CreativeTabs;
	import net.minecraft.src.Item;
	import net.minecraft.src.ItemStack;
	import net.minecraft.src.Material;

public class BlockEBlocks extends Block 
	{	
		public BlockEBlocks(int par1) 
		{
			super (par1, Material.rock);
			this.setCreativeTab(CreativeTabs.tabDecorations);
			this.setHardness(2f);
			this.setResistance(2f);
			this.setTextureFile("/Textures/StainGlass.png");
			this.blockIndexInTexture = 32;
			this.setLightValue(1);
		}
		 
		    
		public int quantityDropped(Random par1Random)
	    {
	        return 1;
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	     */
	    public int getRenderBlockPass()
	    {
	        return 1;
	    }

	    /**
	     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	     */
	    public boolean renderAsNormalBlock()
	    {
	        return true;
	    }

	    /**
	     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
	     */
	    protected boolean canSilkHarvest()
	    {
	        return true;
	    }
	    /**
	    public int getRenderColor(int par1)
	    {
	        return ItemDye.dyeColors[par1];
	    }
	    */
	    public int getBlockTextureFromSideAndMetadata(int side, int meta)
	    {
	        
	            return this.blockIndexInTexture+meta;
	    }

	    /**
	     * Determines the damage on the item the block drops. Used in cloth and wood.
	     */
	    public int damageDropped(int par1)
	    {
	        return par1;
	    }
	    
	    //@Override
		//public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
		{
			//for(int n = 0; n < BlockNames.length;n++)
			{
				//par3List.add(new ItemStack(par1, 1, n));
			}
		}
	}




