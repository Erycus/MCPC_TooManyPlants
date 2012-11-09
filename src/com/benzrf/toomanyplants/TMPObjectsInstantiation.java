package com.benzrf.toomanyplants;

import com.benzrf.toomanyplants.TMPObjectsInstantiation$1;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$10;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$11;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$12;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$13;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$14;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$15;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$16;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$17;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$18;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$19;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$2;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$20;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$21;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$22;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$23;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$3;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$4;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$5;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$6;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$7;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$8;
import com.benzrf.toomanyplants.TMPObjectsInstantiation$9;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.server.Block;
import net.minecraft.server.CreativeModeTab;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Material;
import net.minecraftforge.common.Configuration;

public class TMPObjectsInstantiation extends TMPObjectsDeclaration
{
    public void preInit(Configuration var1)
    {
        this.initGlowFlower(var1);
        this.initEvilFlower(var1);
        this.initAirFlower(var1);
        this.initBeanstalk(var1);
        this.initBeanPlant(var1);
        this.initPitcherPlant(var1);
        this.initBoneFinger(var1);
        this.initLichen(var1);
        this.initCreepara(var1);
        this.initPricklyPear(var1);
        this.initFireFlower(var1);
        this.initDawnFlower(var1);
        this.initBerryBush(var1);
        this.initLotus(var1);
        this.initLily(var1);
        this.initExtraShears(var1);
        this.initChillspike(var1);
    }

    void initGlowFlower(Configuration var1)
    {
        this.glowTexture = 0;
        this.preGlowFlowerId = var1.getBlock("preGlowFlowerId", 1255).getInt();
        this.blockpreglowflower = (new TMPObjectsInstantiation$1(this, this.preGlowFlowerId, this.glowTexture)).b("Non-Glowing Glow Flower");
        this.glowFlowerId = var1.getBlock("glowFlowerId", 1254).getInt();
        this.blockglowflower = (new TMPObjectsInstantiation$2(this, this.glowFlowerId, this.glowTexture)).a(0.5F).b("Glow Flower");
    }

    void initEvilFlower(Configuration var1)
    {
        this.evilFlowerTexture = 1;
        this.evilFlowerId = var1.getBlock("evilFlowerId", 1253).getInt();
        this.blockevilflower = (new BlockEvilFlower(this.evilFlowerId, this.evilFlowerTexture)).b("Evil Flower");
        this.evilFlowerPetalTexture = 2;
        this.evilFlowerPetalId = var1.getItem("evilFlowerPetalId", 413).getInt();
        this.itemevilflowerpetal = (new TMPObjectsInstantiation$3(this, this.evilFlowerPetalId)).c(this.evilFlowerPetalTexture).b("Evil Flower Petal").a(CreativeModeTab.l);
        this.animationEssenceTexture = 3;
        this.animationEssenceId = var1.getItem("animationEssenceId", 612).getInt();
        this.itemanimationessence = (new TMPObjectsInstantiation$4(this, this.animationEssenceId)).c(this.animationEssenceTexture).b("Magic Powder").a(CreativeModeTab.l);
    }

    void initAirFlower(Configuration var1)
    {
        this.airFlowerTexture = 4;
        this.airFlowerId = var1.getBlock("airFlowerId", 1252).getInt();
        this.blockairflower = (new BlockAirFlower(this.airFlowerId, this.airFlowerTexture)).b("Air Flower");
        this.rainstickTexture = 5;
        this.rainstickId = var1.getItem("rainstickId", 6875).getInt();
        this.itemrainstick = (new TMPObjectsInstantiation$5(this, this.rainstickId)).c(this.rainstickTexture).b("Rainstick").a(CreativeModeTab.i);
    }

