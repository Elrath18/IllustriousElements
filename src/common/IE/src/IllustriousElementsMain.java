package IE.src;

import java.io.File;
import java.util.Arrays;


import net.minecraft.src.Block;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="IllustriousElements ",name="IllustriousElements ",version="[1.4.2].A")
@NetworkMod(channels = { "IllustriousElements " }, clientSideRequired = true, serverSideRequired = false)

public class IllustriousElementsMain
{
	public static IllustriousElementsMain Instance;
	
	@SidedProxy(clientSide = "IE.src.ClientProxy",serverSide = "IE.src.CommonProxy")
	public static CommonProxy proxy;
	
	static Configuration config = new Configuration(new File(cpw.mods.fml.common.Loader.instance().getConfigDir(),"IllustriousElements/configMain.cfg"));
	private static String mystring = ConfigurationProperties();
		public static int SGID; 
		public static int CSID;
		public static int RSID; 
		public static int EBID;
		public static int GGID;
		public static int GRSID;
		
		// Blocks // Configs //
		public static final Block blockSGlass = (new IE.src.BlockSGlass(SGID)).setBlockName("Stained Glass");
		public static final Block blockCSand = (new IE.src.BlockCSand(CSID)).setBlockName("Colored Glass");
		public static final Block blockEBlocks = (new IE.src.BlockEBlocks(EBID)).setBlockName("Eric's Blocks");
		public static final Block blockGGlass = (new IE.src.BlockGGlass(GGID)).setBlockName("Glowing Glass");
	
		// Item // Configs //
		public static final Item itemRSand = (new IE.src.ItemRSand(RSID)).setItemName("Refined Sand");
		public static final Item itemGRSand = (new IE.src.ItemGRSand(GRSID)).setItemName("Glowing Refined Sand");
		
		public static String ConfigurationProperties()
	{
		config.load();
		SGID = Integer.parseInt(config.getBlock(Configuration.CATEGORY_BLOCK,"StainedGlassBlockID", 1200).value);
		CSID = Integer.parseInt(config.getBlock(Configuration.CATEGORY_BLOCK,"ColoredGlassBlockID", 1201).value);
		RSID = Integer.parseInt(config.getItem(Configuration.CATEGORY_ITEM,"RefinedSandItemID", 30010).value);
		EBID = Integer.parseInt(config.getBlock(Configuration.CATEGORY_BLOCK,"Eric'sBlocksBlockID", 1202).value);
		GGID = Integer.parseInt(config.getBlock(Configuration.CATEGORY_BLOCK,"GlowingGlassBlockID", 1203).value);
		GRSID = Integer.parseInt(config.getItem(Configuration.CATEGORY_ITEM,"GlowingRefinedSandItemID", 30020).value);
		config.save();
		return mystring;
	}	
	
		@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit();
		//// Registration ////
		GameRegistry.registerBlock(blockSGlass,ItemSGlass.class);
		GameRegistry.registerBlock(blockCSand,ItemCSand.class);
		GameRegistry.registerBlock(blockEBlocks,ItemEBlocks.class);
		GameRegistry.registerBlock(blockGGlass,ItemGGlass.class);
	}
	
		@Init	
	public void generalLoad(FMLInitializationEvent event)
	{
		proxy.init();
		//// Block Names ////
		for(int i = 0; i < BlockSGlass.dyeColorNames.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(blockSGlass, 1,i),BlockSGlass.dyeColorNames[i]+ " Stained Glass");
		}
		for(int k = 0; k < BlockCSand.dyeColorNames.length; k++)
		{
			LanguageRegistry.addName(new ItemStack(blockCSand, 1,k),BlockCSand.dyeColorNames[k]+ " Sand");
		}
		for(int z = 0; z < BlockGGlass.dyeColorNames.length; z++)
		{
			LanguageRegistry.addName(new ItemStack(blockGGlass, 1,z),BlockGGlass.dyeColorNames[z]+ " Glowing Glass");
		}
		for(int i = 0; i < ItemRSand.dyeColorNames.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(itemRSand, 1,i),ItemRSand.dyeColorNames[i]+ " Refined Sand");
		}
		for(int i = 0; i < ItemGRSand.dyeColorNames.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(itemGRSand, 1,i),ItemRSand.dyeColorNames[i]+ " Glowing Refined Sand");
		}
		LanguageRegistry.addName(new ItemStack(blockEBlocks, 1,0), "Block 1");
		LanguageRegistry.addName(new ItemStack(blockEBlocks, 1,1), "Block 2");
		

	}
		@PostInit	
		public void postLoad(FMLPostInitializationEvent event)
	{
		proxy.postInit();
		//// Block Recipes ////
		
			// Stained Glass //
			for(int i = 0; i < BlockSGlass.dyeColorNames.length; i++)
			{
				FurnaceRecipes.smelting().addSmelting(this.itemRSand.shiftedIndex,i, new ItemStack(this.blockSGlass,1,i)); 
			}
			
			// Glowing Glass //
			for(int i = 0; i < BlockGGlass.dyeColorNames.length; i++)
			{
				FurnaceRecipes.smelting().addSmelting(this.itemGRSand.shiftedIndex,i, new ItemStack(this.blockGGlass,1,i)); 
			}
			
			// Refined Sand //
			for(int j = 0; j < ItemRSand.dyeColorNames.length; j++)
			{
			GameRegistry.addShapelessRecipe(new ItemStack(itemRSand, 1,j), new Object []{new ItemStack(blockCSand,1,j)});
			}
			
			
			// Colored Sand //
			for(int j = 0; j < BlockCSand.dyeColorNames.length; j++)
			{
			GameRegistry.addRecipe(new ItemStack(blockCSand, 8,j), new Object []
					{"SSS","SDS","SSS", 'S', Block.sand , 'D', new ItemStack(Item.dyePowder,1,j)});
			}
			
	}
}

