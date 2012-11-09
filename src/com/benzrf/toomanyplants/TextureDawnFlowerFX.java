package com.benzrf.toomanyplants;

import cpw.mods.fml.client.FMLTextureFX;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.server.azc;
import net.minecraftforge.client.ForgeHooksClient;

public class TextureDawnFlowerFX extends FMLTextureFX
{
    byte[] open = new byte[1024];
    byte[] closed = new byte[1024];
    Minecraft m;

    public TextureDawnFlowerFX(int var1, Minecraft var2)
    {
        super(var1);
        this.m = var2;

        try
        {
            BufferedImage var3 = ImageIO.read(this.getClass().getResource("/com/benzrf/toomanyplants/resources/DawnflowerOpen.png"));
            BufferedImage var4 = ImageIO.read(this.getClass().getResource("/com/benzrf/toomanyplants/resources/DawnflowerClosed.png"));

            for (int var8 = 0; var8 <= 15; ++var8)
            {
                for (int var9 = 0; var9 <= 15; ++var9)
                {
                    int var6 = var3.getRGB(var8, var9);
                    int var7 = var4.getRGB(var8, var9);
                    int var5 = (var9 * 16 + var8) * 4;
                    this.open[var5] = (byte)(var6 >> 16 & 255);
                    this.closed[var5] = (byte)(var7 >> 16 & 255);
                    this.open[var5 + 1] = (byte)(var6 >> 8 & 255);
                    this.closed[var5 + 1] = (byte)(var7 >> 8 & 255);
                    this.open[var5 + 2] = (byte)(var6 & 255);
                    this.closed[var5 + 2] = (byte)(var7 & 255);
                    this.open[var5 + 3] = (byte)(var6 >> 24 & 255);
                    this.closed[var5 + 3] = (byte)(var7 >> 24 & 255);
                }
            }

            this.d = this.closed;
        }
        catch (IOException var10)
        {
            var10.printStackTrace();
        }
    }

    public void a(azc var1)
    {
        ForgeHooksClient.bindTexture("/com/benzrf/toomanyplants/resources/plantssheet.png", 0);
    }

    public void a()
    {
        if (this.m.e != null)
        {
            if (this.m.e.getWorldData().g() % 24000L > 13000L)
            {
                this.d = this.closed;
            }
            else
            {
                this.d = this.open;
            }
        }
    }
}
