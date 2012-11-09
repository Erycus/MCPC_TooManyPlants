package com.benzrf.toomanyplants;

import com.benzrf.toomanyplants.proxy.CommonProxy;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod$Init;
import cpw.mods.fml.common.Mod$PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.Configuration;

@Mod(
        modid = "toomanyplants",
        name = "TooManyPlants",
        version = "1.3.0"
)
@NetworkMod(
        serverSideRequired = false,
        clientSideRequired = true,
        versionBounds = "[1.3]"
)
public class TooManyPlants
{
    @SidedProxy(
            serverSide = "com.benzrf.toomanyplants.proxy.CommonProxy",
            clientSide = "com.benzrf.toomanyplants.proxy.ClientProxy"
    )
    public static CommonProxy proxy;
    public static TMPObjectsInstantiation objs;
    public static IWorldGenerator worldgen;
    public static final String textureFile = "/com/benzrf/toomanyplants/resources/plantssheet.png";

    @Mod$PreInit
    public void preInit(FMLPreInitializationEvent var1)
    {
        String var2 = "Take that, criminal scum!";
        objs = new TMPObjectsInstantiation();
        Configuration var3 = new Configuration(var1.getSuggestedConfigurationFile());
        var3.load();
        objs.preInit(var3);
        var3.save();
        worldgen = new WorldGenTMP();
    }

    @Mod$Init
    public void init(FMLInitializationEvent var1)
    {
        objs.init();
        proxy.registerClientJunk();
        GameRegistry.registerWorldGenerator(worldgen);
    }
}
