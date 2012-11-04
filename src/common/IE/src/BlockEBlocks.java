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
import net.minecraft.src.IBlockAccess;
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
			this.setStepSound(soundStoneFootstep);
			this.setTextureFile("/Textures/StainGlass.png");
			this.blockIndexInTexture = 32;
		    this.setLightValue(1);
		}
			  
		public int quantityDropped(Random par1Random)
	    {
	        return 1;
	    }
	   
	    public boolean renderAsNormalBlock()
	    {
	        return true;
	    }
	    
	    protected boolean canSilkHarvest()
	    {
	        return true;
	    }
	   
	    public int getBlockTextureFromSideAndMetadata(int side, int meta)
	    {
	        
	            return this.blockIndexInTexture+meta;
	    }
	    
	    public int damageDropped(int par1)
	    {
	        return par1;
	    }
	}




