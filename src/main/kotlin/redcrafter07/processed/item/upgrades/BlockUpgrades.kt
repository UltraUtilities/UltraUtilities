package redcrafter07.processed.item.upgrades

enum class BlockUpgrades {
    Speed, Efficiency, Capacity, Range, Energy, AreaOfEffect;

    companion object {
        private var validUpgrades: Array<BlockUpgrades> = entries.toTypedArray()

        fun fromString(string: String): BlockUpgrades {
            return valueOf(string)
        }

        fun fromInt(int: Int): BlockUpgrades {
            return entries[int]
        }

        fun validUpgrades(upgrades: Array<BlockUpgrades>): Array<BlockUpgrades> {
            this.validUpgrades = entries.filter { it !in upgrades }.toTypedArray()
            return entries.filter { it !in upgrades }.toTypedArray()
        }

        fun getItemNameForUpgrade(upgrade: BlockUpgrades): String {
            val uppercaseIndexes =
                upgrade.toString().toCharArray().mapIndexed { index, c -> if (c.isUpperCase()) index else null }
                    .filterNotNull()
            val name = upgrade.toString().toCharArray().toMutableList()

            uppercaseIndexes.forEach { name.add(it, '_') }

            return name.joinToString("").lowercase()
        }
    }

    fun upgradeIsValid(): Boolean {
        return this in validUpgrades
    }

    fun toInt(): Int {
        return entries.indexOf(this)
    }

    fun getItemNameForUpgrade(): String {
        val uppercaseIndexes =
            this.toString().toCharArray().mapIndexed { index, c -> if (c.isUpperCase()) index else null }
                .filterNotNull()
        val name = this.toString().toCharArray().toMutableList()

        uppercaseIndexes.forEach { name.add(it, '_') }

        return name.joinToString("").lowercase()
    }
}