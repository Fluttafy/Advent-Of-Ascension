package net.tslat.aoa3.block.generation.misc;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.tslat.aoa3.block.BasicBlock;
import net.tslat.aoa3.entity.mobs.deeplands.EntityNipper;

import javax.annotation.Nullable;
import java.util.Random;

public class DeeplandsTrapNipper extends BasicBlock {
	public DeeplandsTrapNipper() {
		super("DeeplandsTrapNipper", "deeplands_trap_nipper", Material.ROCK);
		setHardness(3f);
		setResistance(10.0f);
		setSoundType(SoundType.STONE);
		setCreativeTab(null);
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return FULL_BLOCK_AABB;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) {
			if (!world.isRemote) {
				EntityNipper nipper = new EntityNipper(world);

				nipper.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
				world.spawnEntity(nipper);
			}
		}
	}
}
