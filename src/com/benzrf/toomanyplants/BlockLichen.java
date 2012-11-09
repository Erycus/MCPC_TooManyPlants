package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.World;

public class BlockLichen extends BlockFlower2
{
    protected BlockLichen(int var1, int var2)
    {
        super(var1, var2);
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
        this.b(true);
        Block.setBurnProperties(this.id, 1000, 1000);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void b(World var1, int var2, int var3, int var4, Random var5)
    {
        if (var5.nextInt(15) == 0 && var1.getTypeId(var2, var3, var4) == this.id && var1.getData(var2, var3, var4) <= 5)
        {
            for (int var6 = var2 - 1; var6 <= var2 + 1; ++var6)
            {
                for (int var7 = var2 - var4; var7 <= var4 + 1; ++var7)
                {
                    if (this.d(var1, var6, var3, var7) && var1.isEmpty(var6, var3, var7) && var5.nextInt(9) == 0)
                    {
                        var1.setTypeIdAndData(var6, var3, var7, this.id, var1.getData(var2, var3, var4) + 1);
                        return;
                    }
                }
            }
        }
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
        return 0;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean d(World var1, int var2, int var3, int var4)
    {
        return (var1.k(var2, var3, var4) >= 8 || var1.j(var2, var3, var4)) && this.d_(var1.getTypeId(var2, var3 - 1, var4));
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean d_(int var1)
    {
        return var1 == Block.STONE.id || var1 == Block.COBBLESTONE.id || var1 == Block.MOSSY_COBBLESTONE.id;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int getDropType(int var1, Random var2, int var3)
    {
        return TooManyPlants.objs.itemlichen.id;
    }
}
