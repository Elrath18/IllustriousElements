package IE.src;

import java.io.File;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="IllustriousElements ",name="IllustriousElements ",version="[1.4.2].A")
@NetworkMod(channels = { "IllustriousElements " }, clientSideRequired = true, serverSideRequired = false)

public class IllustriousElementsMain
{
	public static IllustriousElementsMain Instance;
	
	@SidedProxy(clientSide = "IE.ClientProxy",serverSide = "IE.CommonProxy")
	public static CommonProxy proxy;
	
	static Configuration config = new Configuration(new File(cpw.mods.fml.common.Loader.instance().getConfigDir(),"GreaterProtection/configMain.cfg"));
	private static String mystring = ConfigurationProperties();
	
	public static String ConfigurationProperties()
	{
		config.load();
		//Configuration Info.
		config.save();
		return mystring;
	}	
}


