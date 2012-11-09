package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

class TMPObjectsInstantiation$5 extends Item
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$5(TMPObjectsInstantiation var1, int var2)
    {
        super(var2);
        this.this$0 = var1;
        this.d(1);
        this.setMaxDurability(2);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack a(ItemStack var1, World var2, EntityHuman var3)
    {
        if (var2.M())
        {
            var2.getWorldData().setWeatherDuration(0);
            var2.getWorldData().setStorm(false);
            var2.getWorldData().setThunderDuration(0);
            var2.getWorldData().setThundering(false);
        }
        else
        {
            var2.getWorldData().setStorm(true);
        }

        var3.bE();
        var1.damage(1, var3);
        return var1;
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