    void initBeanstalk(Configuration var1)
    {
        this.beanstalkTexture = 6;
        this.beanstalkId = var1.getBlock("beanstalkId", 1251).getInt();
        this.blockbeanstalk = (new BlockBeanstalk(this.beanstalkId, this.beanstalkTexture)).c(0.5F);
        this.magicBeanTexture = 7;
        this.magicBeanId = var1.getItem("magicBeanId", 1230).getInt();
        this.itemmagicbean = (new TMPObjectsInstantiation$6(this, this.magicBeanId, this.blockbeanstalk.id, Block.DIRT.id)).c(this.magicBeanTexture).b("Magic Bean");
        this.lesserMagicBeanTexture = 8;
        this.lesserMagicBeanId = var1.getItem("lesserMagicBeanId", 975).getInt();
        this.itemlessermagicbean = (new TMPObjectsInstantiation$7(this, this.lesserMagicBeanId, this.blockbeanstalk.id, Block.DIRT.id)).c(this.lesserMagicBeanTexture).b("Lesser Magic Bean");
        this.podTexture = 9;
        this.podId = var1.getBlock("podId", 1250).getInt();
        this.blockpod = new BlockPod(this.podId, this.podTexture);
    }

    void initBeanPlant(Configuration var1)
    {
        this.beanPlantTexture = 10;
        this.beanPlantId = var1.getBlock("beanPlantId", 1249).getInt();
        this.blockbeanplant = (new TMPObjectsInstantiation$8(this, this.beanPlantId, this.beanPlantTexture)).b("Bean Plant");
        this.beanSproutTexture = 11;
        this.beanSproutId = var1.getBlock("beanSproutId", 1248).getInt();
        this.blockbeansprout = (new BlockBeanSprout(this.beanSproutId, this.beanSproutTexture)).b("Bean Sprout");
        this.beanTexture = 12;
        this.beanId = var1.getItem("beanId", 142).getInt();
        this.itembean = (new TMPObjectsInstantiation$9(this, this.beanId, this.blockbeansprout.id, Block.DIRT.id)).c(this.beanTexture).b("Bean");
        this.beanStewTexture = 13;
        this.beanStewId = var1.getItem("beanStewId", 4444).getInt();
        this.itembeanstew = (new TMPObjectsInstantiation$10(this, this.beanStewId, 20)).c(this.beanStewTexture).b("Bean Stew");
    }

    void initPitcherPlant(Configuration var1)
    {
        this.pitcherPlantTexture = 14;
        this.pitcherPlantId = var1.getBlock("pitcherPlantId", 1247).getInt();
        this.blockpitcherplant = (new TMPObjectsInstantiation$11(this, this.pitcherPlantId, this.pitcherPlantTexture)).b("Pitcher Plant");
    }

    void initBoneFinger(Configuration var1)
    {
        this.bonefingerTexture1 = 15;
        this.bonefingerTexture2 = 16;
        this.bonefingerTexture3 = 17;
        this.bonefingerId = var1.getBlock("bonefingerId", 1246).getInt();
        this.blockbonefinger = (new BlockBoneFinger(this.bonefingerId, this.bonefingerTexture1, this.bonefingerTexture2, this.bonefingerTexture3)).b("Bonefinger");
        this.boneseedTexture = 18;
        this.boneseedId = var1.getItem("boneseedId", 777).getInt();
        this.itemboneseed = (new TMPObjectsInstantiation$12(this, this.boneseedId, this.bonefingerId, Block.NETHERRACK.id)).c(this.boneseedTexture).b("Boneseed");
    }

    void initLichen(Configuration var1)
    {
        this.lichenBlockTexture = 19;
        this.lichenId = var1.getBlock("lichenId", 1245).getInt();
        this.blocklichen = (new BlockLichen(this.lichenId, this.lichenBlockTexture)).b("Lichen");
        this.lichenItemTexture = 20;
        this.lichenItemId = var1.getItem("lichenItemId", 314).getInt();
        this.itemlichen = (new ItemTMPSeeds(this.lichenItemId, this.blocklichen)).c(this.lichenItemTexture).b("Lichen");
        this.roastedLichenTexture = 21;
        this.roastedLichenId = var1.getItem("roastedLichenId", 4130).getInt();
        this.itemroastedlichen = (new ItemRoastedLichen(this.roastedLichenId)).c(this.roastedLichenTexture).b("Roasted Lichen").a(CreativeModeTab.h);
    }

    void initCreepara(Configuration var1)
    {
        this.creeparaTBTexture = 22;
        this.creeparaSideTexture = 23;
        this.creeparaId = var1.getBlock("creeparaId", 1244).getInt();
        this.blockcreepara = (new BlockCreepara(this.creeparaId, this.creeparaTBTexture, this.creeparaSideTexture)).b("Creepara").c(0.2F).a(CreativeModeTab.c);
    }

