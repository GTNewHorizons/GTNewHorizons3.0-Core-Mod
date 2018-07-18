package com.github.newhorizons.ASM;

import com.github.newhorizons.util.libs.Refstrings;
import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ASMCore extends DummyModContainer {

    public ASMCore() {
        super(new ModMetadata());
        ModMetadata metadata = getMetadata();
        metadata.modId = Refstrings.MODID+"ASM";
        metadata.name = Refstrings.NAME+"ASM";
        metadata.version = "0.0.1";
        metadata.authorList.add("bartimaeusnek");
        metadata.dependants = getDependants();
    }

    private Logger logger = LogManager.getLogger(Refstrings.MODID+"ASM");

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
}
