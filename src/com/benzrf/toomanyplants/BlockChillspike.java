package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.DamageSource;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;

public class BlockChillspike extends BlockFlower2
{
    public static int[][] toFreeze = new int[][] {{0, 3, 0}, {1, 2, 0}, {0, 2, 1}, {0, 2, 0}, {0, 2, -1}, { -1, 2, 0}, {2, 1, 0}, {1, 1, 1}, {1, 1, 0}, {1, 1, -1}, {0, 1, 2}, {0, 1, 1}, {0, 1, 0}, {0, 1, -1}, {0, 1, -2}, { -1, 1, 1}, { -1, 1, 0}, { -1, 1, -1}, { -2, 1, 0}, {2, 0, 0}, {1, 0, 1}, {1, 0, 0}, {1, 0, -1}, {0, 0, 2}, {0, 0, 1}, {0, 0, 0}, {0, 0, -1}, {0, 0, -2}, { -1, 0, 1}, { -1, 0, 0}, { -1, 0, -1}, { -2, 0, 0}, {2, -1, 0}, {1, -1, 1}, {1, -1, 0}, {1, -1, -1}, {0, -1, 2}, {0, -1, 1}, {0, -1, 0}, {0, -1, -1}, {0, -1, -2}, { -1, -1, 1}, { -1, -1, 0}, { -1, -1, -1}, { -2, -1, 0}, {1, -2, 0}, {0, -2, 1}, {0, -2, 0}, {0, -2, -1}, { -1, -2, 0}, {0, -3, 0}};

    protected BlockChillspike(int var1, int var2)
    {
        super(var1, var2);
        this.b(true);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void b(World var1, int var2, int var3, int var4, Random var5)
    {
        if (var5.nextInt(3) == 0)
        {
            int[] var6 = toFreeze[var5.nextInt(toFreeze.length)];
            setIfNetherrack(var1, var2 + var6[0], var3 + var6[1], var4 + var6[2]);
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onPlace(World var1, int var2, int var3, int var4)
    {
        super.onPlace(var1, var2, var3, var4);
        this.checkBlock(var1, var2 + 1, var3, var4);
        this.checkBlock(var1, var2 - 1, var3, var4);
        this.checkBlock(var1, var2, var3 + 1, var4);
        this.checkBlock(var1, var2, var3, var4 + 1);
        this.checkBlock(var1, var2, var3, var4 - 1);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB e(World var1, int var2, int var3, int var4)
    {
        float var5 = 0.2F;
        return AxisAlignedBB.a((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - 0.2F), (double)((float)(var4 + 1) - var5));
    }

    public AxisAlignedBB b_(World var1, int var2, int var3, int var4)
    {
        return this.e(var1, var2, var3, var4);
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void attack(World var1, int var2, int var3, int var4, EntityHuman var5)
    {
        if (var5.inventory.getItemInHand() == null || var5.inventory.getItemInHand().getItem().id != TooManyPlants.objs.itemgoldenshears.id)
        {
            var5.a((Entity)null, 1, (double)var2 - var5.locX, (double)var4 - var5.locZ);
            var5.damageEntity(DamageSource.CACTUS, 10);
        }
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void a(World var1, int var2, int var3, int var4, Entity var5)
    {
        if (var5 instanceof EntityLiving)
        {
            var5.damageEntity(DamageSource.CACTUS, 1);
            ((EntityLiving)var5).a((Entity)null, 3, (double)var2 - var5.locX, (double)var4 - var5.locZ);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void doPhysics(World var1, int var2, int var3, int var4, int var5)
    {
        super.doPhysics(var1, var2, var3, var4, var5);
        this.checkBlock(var1, var2 + 1, var3, var4);
        this.checkBlock(var1, var2 - 1, var3, var4);
        this.checkBlock(var1, var2, var3 + 1, var4);
        this.checkBlock(var1, var2, var3, var4 + 1);
        this.checkBlock(var1, var2, var3, var4 - 1);
    }

    private byte checkBlock(World var1, int var2, int var3, int var4)
    {
        if (var1.getTypeId(var2, var3, var4) != Block.WATER.id && var1.getTypeId(var2, var3, var4) != Block.STATIONARY_WATER.id)
        {
            if (var1.getTypeId(var2, var3, var4) != Block.LAVA.id && var1.getTypeId(var2, var3, var4) != Block.STATIONARY_LAVA.id)
            {
                if (var1.getTypeId(var2, var3, var4) == Block.FIRE.id)
                {
                    var1.setRawTypeId(var2, var3, var4, 0);
                    return (byte)1;
                }
                else
                {
                    return (byte)0;
                }
            }
            else
            {
                var1.setRawTypeId(var2, var3, var4, Block.COBBLESTONE.id);
                return (byte)1;
            }
        }
        else
        {
            var1.setRawTypeId(var2, var3, var4, Block.ICE.id);
            return (byte)1;
        }
    }

    public void a(World var1, int var2, int var3, int var4, Random var5)
    {
        this.sparkle(var1, var2, var3, var4);
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
                var1.addParticle("reddust", var9, var11, var13, -0.5D, 3.0D, 2.0D);
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

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void postBreak(World var1, int var2, int var3, int var4, int var5)
    {
        this.a(var1, var2, var3, var4, new ItemStack(this));
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int getDropType(int var1, Random var2, int var3)
    {
        return 0;
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean d_(int var1)
    {
        return var1 == Block.NETHERRACK.id || var1 == TooManyPlants.objs.blockfrozennetherrack.id;
    }

    public static void setIfNetherrack(World var0, int var1, int var2, int var3)
    {
        if (var0.getTypeId(var1, var2, var3) == Block.NETHERRACK.id)
        {
            var0.setRawTypeId(var1, var2, var3, TooManyPlants.objs.blockfrozennetherrack.id);
        }
    }
}
