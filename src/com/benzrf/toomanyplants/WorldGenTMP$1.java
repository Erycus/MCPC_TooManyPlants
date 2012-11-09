package com.benzrf.toomanyplants;

import net.minecraft.server.World;

class WorldGenTMP$1 extends GenRunnable
{
    final WorldGenTMP this$0;

    WorldGenTMP$1(WorldGenTMP var1)
    {
        this.this$0 = var1;
    }

    public void run(World var1, int var2, int var3, int var4)
    {
        int[][] var5 = BlockChillspike.toFreeze;
        int var6 = var5.length;

        for (int var7 = 0; var7 < var6; ++var7)
        {
            int[] var8 = var5[var7];
            BlockChillspike.setIfNetherrack(var1, var2 + var8[0], var3 + var8[1], var4 + var8[2]);
        }
    }
}
