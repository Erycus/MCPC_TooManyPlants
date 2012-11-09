package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemFood;
import net.minecraft.server.ItemStack;
import net.minecraft.server.MobEffect;
import net.minecraft.server.World;

class TMPObjectsInstantiation$15 extends ItemFood
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$15(TMPObjectsInstantiation var1, int var2, int var3, float var4, boolean var5)
    {
        super(var2, var3, var4, var5);
        this.this$0 = var1;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int a(ItemStack var1)
    {
        return 10;
    }

    public ItemStack b(ItemStack var1, World var2, EntityHuman var3)
    {
        var3.heal(1);
        var3.addEffect(new MobEffect(1, 1200, 1));
        return super.b(var1, var2, var3);
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
