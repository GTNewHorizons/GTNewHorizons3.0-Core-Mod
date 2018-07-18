package com.github.newhorizons;
import com.github.newhorizons.thaumcraft.Research;
import com.github.newhorizons.util.libs.Refstrings;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Refstrings.MODID,
        name = Refstrings.NAME,
        version = Refstrings.VERSION,
        dependencies="after:thaumcraft"
)
public class Main {

    public static Logger logger = LogManager.getLogger(Refstrings.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	if(Loader.isModLoaded("thaumcraft"))
                Research.addResearch();
    }

}
