package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.BlockFlower;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.World;

public class BlockBeanSprout extends BlockFlower
{
    protected BlockBeanSprout(int var1, int var2)
    {
        super(var1, var2);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean d_(int var1)
    {
        return var1 == Block.DIRT.id || var1 == Block.GRASS.id;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int a(Random var1)
    {
        return 0;
    }

    /**
     * Called when the block is placed in the world.
     */
    public void postPlace(World var1, int var2, int var3, int var4, EntityLiving var5)
    {
        var1.a(var2, var3, var4, this.id, 60);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void b(World var1, int var2, int var3, int var4, Random var5)
    {
        var1.setRawData(var2, var3, var4, var1.getData(var2, var3, var4) + 1);

        if (var1.getData(var2, var3, var4) == 10)
        {
            var1.setTypeIdAndData(var2, var3, var4, TooManyPlants.objs.blockbeanplant.id, 0);
        }
        else
        {
            var1.a(var2, var3, var4, this.id, 60);
        }
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
