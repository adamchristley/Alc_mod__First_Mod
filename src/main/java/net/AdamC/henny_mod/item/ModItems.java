package net.AdamC.henny_mod.item;

import net.AdamC.henny_mod.HennyMod;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HennyMod.MOD_ID);


    public static final RegistryObject<Item> HENNY = ITEMS.register("henny",
            () -> new Item(new Item.Properties().stacksTo(10000)
                    .food(new FoodProperties.Builder()
                        .nutrition(1) //adds a value of 1 nutritional level to the item
                        .saturationMod(0.1f) //0.1 saturation level
                        .alwaysEat() //can use this item whether you're hungry or not
                        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 2), 1.0f) //adds a damage boost for 30 seconds 3 strength
                        .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 10000, 3), 0.1f) //10% chance to add a hero of the village boost
                        .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 600, 0), 0.5f) //50% chance to add blindness effect upon consumption
                        .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 600, 1), 1.0f) //adds glowing effect when consumed for 30 seconds
                        .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 1), 1.0f) //gives absorption statues for 30 seconds
                        .build()) //builds item or completes item
                    .rarity(Rarity.RARE))); //gives it the rare item value

    public static void register(IEventBus eventbus)
    {
        ITEMS.register(eventbus); //adds to the event bus so mod picks up this mod when forge runs its algorithm
    }
}
