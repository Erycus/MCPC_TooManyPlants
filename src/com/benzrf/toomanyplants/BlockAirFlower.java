package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.World;

public class BlockAirFlower extends BlockFlower2
{
    protected BlockAirFlower(int var1, int var2)
    {
        super(var1, var2);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void postPlace(World var1, int var2, int var3, int var4, EntityLiving var5)
    {
        if (var5 instanceof EntityHuman)
        {
            for (int var6 = -1; var6 <= 1; ++var6)
            {
                for (int var7 = -1; var7 <= 1; ++var7)
                {
                    for (int var8 = -1; var8 <= 1; ++var8)
                    {
                        if (var1.getTypeId(var2 + var6, var3 + var7, var4 + var8) == 8 || var1.getTypeId(var2 + var6, var3 + var7, var4 + var8) == 9)
                        {
                            var1.setRawTypeId(var2 + var6, var3 + var7, var4 + var8, 0);
                        }
                    }
                }
            }
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void remove(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        for (int var7 = -1; var7 <= 1; ++var7)
        {
            for (int var8 = -1; var8 <= 1; ++var8)
            {
                for (int var9 = -1; var9 <= 1; ++var9)
                {
                    var1.applyPhysics(var2 + var7, var3 + var8, var4 + var9, 0);
                }
            }
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void doPhysics(World var1, int var2, int var3, int var4, int var5)
    {
        super.doPhysics(var1, var2, var3, var4, var5);

        for (int var6 = -1; var6 <= 1; ++var6)
        {
            for (int var7 = 0; var7 <= 1; ++var7)
            {
                for (int var8 = -1; var8 <= 1; ++var8)
                {
                    if (var1.getTypeId(var2 + var6, var3 + var7, var4 + var8) == 8 || var1.getTypeId(var2 + var6, var3 + var7, var4 + var8) == 9)
                    {
                        var1.setRawTypeId(var2 + var6, var3 + var7, var4 + var8, 0);
                    }
                }
            }
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean d(World var1, int var2, int var3, int var4)
    {
        return this.d_(var1.getTypeId(var2, var3 - 1, var4));
    }
}