    void initPricklyPear(Configuration var1)
    {
        this.pricklyPearTexture = 24;
        this.pricklyPearId = var1.getBlock("pricklyPearId", 1243).getInt();
        this.blockpricklypear = (new BlockPricklyPear(this.pricklyPearId, this.pricklyPearTexture, Material.CACTUS)).b("Prickly Pear").c(0.4F).a(CreativeModeTab.c);
    }

    void initFireFlower(Configuration var1)
    {
        this.fireflowerTexture = 25;
        this.fireflowerId = var1.getBlock("fireflowerId", 1242).getInt();
        this.blockfireflower = (new TMPObjectsInstantiation$13(this, this.fireflowerId, this.fireflowerTexture)).b("Fire Flower");
        this.fireLauncherTexture = 26;
        this.fireLauncherId = var1.getItem("fireLauncherId", 783).getInt();
        this.itemfirelauncher = (new ItemFireLauncher(this.fireflowerId)).c(this.fireLauncherTexture).b("Firelauncher").a(CreativeModeTab.j);
    }

    void initDawnFlower(Configuration var1)
    {
        this.dawnflowerTexture = 39;
        this.dawnflowerId = var1.getBlock("dawnflowerId", 1241).getInt();
        this.blockdawnflower = (new BlockFlower2(this.dawnflowerId, this.dawnflowerTexture)).b("Dawnflower");
    }

    void initBerryBush(Configuration var1)
    {
        this.berryBushTexture = 27;
        this.berryBushId = var1.getBlock("berryBushId", 1240).getInt();
        this.blockberrybush = (new TMPObjectsInstantiation$14(this, this.berryBushId, this.berryBushTexture)).b("Berry Bush");
        this.berryTexture = 28;
        this.berryId = var1.getItem("berryId", 9203).getInt();
        this.itemberry = (new TMPObjectsInstantiation$15(this, this.berryId, 0, 0.0F, false)).j().b("Berry").c(this.berryTexture);
        this.berryPieTexture1 = 29;
        this.berryPieTexture2 = 30;
        this.berryPieTexture3 = 31;
        this.berryPieId = var1.getItem("berryPieId", 7209).getInt();
        this.itemberrypie = (new ItemBerryPie(this.berryPieId, this.berryPieTexture1, this.berryPieTexture2, this.berryPieTexture3)).b("Berry Pie");
    }

    void initLotus(Configuration var1)
    {
        this.lotusTexture = 32;
        this.lotusId = var1.getBlock("lotusId", 1239).getInt();
        this.blocklotus = (new TMPObjectsInstantiation$16(this, this.lotusId, this.lotusTexture)).b("Lotus");
        this.lotusBlossomTexture = 33;
        this.lotusBlossomId = var1.getItem("lotusBlossomId", 2390).getInt();
        this.itemlotusblossom = (new TMPObjectsInstantiation$17(this, this.lotusBlossomId, 0, 0.0F, false)).j().c(this.lotusBlossomTexture).b("Lotus Blossom");
    }

    void initLily(Configuration var1)
    {
        this.lilyTexture = 34;
        this.lilyId = var1.getBlock("lilyId", 1238).getInt();
        this.blocklily = (new TMPObjectsInstantiation$18(this, this.lilyId, this.lilyTexture)).b("Lily");
        this.lilySeedsTexture = 35;
        this.lilySeedsId = var1.getItem("lilySeedsId", 2380).getInt();
        this.itemlilyseeds = (new ItemTMPSeeds(this.lilySeedsId, this.blocklily)).c(this.lilySeedsTexture).b("Lily Seeds").a(CreativeModeTab.l);
        this.gildedlilyTexture = 37;
        this.gildedlilyId = var1.getBlock("gildedlilyId", 1237).getInt();
        this.blockgildedlily = (new TMPObjectsInstantiation$19(this, this.gildedlilyId, this.gildedlilyTexture)).b("Gilded Lily");
        this.smallGildedlilyTexture = 38;
        this.smallGildedlilyId = var1.getBlock("smallGildedlilyId", 1236).getInt();
        this.blocksmallgildedlily = (new TMPObjectsInstantiation$20(this, this.smallGildedlilyId, this.smallGildedlilyTexture)).b("Small Gilded Lily");
        this.gildedlilySeedsTexture = 36;
        this.gildedlilySeedsId = var1.getItem("gildedlilySeedsId", 2393).getInt();
        this.itemgildedlilyseeds = (new TMPObjectsInstantiation$21(this, this.gildedlilySeedsId, this.blocksmallgildedlily)).c(this.gildedlilySeedsTexture).b("Gilded Lily Seeds").a(CreativeModeTab.l);
    }

