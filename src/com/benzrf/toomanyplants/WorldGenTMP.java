package com.benzrf.toomanyplants;

import com.benzrf.toomanyplants.WorldGenTMP$1;
import com.benzrf.toomanyplants.WorldGenTMP$TMPPlantGen;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Block;
import net.minecraft.server.IChunkProvider;
import net.minecraft.server.World;
import net.minecraft.server.WorldGenMinable;
import net.minecraft.server.WorldType;

public class WorldGenTMP implements IWorldGenerator
{
    public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6)
    {
        WorldGenTMP$TMPPlantGen var7 = new WorldGenTMP$TMPPlantGen(this);
        var2 *= 16;
        var3 *= 16;

        if (!var4.getWorldData().getType().equals(WorldType.FLAT))
        {
            if (var4.getBiome(var2, var3).equals(BiomeBase.HELL))
            {
                if (var1.nextInt(4) == 0)
                {
                    var7.plantBlockId = TooManyPlants.objs.blockchillspike.id;
                    var7.limit = 1;
                    var7.metadata = 0;
                    var7.run = new WorldGenTMP$1(this);
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(120), var3 + 8);
                }

                var7.plantBlockId = TooManyPlants.objs.blockbonefinger.id;
                var7.limit = 1;
                var7.metadata = 4;
                var7.run = null;
                var7.generate(var4, var1, var2 + 8, var1.nextInt(120), var3 + 8);
            }
            else
            {
                var7.plantBlockId = TooManyPlants.objs.blockpreglowflower.id;
                var7.limit = 3;
                int var8;

                for (var8 = 0; var8 <= 6; ++var8)
                {
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(255), var3 + 8);
                }

                if (!var4.getBiome(var2, var3).equals(BiomeBase.ICE_MOUNTAINS) && !var4.getBiome(var2, var3).equals(BiomeBase.TAIGA_HILLS))
                {
                    var7.plantBlockId = TooManyPlants.objs.blockdawnflower.id;
                    var7.limit = 1;

                    for (var8 = 0; var8 <= 2; ++var8)
                    {
                        var7.generate(var4, var1, var2 + 8, 90 + var1.nextInt(90), var3 + 8);
                    }
                }

                if (var4.getBiome(var2, var3).equals(BiomeBase.ICE_MOUNTAINS) || var4.getBiome(var2, var3).equals(BiomeBase.TAIGA_HILLS) || var4.getBiome(var2, var3).equals(BiomeBase.TAIGA_HILLS))
                {
                    var7.plantBlockId = TooManyPlants.objs.blocklotus.id;
                    var7.limit = 1;
                    var7.generate(var4, var1, var2 + 8, 90 + var1.nextInt(90), var3 + 8);
                }

                if (var1.nextInt(1) == 0)
                {
                    var7.plantBlockId = TooManyPlants.objs.blockbeanplant.id;
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(255), var3 + 8);
                }

                if ((var4.getBiome(var2, var3).equals(BiomeBase.DESERT) || var4.getBiome(var2, var3).equals(BiomeBase.DESERT_HILLS)) && var1.nextInt(4) == 0)
                {
                    var7.plantBlockId = TooManyPlants.objs.blockevilflower.id;
                    var7.limit = 1;
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(255), var3 + 8);
                }

                if ((var4.getBiome(var2, var3).equals(BiomeBase.TAIGA) || var4.getBiome(var2, var3).equals(BiomeBase.TAIGA_HILLS) || var4.getBiome(var2, var3).equals(BiomeBase.ICE_PLAINS) || var4.getBiome(var2, var3).equals(BiomeBase.ICE_MOUNTAINS)) && var1.nextInt(1) == 0)
                {
                    var7.plantBlockId = TooManyPlants.objs.blocklily.id;
                    var7.limit = 1;
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(255), var3 + 8);
                }

                if (var4.getBiome(var2, var3).equals(BiomeBase.SWAMPLAND) && var1.nextInt(2) == 0)
                {
                    var7.plantBlockId = TooManyPlants.objs.blockpitcherplant.id;
                    var7.limit = 1;
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(255), var3 + 8);
                }

                if (var4.getBiome(var2, var3).equals(BiomeBase.FOREST) || var4.getBiome(var2, var3).equals(BiomeBase.FOREST_HILLS))
                {
                    for (var8 = 0; var8 <= 2; ++var8)
                    {
                        var7.plantBlockId = TooManyPlants.objs.blockberrybush.id;
                        var7.limit = 3;
                        var7.generate(var4, var1, var2 + 8, var1.nextInt(255), var3 + 8);
                    }
                }

                if (var4.getBiome(var2, var3).equals(BiomeBase.SWAMPLAND))
                {
                    var7.plantBlockId = TooManyPlants.objs.blockfireflower.id;
                    var7.limit = 3;
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(255), var3 + 8);
                }

                var7.plantBlockId = TooManyPlants.objs.blockairflower.id;
                var7.limit = 4;

                if (var1.nextInt(2) == 0)
                {
                    var7.generate(var4, var1, var2 + 8, var1.nextInt(215) + 40, var3 + 8);
                }

                var7.plantBlockId = TooManyPlants.objs.blocklichen.id;
                var7.limit = 5;

                for (var8 = 0; var8 <= 10; ++var8)
                {
                    var7.generate(var4, var1, var2 + 8, 13 * var8 + 5, var3 + 8);
                }

                if (var4.getBiome(var2, var3).equals(BiomeBase.DESERT) || var4.getBiome(var2, var3).equals(BiomeBase.DESERT_HILLS))
                {
                    var7.plantBlockId = TooManyPlants.objs.blockpricklypear.id;
                    var7.limit = 1;

                    for (var8 = 0; var8 <= 2; ++var8)
                    {
                        var7.generate(var4, var1, var2 + 8, var1.nextInt(170), var3 + 8);
                    }
                }

                if (var4.getBiome(var2, var3).equals(BiomeBase.JUNGLE) || var4.getBiome(var2, var3).equals(BiomeBase.JUNGLE_HILLS))
                {
                    var7.plantBlockId = TooManyPlants.objs.blockcreepara.id;
                    var7.limit = 1;
                    var7.replace = Block.LEAVES.id;

                    for (var8 = 0; var8 <= 10; ++var8)
                    {
                        var7.generate(var4, var1, var2 + 8, var1.nextInt(170), var3 + 8);
                    }
                }

                if (var4.getSeed() == 40507131L && !var4.getBiome(var2, var3).equals(BiomeBase.OCEAN))
                {
                    WorldGenMinable var10 = new WorldGenMinable(Block.DIAMOND_ORE.id, 25);

                    for (int var9 = 0; var9 <= 10; ++var9)
                    {
                        var10.a(var4, var1, var2 + var1.nextInt(16), var1.nextInt(25) + 30, var3 + var1.nextInt(16));
                    }
                }
            }
        }
    }
}
