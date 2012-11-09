package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntitySmallFireball;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class ItemFireLauncher extends Item
{
    protected ItemFireLauncher(int var1)
    {
        super(var1);
        this.d(1);
        this.setMaxDurability(10);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack a(ItemStack var1, World var2, EntityHuman var3)
    {
        if (var3.inventory.e(Item.FIREBALL.id))
        {
            byte var4;

            if (var2.isStatic)
            {
                var4 = 0;
            }
            else
            {
                var4 = 1;
            }

            EntitySmallFireball var5 = new EntitySmallFireball(var2);
            var5.setLocation(var3.locX, var3.locY + (double)var4, var3.locZ, var3.yaw, var3.pitch);
            var5.shooter = var3;
            var2.addEntity(var5);
            var5.motX = var3.Z().c;
            var5.motY = var3.Z().d;
            var5.motZ = var3.Z().e;
            var5.dirX = var5.motX * 0.1D;
            var5.dirY = var5.motY * 0.1D;
            var5.dirZ = var5.motZ * 0.1D;
            var2.triggerEffect(1009, (int)var3.locX, (int)var3.locY, (int)var3.locZ, 0);
            var3.inventory.d(Item.FIREBALL.id);
            var1.damage(1, var3);
        }

        return var1;
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
