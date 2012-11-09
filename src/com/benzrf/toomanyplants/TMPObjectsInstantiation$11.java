package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityItem;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

class TMPObjectsInstantiation$11 extends BlockFlower2
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$11(TMPObjectsInstantiation var1, int var2, int var3)
    {
        super(var2, var3);
        this.this$0 = var1;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean interact(World var1, int var2, int var3, int var4, EntityHuman var5, int var6, float var7, float var8, float var9)
    {
        ItemStack var10 = var5.inventory.getItemInHand();

        if (var10 == null)
        {
            return false;
        }
        else if (var10.id == Item.GLASS_BOTTLE.id)
        {
            ItemStack var11 = new ItemStack(Item.POTION, 1, 0);

            if (!var5.inventory.pickup(var11))
            {
                var1.addEntity(new EntityItem(var1, (double)var2 + 0.5D, (double)var3 + 1.5D, (double)var4 + 0.5D, var11));
            }

            --var10.count;

            if (var10.count <= 0)
            {
                var5.inventory.setItem(var5.inventory.itemInHandIndex, (ItemStack)null);
            }
            else if (var5 instanceof EntityPlayer)
            {
                ((EntityPlayer)var5).updateInventory(var5.defaultContainer);
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
