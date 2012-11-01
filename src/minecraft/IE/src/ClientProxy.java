package IE.src;

	import net.minecraftforge.client.MinecraftForgeClient;
	import IE.src.CommonProxy;

public class ClientProxy extends CommonProxy
{
		public void preInit()
		//Preloaded textures
		{
			MinecraftForgeClient.preloadTexture("/Textures/IEBlocks.png");
		}
		
		public void init()
		{
		
		}
}