    void initExtraShears(Configuration var1)
    {
        this.goldenShearsTexture = 42;
        this.goldenShearsId = var1.getItem("goldenShearsId", 1025).getInt();
        this.itemgoldenshears = (new TMPObjectsInstantiation$22(this, this.goldenShearsId)).c(this.goldenShearsTexture).b("Golden Shears").setMaxDurability(119).a(CreativeModeTab.i);
    }

    void initChillspike(Configuration var1)
    {
        this.frozenNetherrackTexture = 40;
        this.frozenNetherrackId = var1.getBlock("frozenNetherrackId", 1235).getInt();
        this.blockfrozennetherrack = (new TMPObjectsInstantiation$23(this, this.frozenNetherrackId, this.frozenNetherrackTexture)).c(0.8F).b("Frozen Netherrack");
        this.chillspikeTexture = 41;
        this.chillspikeId = var1.getBlock("chillspikeId", 1234).getInt();
        this.blockchillspike = (new BlockChillspike(this.chillspikeId, this.chillspikeTexture)).c(0.5F).b("Chillspike").a(CreativeModeTab.c);
    }

    public void init()
    {
        this.registerBlocks();
        this.addNames();
        this.addRecipes();
    }

    void registerBlocks()
    {
        GameRegistry.registerBlock(this.blockglowflower);
        GameRegistry.registerBlock(this.blockpreglowflower);
        GameRegistry.registerBlock(this.blockevilflower);
        GameRegistry.registerBlock(this.blockairflower);
        GameRegistry.registerBlock(this.blockbeanstalk);
        GameRegistry.registerBlock(this.blockpod);
        GameRegistry.registerBlock(this.blockbeanplant);
        GameRegistry.registerBlock(this.blockbeansprout);
        GameRegistry.registerBlock(this.blockpitcherplant);
        GameRegistry.registerBlock(this.blockbonefinger);
        GameRegistry.registerBlock(this.blocklichen);
        GameRegistry.registerBlock(this.blockcreepara);
        GameRegistry.registerBlock(this.blockpricklypear);
        GameRegistry.registerBlock(this.blockfireflower);
        GameRegistry.registerBlock(this.blockdawnflower);
        GameRegistry.registerBlock(this.blockberrybush);
        GameRegistry.registerBlock(this.blocklotus);
        GameRegistry.registerBlock(this.blocklily);
        GameRegistry.registerBlock(this.blockgildedlily);
        GameRegistry.registerBlock(this.blocksmallgildedlily);
        GameRegistry.registerBlock(this.blockfrozennetherrack);
        GameRegistry.registerBlock(this.blockchillspike);
    }

