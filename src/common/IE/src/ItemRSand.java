package IE.src;

import java.util.List;

import net.minecraft.src.BlockCloth;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemRSand extends Item 
{
	 public static final String[] dyeColorNames = new String[] {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Silver", "Gray", "Pink", "Lime", "Yellow", "Light Blue", "Magenta", "Orange", "White"};
	    public static final int[] dyeColors = new int[] {1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};
	
	    protected ItemRSand(int par1) 
	{
		super(par1);
		this.setIconIndex(0);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureFile("/Textures/StainGlass.png");
	}
	 public int getIconFromDamage(int par1)
	    {
	        return this.iconIndex;
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
	        return  ItemRSand.dyeColorNames[ItemRSand.getBlockFromDye(par1ItemStack.getItemDamage())]+" Refined Sand";    
	    }
	    public static int getBlockFromDye(int par1)
	    {
	        return ~par1 & 15;
	    }
	    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
		{
			for(int i = 0; i < dyeColorNames.length;i++)
			{
				par3List.add(new ItemStack(par1, 1, i));
			}
		}
}

