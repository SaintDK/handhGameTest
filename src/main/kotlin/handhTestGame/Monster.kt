class Monster(attack: Int, defense: Int, health: Int, override val damageRange: IntRange) :
    Creature(attack, defense, health) {

    override val name: String = "Монстр"

    override fun attack(target: Creature) {
        val attackModifier = attack - target.defense + 1
        val success = rollDice(attackModifier)

        if (success) {
            val damage = damageRange.random()
            target.takeDamage(damage)
            println("$name успешно атакует ${target.name} и наносит $damage урона!")
        } else {
            println("$name не попадает по ${target.name}")
        }
    }
}