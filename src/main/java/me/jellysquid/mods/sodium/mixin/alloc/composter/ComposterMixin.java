package me.jellysquid.mods.sodium.mixin.alloc.composter;

import me.jellysquid.mods.lithium.common.util.ArrayConstants;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

public class ComposterMixin {

    @Mixin(targets = "net.minecraft.block.ComposterBlock$PartialInventory")
    public static abstract class ComposterBlockComposterInventoryMixin implements ISidedInventory {
        /**
         * @author 2No2Name
         * @reason avoid allocation
         */
        @Overwrite
        public int[] getSlotsForFace(Direction side) {
            return side == Direction.UP ? ArrayConstants.ZERO : ArrayConstants.EMPTY;
        }
    }

    @Mixin(targets = "net.minecraft.block.ComposterBlock$EmptyInventory")
    public static abstract class ComposterBlockDummyInventoryMixin implements ISidedInventory {
        /**
         * @author 2No2Name
         * @reason avoid allocation
         */
        @Overwrite
        public int[] getSlotsForFace(Direction side) {
            return ArrayConstants.EMPTY;
        }
    }

    @Mixin(targets = "net.minecraft.block.ComposterBlock$FullInventory")
    public static abstract class ComposterBlockFullComposterInventoryMixin implements ISidedInventory {
        /**
         * @author 2No2Name
         * @reason avoid allocation
         */
        @Overwrite
        public int[] getSlotsForFace(Direction side) {
            return side == Direction.DOWN ? ArrayConstants.ZERO : ArrayConstants.EMPTY;
        }
    }
}
