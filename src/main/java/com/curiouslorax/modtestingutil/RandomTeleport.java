package com.curiouslorax.modtestingutil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class RandomTeleport implements ICommand{
	public static final int maxX = 10000000;
	public static final int maxZ = 10000000;
	public static final int minX = -10000000;
	public static final int minZ = -10000000;

	private List<String> aliases = new ArrayList<String>();

	public RandomTeleport() {
		aliases.add("randomteleport");
		aliases.add("rt");
	}

	@Override
	public String getName() {
		return "Random Teleport";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/randomteleport";
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
		if (args.length != 0) {
			sendErrorMessage(sender, "Invalid number of arguments!");
			return;
		}
		int x = ThreadLocalRandom.current().nextInt(minX, maxX + 1);
		int z = ThreadLocalRandom.current().nextInt(minZ, maxZ + 1);
		int y = 0;
		BlockPos pos = new BlockPos(x,y,z);

		BlockPos landing = server.getWorld(0).getTopSolidOrLiquidBlock(pos);
		EntityPlayer player = (EntityPlayer) sender;
		player.setPosition(landing.getX(), landing.getY()+1, landing.getZ());
		
	}

	private void sendErrorMessage(ICommandSender sender, String message) {
		sender.sendMessage(new TextComponentString(
				TextFormatting.DARK_RED + message));
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) { 
		return sender instanceof EntityPlayer;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender,
			String[] args, BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}
}
