package IE.src;

import java.io.File;

import IE.BlockSGlass;

import net.minecraft.src.Block;
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
	
	static Configuration config = new Configuration(new File(cpw.mods.fml.common.Loader.instance().getConfigDir(),"GreaterProtection/configMain.cfg"));
	private static String mystring = ConfigurationProperties();
		public static int GID = 1200;
		
		// Blocks // Configs //
		public static final Block BlockSGlass = (new IE.BlockSGlass(GID)).setBlockName("Stained Glass");
	
		public static String ConfigurationProperties()
	{
		config.load();
		config.save();
		return mystring;
	}	
	
		@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit();
		//// Registration ////
		GameRegistry.registerBlock(BlockSGlass);
	}
	
		@Init	
	public void generalLoad(FMLInitializationEvent event)
	{
		proxy.init();
		//// Block Names ////
		LanguageRegistry.addName(new ItemStack(BlockSGlass, 1,0), "Blue Stained Glass");
	}
		@PostInit	
		public void postLoad(FMLPostInitializationEvent event)
	{
		proxy.postInit();
		//// Block Recipes ////
		
			// Blocks //
			GameRegistry.addSmelting(Block.glass.blockID,new ItemStack(BlockSGlass,1,0),0f); 
				 
	}
}

