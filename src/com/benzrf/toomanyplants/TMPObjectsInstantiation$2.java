package com.benzrf.toomanyplants;

import net.minecraft.server.World;

class TMPObjectsInstantiation$2 extends BlockFlower2
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$2(TMPObjectsInstantiation var1, int var2, int var3)
    {
        super(var2, var3);
        this.this$0 = var1;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean d(World var1, int var2, int var3, int var4)
    {
        return this.d_(var1.getTypeId(var2, var3 - 1, var4));
    }
}
