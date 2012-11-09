package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemSeeds;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

class TMPObjectsInstantiation$7 extends ItemSeeds
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$7(TMPObjectsInstantiation var1, int var2, int var3, int var4)
    {
        super(var2, var3, var4);
        this.this$0 = var1;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10)
    {
        boolean var11 = super.interactWith(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);

        if (var11)
        {
            ((BlockBeanstalk)this.this$0.blockbeanstalk).grow(var3, var4, var5 + 1, var6);
        }

        return var11;
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
