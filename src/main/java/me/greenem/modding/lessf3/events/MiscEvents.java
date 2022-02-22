package me.greenem.modding.lessf3.events;

import me.greenem.modding.lessf3.implementations.Menu1;
import me.greenem.modding.lessf3.main.LessF3;
import me.greenem.modding.lessf3.registration.KeyInit;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.MenuProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static me.greenem.general.Values.*;

@Mod.EventBusSubscriber(modid = LessF3.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MiscEvents {

    @SubscribeEvent
    public static void onEveryTick(TickEvent.ClientTickEvent e) {
        detectBadKeybind();
    }

    public static void detectBadKeybind() {
        if(KeyInit.shortF3.getKey().getValue()==officialF3ButtonCode) {
            if(!warnedAboutBadKeybindAlready) {
                if(Minecraft.getInstance().player != null) {
                    String translatedMessage = I18n.get("less_f3.custom.strings.badkeybind");
                    Minecraft.getInstance().player.displayClientMessage(new TextComponent(ChatFormatting.RED + translatedMessage), false);
                    warnedAboutBadKeybindAlready = true;
                }
            }
        }
        else {
            warnedAboutBadKeybindAlready = false;
        }
    }
}
