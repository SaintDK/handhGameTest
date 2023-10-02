import kotlin.random.Random

class Player(attack: Int, defense: Int, health: Int) : Creature(attack, defense, health) {
    override val name: String = "Игрок"

    private var healingCount = 0

    fun heal() {
        if (health > 0 && healingCount < 4) {
            val maxHealth = 30
            val maxHealing = (maxHealth - health) * 0.3
            val amountToHeal = (maxHealing * Random.nextDouble()).toInt()

            health += amountToHeal
            if (health > maxHealth) {
                health = maxHealth
            }

            healingCount++
            println("$name исцеляется на $amountToHeal здоровья.")
        } else {
            println("$name не может исцеляться сейчас.")
        }
    }

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