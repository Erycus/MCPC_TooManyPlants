package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityArrow;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.Item;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockCreepara extends Block
{
    int t1;
    int t2;

    protected BlockCreepara(int var1, int var2, int var3)
    {
        super(var1, Material.PUMPKIN);
        this.t1 = var2;
        this.t2 = var3;
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void attack(World var1, int var2, int var3, int var4, EntityHuman var5)
    {
        if (!this.isCoveredWithWater(var1, var2, var3, var4))
        {
            var1.setTypeId(var2, var3, var4, 0);
            var1.explode((Entity)null, (double)var2, (double)var3, (double)var4, 3.0F, true);
        }
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void a(World var1, int var2, int var3, int var4, Entity var5)
    {
        super.a(var1, var2, var3, var4, var5);

        if (var5 instanceof EntityLiving || var5 instanceof EntityArrow)
        {
            if (!this.isCoveredWithWater(var1, var2, var3, var4))
            {
                var1.setTypeId(var2, var3, var4, 0);
                var1.explode((Entity)null, (double)var2, (double)var3, (double)var4, 3.0F, true);
            }
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean interact(World var1, int var2, int var3, int var4, EntityHuman var5, int var6, float var7, float var8, float var9)
    {
        if (var5.inventory.getItemInHand() != null && var5.inventory.getItemInHand().getItem().equals(Item.SULPHUR))
        {
            if (var1.getData(var2, var3, var4) <= 3)
            {
                var1.setData(var2, var3, var4, var1.getData(var2, var3, var4) + 1);
                --var5.inventory.getItemInHand().count;
                this.b(var1, var2, var3, var4, var1.random);
                return true;
            }
            else
            {
                this.sparkle(var1, var2, var3, var4);
                --var5.inventory.getItemInHand().count;
                var1.setData(var2, var3, var4, 0);
                int var10 = 2;

                for (int var11 = -1; var11 <= 1; ++var11)
                {
                    for (int var12 = -1; var12 <= 1; ++var12)
                    {
                        for (int var13 = -1; var13 <= 1; ++var13)
                        {
                            if (var1.getTypeId(var2 + var11, var3 + var12, var4 + var13) == Block.LEAVES.id && var1.random.nextInt(1) == 0 && this.canThisPlantGrowOnThisBlockID(var1.getTypeId(var2 + var11, var3 + var12 - 1, var4 + var13)))
                            {
                                var1.setTypeIdAndData(var2 + var11, var3 + var12, var4 + var13, this.id, 0);
                                this.sparkle(var1, var2 + var11, var3 + var12, var4 + var13);
                                --var10;

                                if (var10 <= -1)
                                {
                                    return true;
                                }
                            }
                        }
                    }
                }

                return true;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlace(World var1, int var2, int var3, int var4)
    {
        return super.canPlace(var1, var2, var3, var4) && this.canThisPlantGrowOnThisBlockID(var1.getTypeId(var2, var3 - 1, var4));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int var1)
    {
        return var1 == Block.GRASS.id || var1 == Block.DIRT.id || var1 == Block.SOIL.id;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean d(World var1, int var2, int var3, int var4)
    {
        return this.canThisPlantGrowOnThisBlockID(var1.getTypeId(var2, var3 - 1, var4));
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int a(int var1)
    {
        return var1 != 0 && var1 != 1 ? this.t2 : this.t1;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB e(World var1, int var2, int var3, int var4)
    {
        float var5 = 0.03F;
        float var6 = 0.97F;
        return AxisAlignedBB.a((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)var2 + var6), (double)((float)var3 + var6), (double)((float)var4 + var6));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void doPhysics(World var1, int var2, int var3, int var4, int var5)
    {
        if (!this.d(var1, var2, var3, var4))
        {
            var1.setTypeId(var2, var3, var4, 0);

            if (this.isCoveredWithWater(var1, var2, var3, var4))
            {
                this.c(var1, var2, var3, var4, var1.getData(var2, var3, var4), 0);
                return;
            }

            var1.explode((Entity)null, (double)var2, (double)var3, (double)var4, 3.0F, false);
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void remove(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        if (!this.isCoveredWithWater(var1, var2, var3, var4))
        {
            var1.setTypeId(var2, var3, var4, 0);
            var1.explode((Entity)null, (double)var2, (double)var3, (double)var4, 3.0F, true);
        }
    }

    public boolean isCoveredWithWater(World var1, int var2, int var3, int var4)
    {
        int var5 = 0;

        if (var1.getTypeId(var2 + 1, var3, var4) == 8 || var1.getTypeId(var2 + 1, var3, var4) == 9)
        {
            ++var5;
        }

        if (var1.getTypeId(var2, var3 + 1, var4) == 8 || var1.getTypeId(var2, var3 + 1, var4) == 9)
        {
            ++var5;
        }

        if (var1.getTypeId(var2, var3, var4 + 1) == 8 || var1.getTypeId(var2, var3, var4 + 1) == 9)
        {
            ++var5;
        }

        if (var1.getTypeId(var2 - 1, var3, var4) == 8 || var1.getTypeId(var2 - 1, var3, var4) == 9)
        {
            ++var5;
        }

        if (var1.getTypeId(var2, var3, var4 - 1) == 8 || var1.getTypeId(var2, var3, var4 - 1) == 9)
        {
            ++var5;
        }

        return var5 == 5;
    }

    private void sparkle(World var1, int var2, int var3, int var4)
    {
        Random var5 = var1.random;
        double var6 = 0.0625D;

        for (int var8 = 0; var8 < 6; ++var8)
        {
            double var9 = (double)((float)var2 + var5.nextFloat());
            double var11 = (double)((float)var3 + var5.nextFloat());
            double var13 = (double)((float)var4 + var5.nextFloat());

            if (var8 == 0 && !var1.r(var2, var3 + 1, var4))
            {
                var11 = (double)(var3 + 1) + var6;
            }

            if (var8 == 1 && !var1.r(var2, var3 - 1, var4))
            {
                var11 = (double)(var3 + 0) - var6;
            }

            if (var8 == 2 && !var1.r(var2, var3, var4 + 1))
            {
                var13 = (double)(var4 + 1) + var6;
            }

            if (var8 == 3 && !var1.r(var2, var3, var4 - 1))
            {
                var13 = (double)(var4 + 0) - var6;
            }

            if (var8 == 4 && !var1.r(var2 + 1, var3, var4))
            {
                var9 = (double)(var2 + 1) + var6;
            }

            if (var8 == 5 && !var1.r(var2 - 1, var3, var4))
            {
                var9 = (double)(var2 + 0) - var6;
            }

            if (var9 < (double)var2 || var9 > (double)(var2 + 1) || var11 < 0.0D || var11 > (double)(var3 + 1) || var13 < (double)var4 || var13 > (double)(var4 + 1))
            {
                var1.addParticle("reddust", var9, var11, var13, 0.0D, 10.0D, 0.0D);
            }
        }
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
