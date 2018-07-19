package com.github.newhorizons.util.thaumcraft;

import net.minecraft.block.Block;
import thaumcraft.api.research.theorycraft.ITheorycraftAid;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

public class AidBase implements ITheorycraftAid {

	Block block;
    Class<TheorycraftCard>[] cards;

	public AidBase(Block block, Class<TheorycraftCard>[] cards) {
		this.block = block;
		this.cards = cards;
	}

	@Override
	public Object getAidObject() {
		return block;
	}

	@Override
	public Class<TheorycraftCard>[] getCards() {
		return cards;
	}

}
