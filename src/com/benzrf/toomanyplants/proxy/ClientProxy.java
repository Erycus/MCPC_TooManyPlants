package com.benzrf.toomanyplants.proxy;

import com.benzrf.toomanyplants.TextureDawnFlowerFX;
import com.benzrf.toomanyplants.TooManyPlants;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
    public void registerClientJunk()
    {
        MinecraftForgeClient.preloadTexture("/com/benzrf/toomanyplants/resources/plantssheet.png");
        FMLClientHandler.instance().getClient().o.a((bbi)(new TextureDawnFlowerFX(TooManyPlants.objs.blockdawnflower.textureId, Minecraft.x())));
    }
}
