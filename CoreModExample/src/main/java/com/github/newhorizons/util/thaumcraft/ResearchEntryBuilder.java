package com.github.newhorizons.util.thaumcraft;

import java.lang.reflect.Method;

import net.minecraft.item.ItemStack;
import thaumcraft.api.research.ResearchAddendum;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchEntry;
import thaumcraft.api.research.ResearchEntry.EnumResearchMeta;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.api.research.ResearchStage.Knowledge;
import thaumcraft.common.lib.research.ResearchManager;

public class ResearchEntryBuilder {

	private ResearchEntry entry = new ResearchEntry();

	public static ResearchEntryBuilder start()
	{
		return new ResearchEntryBuilder();
	}

	public ResearchEntryBuilder setBaseInfo(String key, String category, String name, int x, int y, Object... icons)
	{
		return setKey(key).setCategory(category).setName(name).setPosition(x, y).setIcons(icons);
	}

	public ResearchEntryBuilder setKey(String key)
	{
		entry.setKey(key);
		return this;
	}

	public ResearchEntryBuilder setCategory(String category)
	{
		entry.setCategory(category);
		return this;
	}

	public ResearchEntryBuilder setPosition(int x, int y)
	{
		entry.setDisplayColumn(x);
		entry.setDisplayRow(y);
		return this;
	}

	public ResearchEntryBuilder setIcons(Object... icons)
	{
		entry.setIcons(icons);
		return this;
	}

	public ResearchEntryBuilder setMeta(EnumResearchMeta... metas)
	{
		entry.setMeta(metas);
		return this;
	}

	public ResearchEntryBuilder setAddenda(ResearchAddendum... addenda)
	{
		entry.setAddenda(addenda);
		return this;
	}

	public ResearchEntryBuilder setName(String name)
	{
		entry.setName(name);
		return this;
	}

	public ResearchEntryBuilder setParents(String... parents)
	{
		entry.setParents(parents);
		return this;
	}

	public ResearchEntryBuilder setRewardItems(ItemStack... rewards)
	{
		entry.setRewardItem(rewards);
		return this;
	}

	public ResearchEntryBuilder setRewardKnow(Knowledge... rewardKnow)
	{
		entry.setRewardKnow(rewardKnow);
		return this;
	}

	public ResearchEntryBuilder setSiblings(String... siblings)
	{
		entry.setSiblings(siblings);
		return this;
	}

	public ResearchEntryBuilder setStages(ResearchStage... stages)
	{
		entry.setStages(stages);
		return this;
	}

	public ResearchEntry buildAndRegister()
	{
		if(entry == null)
			throw new IllegalStateException("Already built!");
		ResearchEntry re = entry;
		entry = null;
		addResearchToCategory(re);
		return re;
	}

	private static Method addResearchToCategory = null;

	private static void addResearchToCategory(ResearchEntry ri)
	{
		if(addResearchToCategory == null)
			try
			{
				addResearchToCategory = ResearchManager.class.getDeclaredMethod("addResearchToCategory", ResearchEntry.class);
				addResearchToCategory.setAccessible(true);
			} catch(NoSuchMethodException | SecurityException e)
			{
				e.printStackTrace();
			}

		try
		{
			addResearchToCategory.invoke(null, ri);
		} catch(Throwable e)
		{
			e.printStackTrace();
		}
	}



}