    void addNames()
    {
        LanguageRegistry.addName(this.blockglowflower, "Glow Flower");
        LanguageRegistry.addName(this.blockpreglowflower, "Non-Glowing Glow Flower");
        LanguageRegistry.addName(this.blockairflower, "Air Flower");
        LanguageRegistry.addName(this.blockpitcherplant, "Pitcher Plant");
        LanguageRegistry.addName(this.blockcreepara, "Creepara");
        LanguageRegistry.addName(this.blockpricklypear, "Prickly Pear");
        LanguageRegistry.addName(this.blockfireflower, "Fire Flower");
        LanguageRegistry.addName(this.blockdawnflower, "Dawnflower");
        LanguageRegistry.addName(this.itemlichen, "Lichen");
        LanguageRegistry.addName(this.itemroastedlichen, "Roasted Lichen");
        LanguageRegistry.addName(this.itemmagicbean, "Magic Bean");
        LanguageRegistry.addName(this.itemlessermagicbean, "Lesser Magic Bean");
        LanguageRegistry.addName(this.itemevilflowerpetal, "Evil Flower Petal");
        LanguageRegistry.addName(this.itemanimationessence, "Magic Powder");
        LanguageRegistry.addName(this.itembean, "Bean");
        LanguageRegistry.addName(this.itembeanstew, "Bean Stew");
        LanguageRegistry.addName(this.itemboneseed, "Boneseed");
        LanguageRegistry.addName(this.itemfirelauncher, "Firelauncher");
        LanguageRegistry.addName(this.itemrainstick, "Rainstick");
        LanguageRegistry.addName(this.itemberry, "Berry");
        LanguageRegistry.addName(this.itemlotusblossom, "Lotus Blossom");
        LanguageRegistry.addName(this.itemberrypie, "Berry Pie");
        LanguageRegistry.addName(this.itemlilyseeds, "Lily Seeds");
        LanguageRegistry.addName(this.itemgildedlilyseeds, "Gilded Lily Seeds");
        LanguageRegistry.addName(this.blockevilflower, "Evil Flower");
        LanguageRegistry.addName(this.blockbeanplant, "Bean Plant");
        LanguageRegistry.addName(this.blockbeansprout, "Bean Sprout");
        LanguageRegistry.addName(this.blockbonefinger, "Bonefinger");
        LanguageRegistry.addName(this.blocklichen, "Lichen");
        LanguageRegistry.addName(this.blocklily, "Lily");
        LanguageRegistry.addName(this.blockgildedlily, "Gilded Lily");
        LanguageRegistry.addName(this.blocksmallgildedlily, "Small Gilded Lily");
        LanguageRegistry.addName(this.blocklotus, "Lotus");
        LanguageRegistry.addName(this.blockberrybush, "Berry Bush");
        LanguageRegistry.addName(this.itemgoldenshears, "Golden Shears");
        LanguageRegistry.addName(this.blockfrozennetherrack, "Frozen Netherrack");
        LanguageRegistry.addName(this.blockchillspike, "Chillspike");
    }

    void addRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(this.itembeanstew, 1), new Object[] {" O ", "&&&", " # ", '#', Item.MUSHROOM_SOUP, 'O', Item.WHEAT, '&', this.itembean});
        GameRegistry.addRecipe(new ItemStack(this.itembeanstew, 1), new Object[] {"&&&", " O ", " # ", '#', Item.MUSHROOM_SOUP, 'O', Item.WHEAT, '&', this.itembean});
        GameRegistry.addRecipe(new ItemStack(this.itemberrypie, 1), new Object[] {"&&&", "XOX", " # ", '#', Item.BOWL, 'X', this.itemberry, 'O', Item.SUGAR, '&', Item.WHEAT});
        GameRegistry.addRecipe(new ItemStack(this.itemanimationessence, 1), new Object[] {"###", "###", "###", '#', this.itemevilflowerpetal});
        GameRegistry.addRecipe(new ItemStack(this.itemlessermagicbean, 1), new Object[] {"###", "#O#", "###", '#', Item.GOLD_NUGGET, 'O', this.itembean});
        GameRegistry.addRecipe(new ItemStack(this.itemgildedlilyseeds, 1), new Object[] {"###", "#O#", "###", '#', Item.GOLD_NUGGET, 'O', this.itemlilyseeds});
        GameRegistry.addRecipe(new ItemStack(this.itemfirelauncher, 1), new Object[] {"#", "O", 'O', Item.STICK, '#', this.blockfireflower});
        GameRegistry.addRecipe(new ItemStack(this.itemrainstick, 1), new Object[] {"#", "O", 'O', Item.STICK, '#', this.blockairflower});
        GameRegistry.addRecipe(new ItemStack(this.itemgoldenshears, 1), new Object[] {" #", "# ", '#', Item.GOLD_INGOT});
        GameRegistry.addShapelessRecipe(new ItemStack(this.itemmagicbean, 1), new Object[] {this.itemanimationessence, this.itembean});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.INK_SACK, 3, 5), new Object[] {this.blockdawnflower});
        GameRegistry.addShapelessRecipe(new ItemStack(Item.WATER_BUCKET, 1), new Object[] {this.blockpricklypear, Item.BUCKET});
        GameRegistry.addSmelting(this.itemlichen.id, new ItemStack(this.itemroastedlichen, 1), 0.1F);
    }
}
