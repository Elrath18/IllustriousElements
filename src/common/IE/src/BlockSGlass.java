package IE.src;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockSGlass extends Block 
{	
	public static final String[] dyeColorNames = new String[] {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Silver", "Gray", "Pink", "Lime", "Yellow", "Light Blue", "Magenta", "Orange", "White"};
	 
	public BlockSGlass(int par1) 
	{
		super(par1, Material.glass);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setHardness(.5f);
		this.setResistance(.5f);
		this.setStepSound(soundGlassFootstep);
		this.setTextureFile("/Textures/StainGlass.png");
		this.setLightOpacity(2);
	}
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)

    public int getRenderBlockPass()
    {
        return 1;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
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
    
    @Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i = 0; i < dyeColorNames.length;i++)
		{
			par3List.add(new ItemStack(this.blockID, 1, i));
		}
	}
}


