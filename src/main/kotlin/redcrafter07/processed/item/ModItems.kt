package redcrafter07.processed.item

import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import redcrafter07.processed.ProcessedMod
import java.util.function.Supplier


//looked at the wrong file lmao

// but you gotta say this is way easier than normal java

//your implementation is correct fyi
object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(ProcessedMod.ID);

    val BLITZ_ORB = registerItem("blitz_orb") { Item(Item.Properties()) };

    fun <T: Item> registerItem(name: String, item: Supplier<T>): DeferredItem<T> {
        return ITEMS.register(name, item);
    }
}