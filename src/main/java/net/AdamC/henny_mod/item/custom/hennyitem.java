//code to connect the package with the rest of the file
package net.AdamC.henny_mod.item.custom;
//all of the imports

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class hennyitem extends Item //this class and java class it resides in extends the item
{
    public hennyitem(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) //when item is in hand add night vision effect
    {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) //checking if item is in main hand and when it is distributes mob effect
        {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 1)); //the code for actually allocating mob effect to player
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) //the hovertext class for the item
    {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("A real mans drink.").withStyle(ChatFormatting.RED)); //adds a text when shift is pressed to display
        } else {
            components.add(Component.literal("Press SHIFT for the truth!").withStyle(ChatFormatting.GOLD)); //when shift isn't pressed and item is hovered this text is displayed
        }

        super.appendHoverText(stack, level, components, flag);
    }
}