package example.bedrockminertutorials;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TutorialWorldGen implements IWorldGenerator {
	private WorldGenerator gen_diamondore_for_dirt;
	private WorldGenerator gen_diamondore_for_grass;
	
	public TutorialWorldGen() {
		this.gen_diamondore_for_dirt = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), 24, BlockMatcher.forBlock(Blocks.DIRT));
		this.gen_diamondore_for_grass = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), 24, BlockMatcher.forBlock(Blocks.GRASS));
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
	
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {

        switch (world.provider.getDimension()) {
        case 0: //Overworld
        	this.runGenerator(this.gen_diamondore_for_dirt, world, random, chunkX, chunkZ, 1000, 0, 120);
        	this.runGenerator(this.gen_diamondore_for_grass, world, random, chunkX, chunkZ, 1000, 0, 120);
            break;
        case -1: //Nether

            break;
        case 1: //End

            break;
        }
    }
    /*
    private WorldGenerator diamond_ore; //Generates Tutorial Ore (used in Overworld)

    public TutorialWorldGen() {
        this.diamond_ore = new WorldGenMinable(Block. .diamond_ore.getDefaultState(), 8);
    }*/

}
