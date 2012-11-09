package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemSoup;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

class TMPObjectsInstantiation$10 extends ItemSoup
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$10(TMPObjectsInstantiation var1, int var2, int var3)
    {
        super(var2, var3);
        this.this$0 = var1;
    }

    public ItemStack b(ItemStack var1, World var2, EntityHuman var3)
    {
        var3.heal(10);
        return super.b(var1, var2, var3);
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
