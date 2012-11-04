package IE.src;

	import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import IE.src.CommonProxy;

public class ClientProxy extends CommonProxy
{
		public void preInit()
		// Preloaded Textures //
		{
			MinecraftForgeClient.preloadTexture("/Textures/StainGlass.png");
			MinecraftForgeClient.preloadTexture("/Textures/Item.png");
		}
		
		public void init()
		{
		
		}
}
