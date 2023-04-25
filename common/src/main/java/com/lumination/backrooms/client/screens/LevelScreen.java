package com.lumination.backrooms.client.screens;

import com.lumaa.libu.util.Color;
import com.lumination.backrooms.levels.Backroom;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class LevelScreen extends Screen {
    public Text info;
    public Backroom level;
    private MultilineText text = MultilineText.EMPTY;

    public LevelScreen(Backroom level) {
        super(Text.translatable("mod.backrooms.name"));
        this.level = level;
        if (this.level.isBackroom()) {
            this.info = Text.translatable(String.format("levels.backrooms.level_%s.details", level.level));
        } else {
            this.info = Text.translatable("levels.backrooms.overworld.details");
        }
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        if (this.level.isBackroom()) {
            this.info = level.getLevelDetails();
        } else {
            this.info = Text.translatable("levels.backrooms.overworld.details");
        }
        renderBackground(matrices);
        matrices.push();
        matrices.scale(2.0F, 2.0F, 2.0F);
        drawCenteredTextWithShadow(matrices, this.textRenderer, this.level.getName(), this.width / 2 / 2, 30, Color.white);
        matrices.pop();

        this.text = MultilineText.create(this.textRenderer, this.info, this.width / 2);
        this.text.drawCenterWithShadow(matrices, this.width / 2, this.height / 2 + 30, 20, Color.white);
    }


    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
