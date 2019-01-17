package timaxa007.weapon_easy.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import timaxa007.weapon_easy.EntityBullet;
import timaxa007.weapon_easy.ProxyCommon;

public class ProxyClient extends ProxyCommon {

	@Override
	public void preInit(FMLPreInitializationEvent event) {

	}

	@Override
	public void init() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderEntityBullet());
	}

	@Override
	public void postInit() {

	}

}
