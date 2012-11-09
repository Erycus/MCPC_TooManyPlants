package com.benzrf.toomanyplants;

import net.minecraft.server.BlockFlower;

public class BlockDawnflower extends BlockFlower
{
    protected BlockDawnflower(int var1, int var2)
    {
        super(var1, var2);
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
