package IE.src;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemGRSand extends Item 
{
	public static final String[] dyeColorNames = new String[] {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Silver", "Gray", "Pink", "Lime", "Yellow", "Light Blue", "Magenta", "Orange", "White"};
	    
	protected ItemGRSand(int par1) 
	{
		super(par1);
		this.setIconIndex(16);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureFile("/Textures/Item.png");
	}
	    public int getIconFromDamage(int par1)
	    {
	        return this.iconIndex+par1;
	    }
	 	 
	    public int getMetadata(int par1)
	    {
	        return par1;
	    }

	    public final String getItemNameIS(ItemStack par1ItemStack)
	    {
	        return  ItemGRSand.dyeColorNames[ItemRSand.getBlockFromDye(par1ItemStack.getItemDamage())]+"  Glowing Refined Sand";    
	    }
	    
	    public static int getBlockFromDye(int par0)
	    {
	        return ~par0 & 15;
	    }
	    
	    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
		{
			for(int i = 0; i < dyeColorNames.length;i++)
			{
				par3List.add(new ItemStack(par1, 1, i));
			}
		}
}


