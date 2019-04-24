package net.nevermine.npc.entity.artistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.nevermine.assist.StringUtil;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Armorizer;
import net.nevermine.npc.entity.EntityNevermineVillager;
import net.nevermine.npc.entity.RestockedRecipe;

import java.util.ArrayList;

public class EntityAnimaMaster extends EntityNevermineVillager {
	private static ArrayList<RestockedRecipe> trades = new ArrayList<RestockedRecipe>();

	public EntityAnimaMaster(final World var1) {
		super(var1);
	}

	public boolean getCanSpawnHere() {
		return worldObj.checkNoEntityCollision(boundingBox) && rand.nextInt(3) == 2 && worldObj.getCollidingBoundingBoxes(this, boundingBox).isEmpty() && !worldObj.isAnyLiquid(boundingBox);
	}

	@Override
	public void interaction(final EntityPlayer p) {
		p.addChatMessage(StringUtil.getLocale("message.dialogue.animaMaster." + rand.nextInt(5)));
	}

	@Override
	public int guiID() {
		return 17;
	}

	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	public void addRecipies(final MerchantRecipeList list) {
		list.add(new RestockedRecipe(new ItemStack(Itemizer.LunaverCoin, 1, 1), new ItemStack(Armorizer.AnimaBoots, 1)));
		list.add(new RestockedRecipe(new ItemStack(Itemizer.LunaverCoin, 1, 1), new ItemStack(Armorizer.AnimaLeggings, 1)));
		list.add(new RestockedRecipe(new ItemStack(Itemizer.LunaverCoin, 1, 1), new ItemStack(Armorizer.AnimaChestplate, 1)));
		list.add(new RestockedRecipe(new ItemStack(Itemizer.LunaverCoin, 1, 1), new ItemStack(Armorizer.AnimaHelmet, 1)));
	}

	@Override
	public String mobName() {
		return "AnimaMaster";
	}

	static {

	}
}