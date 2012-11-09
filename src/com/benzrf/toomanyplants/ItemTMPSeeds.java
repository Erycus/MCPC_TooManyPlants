package com.benzrf.toomanyplants;

import net.minecraft.server.Block;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class ItemTMPSeeds extends Item
{
    private final Block blockType;

    protected ItemTMPSeeds(int var1, Block var2)
    {
        super(var1);
        this.blockType = var2;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10)
    {
        if (var3.getTypeId(var4, var5, var6) != Block.SNOW.id)
        {
            if (var7 == 0)
            {
                --var5;
            }

            if (var7 == 1)
            {
                ++var5;
            }

            if (var7 == 2)
            {
                --var6;
            }

            if (var7 == 3)
            {
                ++var6;
            }

            if (var7 == 4)
            {
                --var4;
            }

            if (var7 == 5)
            {
                ++var4;
            }

            if (!var3.isEmpty(var4, var5, var6))
            {
                return false;
            }
        }

        if (!var2.func_82247_a(var4, var5, var6, var7, var1))
        {
            return false;
        }
        else
        {
            if (Block.REDSTONE_WIRE.canPlace(var3, var4, var5, var6))
            {
                --var1.count;
                var3.setTypeId(var4, var5, var6, this.blockType.id);
            }

            return true;
        }
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
