package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.BlockFlower;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class BlockBoneFinger extends BlockFlower
{
    int t1 = 1;
    int t2 = 1;
    int t3 = 1;

    protected BlockBoneFinger(int var1, int var2, int var3, int var4)
    {
        super(var1, var2);
        this.b(true);
        float var5 = 0.5F;
        this.a(0.5F - var5, 0.0F, 0.5F - var5, 0.5F + var5, 0.25F, 0.5F + var5);
        this.t1 = var2;
        this.t2 = var3;
        this.t3 = var4;
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean d_(int var1)
    {
        return var1 == Block.NETHERRACK.id;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void b(World var1, int var2, int var3, int var4, Random var5)
    {
        int var6 = var1.getData(var2, var3, var4);

        if (var6 < 3 && (!var1.getBiome(var2, var4).equals(BiomeBase.HELL) && var5.nextInt(7) == 0 || var1.getBiome(var2, var4).equals(BiomeBase.HELL) && var5.nextInt(4) == 0))
        {
            ++var6;
            var1.setData(var2, var3, var4, var6);
            var1.e(var2, var3, var4, var2, var3, var4);
        }

        super.b(var1, var2, var3, var4, var5);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int a(int var1, int var2)
    {
        return var2 >= 3 ? this.t3 : (var2 > 0 ? this.t2 : this.t1);
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropNaturally(World var1, int var2, int var3, int var4, int var5, float var6, int var7)
    {
        this.a(var1, var2, var3, var4, new ItemStack(TooManyPlants.objs.itemboneseed));
        int var8 = var5 == 3 ? var1.random.nextInt(4) : 0;

        for (int var9 = 0; var9 < var8; ++var9)
        {
            this.a(var1, var2, var3, var4, new ItemStack(Item.BONE));
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean d(World var1, int var2, int var3, int var4)
    {
        return var1.k(var2, var3, var4) <= 10 && this.d_(var1.getTypeId(var2, var3 - 1, var4));
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
