package com.github.newhorizons.util.thaumcraft;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants.NBT;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.items.consumables.ItemPhial;
import thaumcraft.common.items.resources.ItemCrystalEssence;

public class AspectUtil {

	public static boolean containsAll(AspectList list, AspectList aspects){
		return getMissing(list, aspects).visSize() == 0;
	}

	public static AspectList getMissing(AspectList list, AspectList required){
		AspectList al = new AspectList();
		for(Aspect a : required.getAspects())
			if(list.getAmount(a) < required.getAmount(a))
				al.add(a, required.getAmount(a) - list.getAmount(a));
		return al;
	}


	public static ItemStack crystalEssence(Aspect a){
		return crystalEssence(a, 1);
	}

	public static ItemStack phial(Aspect a){
		return phial(a, 1);
	}

	public static ItemStack phial(Aspect a, int count){
		return phial(a, count, 10);
	}



	public static ItemStack phial(Aspect a, int count, int aspectPerPhial){
		if(a == null)
			return new ItemStack(ItemsTC.phial, count, 0);
		ItemStack i = new ItemStack(ItemsTC.phial, count, 1);
		((ItemPhial) ItemsTC.phial).setAspects(i, new AspectList().add(a, aspectPerPhial));
		return i;
	}

	public static ItemStack crystalEssence(Aspect a, int count){
		ItemStack is = new ItemStack(ItemsTC.crystalEssence, count);
		((ItemCrystalEssence) ItemsTC.crystalEssence).setAspects(is, new AspectList().add(a, 1));
		return is;
	}


	public static Aspect getAspectFromCrystalBlockStack(ItemStack is){
		if(is.hasTagCompound() && is.getTagCompound().hasKey("Aspect", NBT.TAG_STRING))
		{
			Aspect a = Aspect.getAspect(is.getTagCompound().getString("Aspect"));
			if(a != null)
				return a;
		}
		ArrayList<Aspect> al = new ArrayList<Aspect>(Aspect.aspects.values());
		return al.get((int) (System.currentTimeMillis() % (al.size() * 1000L) / 1000));
	}

	public static NBTTagCompound writeALToNBT(AspectList list, NBTTagCompound nbt)
	{
		if(list != null)
			list.writeToNBT(nbt);
		return nbt;
	}

	public static AspectList primals(int i)
	{
		return new AspectList().add(Aspect.AIR, i).add(Aspect.WATER, i).add(Aspect.ORDER, i).add(Aspect.ENTROPY, i).add(Aspect.FIRE, i).add(Aspect.EARTH, i);
	}


}
