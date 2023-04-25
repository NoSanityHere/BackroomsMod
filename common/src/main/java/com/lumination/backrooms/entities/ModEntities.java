package com.lumination.backrooms.entities;

import com.lumination.backrooms.BackroomsMod;
import com.lumination.backrooms.entities.client.BacteriaRenderer;
import com.lumination.backrooms.entities.mod.BacteriaEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BacteriaEntity> BACTERIA = Registry.register(Registries.ENTITY_TYPE, new Identifier(BackroomsMod.MOD_ID, "bacteria"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BacteriaEntity::new).dimensions(EntityDimensions.fixed(1.4f, 2.7f)).build());

    public static void registerMobs(boolean withAttributes) {
        EntityRendererRegistry.register(ModEntities.BACTERIA, BacteriaRenderer::new);

        if (withAttributes) {
            registerAttributes();
        }
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.BACTERIA, BacteriaEntity.setAttributes());
    }

    public static void registerMobs() {
        registerMobs(true);
    }
}
