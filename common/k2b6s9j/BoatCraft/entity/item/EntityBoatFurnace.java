package k2b6s9j.BoatCraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBoatFurnace extends EntityCustomBoat {
	
	public EntityBoatFurnace(World par1World)
    {
        super(par1World);
    }

    public EntityBoatFurnace(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    public Block getDefaultDisplayTile()
    {
        return Block.furnaceBurning;
    }

    public int getDefaultDisplayTileData()
    {
        return 2;
    }
    
    public boolean func_130002_c(EntityPlayer player)
    {
    	//Do not mount this boat on right click!
        return false;
    }
}
