package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemFood;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

class TMPObjectsInstantiation$17 extends ItemFood
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$17(TMPObjectsInstantiation var1, int var2, int var3, float var4, boolean var5)
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
        var2.makeSound(var3, "random.orb", 0.1F, 0.5F * ((var2.random.nextFloat() - var2.random.nextFloat()) * 0.7F + 1.8F));
        var3.giveExp(15 + var2.random.nextInt(16));
        return super.b(var1, var2, var3);
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
