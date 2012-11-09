package com.benzrf.toomanyplants;

import net.minecraft.server.Block;
import net.minecraft.server.BlockBloodStone;
import net.minecraft.server.World;

class TMPObjectsInstantiation$23 extends BlockBloodStone
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$23(TMPObjectsInstantiation var1, int var2, int var3)
    {
        super(var2, var3);
        this.this$0 = var1;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onPlace(World var1, int var2, int var3, int var4)
    {
        if (var1.getTypeId(var2, var3 + 1, var4) == Block.FIRE.id)
        {
            var1.setRawTypeId(var2, var3 + 1, var4, 0);
        }

        if (var1.getTypeId(var2, var3 + 1, var4) == Block.STATIONARY_LAVA.id || var1.getTypeId(var2, var3 + 1, var4) == Block.LAVA.id)
        {
            var1.setRawTypeId(var2, var3, var4, Block.NETHERRACK.id);
            var1.triggerEffect(1004, var2, var3, var4, 0);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void doPhysics(World var1, int var2, int var3, int var4, int var5)
    {
        if (var1.getTypeId(var2, var3 + 1, var4) == Block.FIRE.id)
        {
            var1.setRawTypeId(var2, var3 + 1, var4, 0);
        }

        if (var1.getTypeId(var2, var3 + 1, var4) == Block.STATIONARY_LAVA.id || var1.getTypeId(var2, var3 + 1, var4) == Block.LAVA.id)
        {
            var1.setRawTypeId(var2, var3, var4, Block.NETHERRACK.id);
            var1.triggerEffect(1004, var2, var3, var4, 0);
        }
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
