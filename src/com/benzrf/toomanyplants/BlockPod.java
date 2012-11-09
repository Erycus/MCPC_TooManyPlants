package com.benzrf.toomanyplants;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockPod extends Block
{
    protected BlockPod(int var1, int var2)
    {
        super(var1, var2, Material.PLANT);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int a(Random var1)
    {
        return 0;
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void postBreak(World var1, int var2, int var3, int var4, int var5)
    {
        if (var1.getData(var2, var3 - 1, var4) == 0)
        {
            var1.setRawTypeId(var2, var3 + 1, var4, 0);
        }
        else
        {
            var1.setRawTypeId(var2, var3 - 1, var4, 0);
        }
    }

    public ArrayList getBlockDropped(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        Random var8 = new Random();
        int var9 = var8.nextInt(7) + 4;
        int var10;

        for (var10 = 0; var10 <= var9; ++var10)
        {
            var7.add(new ItemStack(Item.GOLD_INGOT, 1));
        }

        var9 = var8.nextInt(7) + 4;

        for (var10 = 0; var10 <= var9; ++var10)
        {
            var7.add(new ItemStack(Item.IRON_INGOT, 1));
        }

        var9 = var8.nextInt(7) + 4;

        for (var10 = 0; var10 <= var9; ++var10)
        {
            var7.add(new ItemStack(TooManyPlants.objs.itembean, 1));
        }

        return var7;
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
