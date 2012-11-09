package com.benzrf.toomanyplants;

import net.minecraft.server.ItemSeeds;

class TMPObjectsInstantiation$9 extends ItemSeeds
{
    final TMPObjectsInstantiation this$0;

    TMPObjectsInstantiation$9(TMPObjectsInstantiation var1, int var2, int var3, int var4)
    {
        super(var2, var3, var4);
        this.this$0 = var1;
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
