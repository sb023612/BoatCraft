package com.github.AbrarSyed.SeaCraft.client;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.github.AbrarSyed.SeaCraft.ContainerBoatFurnace;
import com.github.AbrarSyed.SeaCraft.Boats.EntityBoatFurnace;
import com.github.AbrarSyed.SeaCraft.network.PacketSC0MountEntity;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBoatFurnace extends GuiContainer
{
	private EntityBoatFurnace	furnace;

	public GuiBoatFurnace(InventoryPlayer player, EntityBoatFurnace boat)
	{
		super(new ContainerBoatFurnace(player, boat));
		this.furnace = boat;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2, y = (height - ySize) / 2;
		int bw = xSize - 22;
		buttonList.add(new GuiButton(1, x + 130, y + 10, bw / 4, 20, "Mount"));
		buttonList.add(new GuiButton(2, x + 125, y + 30, bw / 3, 20, "UnMount"));
		buttonList.add(new GuiButton(3, x + 75, y + 58, bw / 4, 20, "Start"));
		buttonList.add(new GuiButton(4, x + 125, y + 58, bw / 4, 20, "Stop"));
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
			case 1: // mount
				PacketDispatcher.sendPacketToServer(new PacketSC0MountEntity(furnace, true).getPacket250());
				break;
			case 2: // unmount
				PacketDispatcher.sendPacketToServer(new PacketSC0MountEntity(furnace, false).getPacket250());
				break;
			case 3: // start
				break;
			case 4: // stop
				break;
		}
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String s = StatCollector.translateToLocal(this.furnace.getInvName());
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture("/mods/SeaCraft/textures/guis/boatFurnace.png");
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;

		if (this.furnace.isBurning())
		{
			i1 = this.furnace.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 35, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}

		i1 = this.furnace.getCookProgressScaled(24);
		this.drawTexturedModalRect(k + 52, l + 34, 176, 14, i1 + 1, 16);
	}
}
