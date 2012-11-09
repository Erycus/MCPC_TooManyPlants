package com.benzrf.toomanyplants;

import net.minecraft.server.EntityHuman;
import net.minecraft.server.ItemFood;
import net.minecraft.server.ItemStack;
import net.minecraft.server.MobEffect;
import net.minecraft.server.World;

public class ItemBerryPie extends ItemFood
{
    int i1;
    int i2;
    int i3;

    protected ItemBerryPie(int var1, int var2, int var3, int var4)
    {
        super(var1, 1, 0.3F, false);
        this.d(1);
        this.i1 = var2;
        this.i2 = var3;
        this.i3 = var4;
    }

    public ItemStack b(ItemStack var1, World var2, EntityHuman var3)
    {
        if (var1.getData() > 1)
        {
            --var1.count;
        }
        else
        {
            var1.setData(var1.getData() + 1);
        }

        var3.getFoodData().a(this);
        var3.heal(2);
        var3.addEffect(new MobEffect(1, 1800, 1));
        var2.makeSound(var3, "random.burp", 0.5F, var2.random.nextFloat() * 0.1F + 0.9F);
        return var1;
    }

    public int b(int var1)
    {
        return var1 == 0 ? this.i1 : (var1 == 1 ? this.i2 : this.i3);
    }

    public String getTextureFile()
    {
        return "/com/benzrf/toomanyplants/resources/plantssheet.png";
    }
}
