package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EnumAnimation;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class ItemRoastedLichen extends Item
{
    public ItemRoastedLichen(int var1)
    {
        super(var1);
    }

    public ItemStack b(ItemStack var1, World var2, EntityHuman var3)
    {
        --var1.count;
        var3.bv();
        var3.heal(2);
        return var1;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int a(ItemStack var1)
    {
        return 10;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAnimation d_(ItemStack var1)
    {
        return EnumAnimation.b;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack a(ItemStack var1, World var2, EntityHuman var3)
    {
        var3.a(var1, this.a(var1));
        return var1;
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
