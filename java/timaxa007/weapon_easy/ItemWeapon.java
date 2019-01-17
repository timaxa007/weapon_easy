package timaxa007.weapon_easy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWeapon extends Item {

    @Override
    public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
        if (!world.isRemote) {
            EntityBullet entity = new EntityBullet(world, player);
            world.spawnEntityInWorld(entity);
        }
        return super.onItemRightClick(is, world, player);
    }

}
