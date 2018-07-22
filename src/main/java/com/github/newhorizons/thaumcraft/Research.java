package com.github.newhorizons.thaumcraft;

import com.github.newhorizons.util.libs.Refstrings;
import com.github.newhorizons.util.thaumcraft.AspectUtil;
import com.github.newhorizons.util.thaumcraft.GTNHResearchHelper;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.api.research.ResearchStage.Knowledge;
import thaumcraft.common.lib.research.theorycraft.CardBeacon;

public class Research {

	public static final String catNameBotania = "BOTANIA";
	public static final String catNameBloodmagic = "BLOODMAGIC";
	public static final String catNameGTNH = "GTNH";

	public static final ResourceLocation backoverlay = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");

	public static final ResourceLocation iconBotania = new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/icon/icon_botania.png");
	public static final ResourceLocation backBotania = new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/tab/tab_botania.jpg");

	public static final ResourceLocation iconBloodmagic = new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/icon/icon_bloodmagic.png");
	public static final ResourceLocation backBloodmagic = new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/tab/tab_bloodmagic.jpg");

	public static final ResourceLocation iconGTNH = new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/icon/icon_gtnh.png");
	public static final ResourceLocation backGTNH = new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/tab/tab_gtnh.jpg");

	public static void addResearch() {
		createBotaniaResearch();
        createBloodyResearch();
        createGTNHResearch();
	}

    private static ResearchCategory catBotania;
    private static ResearchCategory catBloodmagic;
    private static ResearchCategory catGTNH;

 private static void createBotaniaResearch() {

	catBotania = ResearchCategories.registerCategory(catNameBotania, null, null, iconBotania, backBotania);

	ResearchStage[] stages = new ResearchStage[]{
			new GTNHResearchHelper.RSB()
			.setConsumedItems(new ItemStack(Items.BOOK), AspectUtil.crystalEssence(Aspect.MIND), AspectUtil.crystalEssence(Aspect.MAGIC))
			.setKnow(new Knowledge(EnumKnowledgeType.THEORY, catBotania, 4))
			.setText("research_stage."+Refstrings.MODID+":test.0")
			.build(),
			new GTNHResearchHelper.RSB()
			.setText("research_stage."+Refstrings.MODID+":test.1")
            .setRecipes("botania:lexicon").build()
	};

	// Botania Research, maybe usable for something
	GTNHResearchHelper.makeBotaniaResearch("LEXICON", "Lexica Botania", 0, 0, getModItem("botania", "lexicon", 1, 0), stages, null);
	GTNHResearchHelper.makeBotaniaResearch("EREBUS", "The Erebus", 0, 2, getModItem("erebus", "gaean_keystone", 1, 0), stages, new String[] {"LEXICON"});
	GTNHResearchHelper.makeBotaniaResearch("EREBUSKEY", "Staff of Gaea", -1, 4, getModItem("erebus", "portal_activator", 1, 0), stages, new String[] {"EREBUS"});
	GTNHResearchHelper.makeBotaniaResearch("APOTHECARY", "Petal Apothecary", 1, 4, getModItem("botania", "altar", 1, 0), stages, new String[] {"EREBUS"});
	GTNHResearchHelper.makeBotaniaResearch("FLOWERCREATION", "Flower Creation", 2, 6, getModItem("botania", "flower", 1, 9), stages, new String[] {"APOTHECARY"});

	GTNHResearchHelper.makeBotaniaResearch("PUREDAISY", "Pure Daisy", 0, -2, getFlower("puredaisy"), stages, new String[] {"LEXICON"});
	GTNHResearchHelper.makeBotaniaResearch("MANASPREADER", "Mana Spreader", -2,-4, getModItem("botania", "spreader", 1, 0), stages, new String[] {"PUREDAISY"});
	GTNHResearchHelper.makeBotaniaResearch("REDMANSPREADER", "Redstone Mana Spreader", -4,-4, getModItem("botania", "spreader", 1, 1), stages, new String[] {"MANASPREADER"});

	GTNHResearchHelper.makeBotaniaResearch("DILUTEDMANAPOOL", "Diluted Mana Pool", 2,-4, getModItem("botania", "pool", 1, 2), stages, new String[] {"PUREDAISY"});
	GTNHResearchHelper.makeBotaniaResearch("MANASTAR", "Mana Star", 1,-5, getFlower("manastar"), stages, new String[] {"DILUTEDMANAPOOL"});
	GTNHResearchHelper.makeBotaniaResearch("MANAPOOL", "Mana Pool", 2,-6, getModItem("botania", "pool", 1, 0), stages, new String[] {"DILUTEDMANAPOOL"});
	GTNHResearchHelper.makeBotaniaResearch("MANAVOID", "Mana Void",4,-5, getModItem("botania", "manavoid", 1, 0), stages, new String[] {"MANAPOOL"});
	GTNHResearchHelper.makeBotaniaResearch("MANADISTRIBUTOR", "Mana Distributor", 5,-6, getModItem("botania", "distributor", 1, 0), stages, new String[] {"MANAPOOL"});
	GTNHResearchHelper.makeBotaniaResearch("MANADETECTOR", "Mana Detector" ,4,-7, getModItem("botania", "manadetector", 1, 0), stages, new String[] {"MANAPOOL"});

	GTNHResearchHelper.makeBotaniaResearch("RUNICALTAR", "Runic Altar", 0,-7, getModItem("botania", "runealtar", 1, 0), stages, new String[] {"MANAPOOL","MANASPREADER"});
	GTNHResearchHelper.makeBotaniaResearch("TERRASTEEL", "Terrasteel",-2,-8, getModItem("botania", "terraplate", 1, 0), stages, new String[] {"RUNICALTAR"});
	GTNHResearchHelper.makeBotaniaResearch("SPARK", "Sparks",-1,-9, getModItem("botania", "spark", 1, 0), stages, new String[] {"TERRASTEEL"});
	GTNHResearchHelper.makeBotaniaResearch("ELVENPORTAL", "Portal to Alfheim", -4,-7, getModItem("botania", "alfheimportal", 1, 0), stages, new String[] {"TERRASTEEL"});

	GTNHResearchHelper.makeBotaniaResearch("ELVENMANASPREADER", "Elven Mana Spreader", -2,-6, getModItem("botania", "spreader", 1, 2), stages, new String[] {"ELVENPORTAL","MANASPREADER"});

	GTNHResearchHelper.makeBotaniaResearch("HYDROANGEAS", "Hydroangeas", -3, -2, getFlower("hydroangeas"), stages, new String[] {"PUREDAISY"});
	GTNHResearchHelper.makeBotaniaResearch("ENDOFLAME", "Endoflame",-5, -1, getFlower("endoflame"), stages, new String[] {"HYDROANGEAS"});

	GTNHResearchHelper.makeBotaniaResearch("ARCANEROSE", "Rosa Arcana", -6, 1, getFlower("arcanerose"), stages, new String[] {"ENDOFLAME"});
	GTNHResearchHelper.makeBotaniaResearch("THERMALILY", "Thermallily", -5, 2, getFlower("thermalily"), stages, new String[] {"ENDOFLAME"});
	GTNHResearchHelper.makeBotaniaResearch("NARSLIMMUS", "Narslimus",-7, 3, getFlower("narslimmus"), stages, new String[] {"THERMALILY","ARCANEROSE"});
	GTNHResearchHelper.makeBotaniaResearch("GOURMARYLLIS", "Gourmaryllis",-8, 4, getFlower("gourmaryllis"), stages, new String[] {"THERMALILY","ARCANEROSE"});

 }

