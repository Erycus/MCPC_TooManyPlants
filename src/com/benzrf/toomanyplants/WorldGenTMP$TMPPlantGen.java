package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

class WorldGenTMP$TMPPlantGen
{
    public int limit;
    public int metadata;
    public int replace;
    public GenRunnable run;
    public int plantBlockId;

    final WorldGenTMP this$0;

    WorldGenTMP$TMPPlantGen(WorldGenTMP var1)
    {
        this.this$0 = var1;
        this.limit = 0;
        this.metadata = 0;
        this.replace = 0;
        this.plantBlockId = 0;
    }

    public void generate(World var1, Random var2, int var3, int var4, int var5)
    {
        if (this.replace != 0)
        {
            this.generateR(var1, var2, var3, var4, var5);
        }
        else
        {
            int var6 = 0;

            for (int var7 = 0; var7 < 64; ++var7)
            {
                if (var6 >= this.limit)
                {
                    return;
                }

                int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
                int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
                int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);

                if ((var1.isEmpty(var8, var9, var10) || var1.getTypeId(var8, var9, var10) == Block.SNOW.id) && Block.byId[this.plantBlockId].d(var1, var8, var9, var10))
                {
                    var1.setRawTypeIdAndData(var8, var9, var10, this.plantBlockId, this.metadata);

                    if (this.run != null)
                    {
                        this.run.run(var1, var8, var9, var10);
                    }

                    ++var6;
                }
            }
        }
    }

    private void generateR(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = 0;

        for (int var7 = 0; var7 < 64; ++var7)
        {
            if (var6 > this.limit)
            {
                return;
            }

            int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);

            if (var1.getTypeId(var8, var9, var10) == this.replace && var1.getTypeId(var8, var9 + 1, var10) == this.replace && Block.byId[this.plantBlockId].d(var1, var8, var9, var10))
            {
                var1.setRawTypeIdAndData(var8, var9, var10, this.plantBlockId, this.metadata);
                ++var6;
            }
        }
    }
}
