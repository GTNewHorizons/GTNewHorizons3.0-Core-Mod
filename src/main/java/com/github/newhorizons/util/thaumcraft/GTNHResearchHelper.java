package com.github.newhorizons.util.thaumcraft;

import net.minecraft.block.Block;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.api.research.theorycraft.TheorycraftCard;
import thaumcraft.api.research.theorycraft.TheorycraftManager;

public class GTNHResearchHelper {

	private static class REB extends ResearchEntryBuilder{}
	public static class RSB extends ResearchStageBuilder{}
	public static class RAB extends ResearchAddendumBuilder{}



	public static void makeResearch(String tag, String tab, String name, int Xpos, int Ypos, Object icon,ResearchStage[] stages,String[] parents) {
		 ResearchEntryBuilder reb = new REB().setBaseInfo(tag, tab, name, Xpos, Ypos, icon);
		 reb.setStages(stages);
         reb.setParents(parents);
         reb.buildAndRegister();
		}

	public static void makeBotaniaResearch(String tag,String name, int Xpos, int Ypos,Object icon, ResearchStage[] stages, String[] parents) {
			makeResearch(tag, "BOTANIA", name, Xpos, Ypos, icon, stages, parents);
		}

	public static void makeBloodyResearch(String tag,String name, int Xpos, int Ypos,Object icon, ResearchStage[] stages, String[] parents) {
		makeResearch(tag, "BLOODMAGIC",name, Xpos, Ypos, icon, stages, parents);
	}

	public static void makeGTNHResearch(String tag,String name, int Xpos, int Ypos,Object icon, ResearchStage[] stages, String[] parents) {
		makeResearch(tag, "GTNH",name, Xpos, Ypos, icon, stages, parents);
	}

	public static void createAid(Block block, Class<TheorycraftCard>[] cards) {
		if(TheorycraftManager.aids.get(block.getLocalizedName())==null)
         TheorycraftManager.aids.put(block.getLocalizedName(), new AidBase(block, cards));
	}

}
