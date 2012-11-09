package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.World;

class TMPObjectsInstantiation$13 extends BlockFlower2
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$13(TMPObjectsInstantiation var1, int var2, int var3)
    {
        super(var2, var3);
        this.this$0 = var1;
    }

    public void a(World var1, int var2, int var3, int var4, Random var5)
    {
        double var6 = (double)((float)var2 + 0.5F);
        double var8 = (double)((float)var3 + 1.0F);
        double var10 = (double)((float)var4 + 0.5F);
        double var12 = 0.2199999988079071D;
        double var14 = 0.27000001072883606D;
        var1.addParticle("smoke", var6, var8, var10, 0.0D, 0.0D, 0.0D);
    }
}
