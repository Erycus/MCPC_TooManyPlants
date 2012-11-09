package com.benzrf.toomanyplants;

import java.util.Random;
import net.minecraft.server.Block;
import net.minecraft.server.BlockFlower;
import net.minecraft.server.DamageSource;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Item;
import net.minecraft.server.World;

public class BlockEvilFlower extends BlockFlower
{
    protected BlockEvilFlower(int var1, int var2)
    {
        super(var1, var2);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int getDropType(int var1, Random var2, int var3)
    {
        return TooManyPlants.objs.itemevilflowerpetal.id;
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void attack(World var1, int var2, int var3, int var4, EntityHuman var5)
    {
        if (var5.inventory.getItemInHand() != null && var5.inventory.getItemInHand().getItem().equals(Item.SHEARS))
        {
            var5.damageEntity(DamageSource.MAGIC, 10);
        }
        else
        {
            var5.damageEntity(DamageSource.MAGIC, 20);
        }
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean d_(int var1)
    {
        return var1 == Block.SAND.id || var1 == Block.STONE.id;
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
