package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.World;

class TMPObjectsInstantiation$14 extends BlockFlower2
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$14(TMPObjectsInstantiation var1, int var2, int var3)
    {
        super(var2, var3);
        this.this$0 = var1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int getDropType(int var1, Random var2, int var3)
    {
        return this.this$0.itemberry.id;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int a(Random var1)
    {
        return var1.nextInt(4) + 1;
    }

    /**
     * The type of render function that is called for this block
     */
    public int d()
    {
        return 6;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB e(World var1, int var2, int var3, int var4)
    {
        float var5 = 0.2F;
        return AxisAlignedBB.a((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - 0.05F), (double)((float)(var4 + 1) - var5));
    }

    public AxisAlignedBB b_(World var1, int var2, int var3, int var4)
    {
        return this.e(var1, var2, var3, var4);
    }
}