 private static void createBloodyResearch() {

	catBloodmagic = ResearchCategories.registerCategory(catNameBloodmagic, null, null, iconBloodmagic, backBloodmagic);

	ResearchStage[] stages = new ResearchStage[]{
			new GTNHResearchHelper.RSB()
			.setConsumedItems(new ItemStack(Items.BOOK), AspectUtil.crystalEssence(Aspect.MIND), AspectUtil.crystalEssence(Aspect.PLANT))
			.setKnow(new Knowledge(EnumKnowledgeType.OBSERVATION, catBloodmagic, 4))
			.setText("research_stage."+Refstrings.MODID+":test.0")
			.build(),
			new GTNHResearchHelper.RSB()
			.setText("research_stage."+Refstrings.MODID+":test.1")
            .setRecipes("botania:lexicon").build()
	};

	GTNHResearchHelper.makeBloodyResearch("BLOODALTAR", "Blood Altar", 0, 0, null, stages, null);

 }

 private static void createGTNHResearch() {

	catGTNH = ResearchCategories.registerCategory(catNameGTNH, null, null, iconGTNH, backGTNH, backoverlay);

	ResearchStage[] stages = new ResearchStage[]{
			new GTNHResearchHelper.RSB()
			.setConsumedItems(new ItemStack(Items.BOOK), AspectUtil.crystalEssence(Aspect.MIND), AspectUtil.crystalEssence(Aspect.PLANT))
			.setKnow(new Knowledge(EnumKnowledgeType.OBSERVATION, catGTNH, 4))
			.setText("research_stage."+Refstrings.MODID+":test.0")
			.build()
	};

    //Enchanting Table
	GTNHResearchHelper.makeGTNHResearch("ENCHANTINGTABLE", "Enchantment Table", 0, 0, new ItemStack(Blocks.ENCHANTING_TABLE,1,0), stages, null);

	// Test for Custom Helps
	GTNHResearchHelper.createAid(Blocks.SEA_LANTERN, new Class[] {CardBeacon.class});
 }

 private static ItemStack getModItem(String modid, String name, int amount, int meta){
	 return GameRegistry.makeItemStack(modid + ":" + name, meta, amount, null);
 }

 private static ItemStack getFlower(String type){
	ItemStack ret = null;
	 if(Loader.isModLoaded("botania")) {
	  NBTTagCompound nbt = new NBTTagCompound();
	  nbt.setString("type", type);
	  ret = GameRegistry.makeItemStack("botania:specialflower", 1, 0, null);
	  if (ret != null)
	  	ret.setTagCompound(nbt);
	 }
	 return ret;
 }

}
