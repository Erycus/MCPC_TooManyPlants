package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.World;

class TMPObjectsInstantiation$20 extends BlockFlower2
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$20(TMPObjectsInstantiation var1, int var2, int var3)
    {
        super(var2, var3);
        this.this$0 = var1;
        this.b(true);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void b(World var1, int var2, int var3, int var4, Random var5)
    {
        if (var5.nextInt(10) == 0)
        {
            var1.setRawTypeId(var2, var3, var4, this.this$0.gildedlilyId);
        }
    }
}
