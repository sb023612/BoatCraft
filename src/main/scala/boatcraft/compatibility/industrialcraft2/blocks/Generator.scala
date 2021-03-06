package boatcraft.compatibility.industrialcraft2.blocks

import boatcraft.api.boat.EntityCustomBoat
import boatcraft.api.traits.Block
import ic2.api.item.IC2Items
import ic2.core.block.generator.tileentity.TileEntityGenerator
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemBlock
import net.minecraft.nbt.NBTTagCompound

object Generator extends Block {
	override def getUnlocalizedName = "Generator"

  override def getLocalizedName = "industrialcraft2.blocks.generator.name"

	override def getContent = IC2Items.getItem("generator")

	override def getBlock = getContent.getItem.asInstanceOf[ItemBlock].field_150939_a

	override def getBlockData(boat: EntityCustomBoat): AnyRef = new Inventory(boat)

	override def readStateFromNBT(boat: EntityCustomBoat, tag: NBTTagCompound) =
		boat.getBlockData.asInstanceOf[Inventory] readFromNBT tag

	override def writeStateToNBT(boat: EntityCustomBoat, tag: NBTTagCompound) =
		boat.getBlockData.asInstanceOf[Inventory] writeToNBT tag

	private[industrialcraft2] class Inventory(boat: EntityCustomBoat) extends TileEntityGenerator {
		worldObj = boat.worldObj
	}

}