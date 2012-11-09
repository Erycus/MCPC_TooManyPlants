package com.benzrf.toomanyplants;

import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

class TMPObjectsInstantiation$21 extends ItemTMPSeeds
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$21(TMPObjectsInstantiation var1, int var2, Block var3)
    {
        super(var2, var3);
        this.this$0 = var1;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10)
    {
        return var3.a(AxisAlignedBB.a((double)(var4 - 5), (double)(var5 - 5), (double)(var6 - 5), (double)(var4 + 5), (double)(var5 + 5), (double)(var6 + 5)), Material.PLANT) ? false : super.interactWith(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
    }
}
