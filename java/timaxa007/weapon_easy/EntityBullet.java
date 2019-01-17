package timaxa007.weapon_easy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World; 

public class EntityBullet extends EntityThrowable {

    public EntityBullet(World world) {
        super(world);
    }

    public EntityBullet(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    @Override
    public void onImpact(MovingObjectPosition mop) {
        switch(mop.typeOfHit) {
        case ENTITY:
            if (mop.entityHit != null)
                mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6.0F);
            break;
        case BLOCK:
            if (worldObj.isRemote) {
                Minecraft.getMinecraft().effectRenderer.addEffect(new BulletHoleFX(worldObj,
                        mop.hitVec.xCoord,
                        mop.hitVec.yCoord,
                        mop.hitVec.zCoord,
                        mop.sideHit)
                        );
            }
            break;
        default:break;
        }
        this.setDead();
    }

}
