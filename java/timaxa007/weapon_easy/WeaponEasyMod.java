package timaxa007.weapon_easy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = WeaponEasyMod.MODID, name = WeaponEasyMod.NAME, version = WeaponEasyMod.VERSION)
public class WeaponEasyMod {

	public static final String
	MODID = "weapon_easy",
	NAME = " Weapon Easy Mod",
	VERSION = "0.33";

	@Mod.Instance(MODID)
	public static WeaponEasyMod instance;

	@SidedProxy(modId = MODID,
			serverSide = "timaxa007.weapon_easy.ProxyCommon",
			clientSide = "timaxa007.weapon_easy.client.ProxyClient")
	public static ProxyCommon proxy;

	public static Item
	item_weapon_easy
	;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		item_weapon_easy = new ItemWeapon().setUnlocalizedName("weapon_easy").setCreativeTab(CreativeTabs.tabMisc).setHasSubtypes(true).setMaxDamage(0).setFull3D().setMaxStackSize(1);
		GameRegistry.registerItem(item_weapon_easy, "item_weapon_easy");

		EntityRegistry.registerModEntity(EntityBullet.class, WeaponEasyMod.MODID + ".entity_bullet", 0, WeaponEasyMod.instance, 120, 20, true);

		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

}
