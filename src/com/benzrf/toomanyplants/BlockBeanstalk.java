package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.Entity;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockBeanstalk extends Block
{
    protected BlockBeanstalk(int var1, int var2)
    {
        super(var1, var2, Material.EARTH);
        float var3 = 0.375F;
        this.a(var3, 0.0F, var3, 1.0F - var3, 1.0F, 1.0F - var3);
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean b()
    {
        return false;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean c()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int d()
    {
        return 1;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB e(World var1, int var2, int var3, int var4)
    {
        float var5 = 0.375F;
        return AxisAlignedBB.a((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - var5), (double)((float)(var4 + 1) - var5));
    }

    public AxisAlignedBB b_(World var1, int var2, int var3, int var4)
    {
        float var5 = 0.375F;
        return AxisAlignedBB.a((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - var5), (double)((float)(var4 + 1) - var5));
    }

    public void grow(World var1, int var2, int var3, int var4)
    {
        var1.a(var2, var3, var4, this.id, 5);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void b(World var1, int var2, int var3, int var4, Random var5)
    {
        if (var3 < 253)
        {
            if (var1.getTypeId(var2, var3 + 1, var4) == 0)
            {
                var1.setTypeIdAndData(var2, var3 + 1, var4, this.id, var1.getData(var2, var3, var4));
                var1.a(var2, var3 + 1, var4, this.id, 5);
            }
        }
        else if (var1.getData(var2, var3, var4) == 1)
        {
            var1.setRawData(var2, var3, var4, 0);
            var1.setTypeIdAndData(var2, var3 + 1, var4, TooManyPlants.objs.blockpod.id, 1);
            var1.setTypeId(var2, var3 + 2, var4, TooManyPlants.objs.blockpod.id);
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int a(Random var1)
    {
        return 0;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void a(World var1, int var2, int var3, int var4, Entity var5)
    {
        var5.onGround = true;
        var5.fallDistance = 0.0F;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void doPhysics(World var1, int var2, int var3, int var4, int var5)
    {
        int var6 = var1.getTypeId(var2, var3 - 1, var4);

        if (var6 != this.id && var6 != Block.DIRT.id && var6 != Block.GRASS.id && var6 != Block.SOIL.id)
        {
            var1.setTypeId(var2, var3, var4, 0);
        }
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
