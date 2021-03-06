package boatcraft.compatibility.vanilla.materials.wood

import boatcraft.api.traits.Material
import net.minecraft.util.ResourceLocation
import net.minecraft.item.ItemStack
import net.minecraft.init.Blocks
import net.minecraft.init.Items

object OreDict_Wood extends Material {
	override def getTexture =
		new ResourceLocation("minecraft", "textures/entity/boat.png")

	override def getUnlocalizedName = "Wood"

  override def getLocalizedName = "vanilla.materials.wood.oredict.name"

	override def getItem = new ItemStack(Blocks.planks)

	override def getStick = new ItemStack(Items.stick)
}