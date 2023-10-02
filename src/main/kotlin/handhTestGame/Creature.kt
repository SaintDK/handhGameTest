import kotlin.random.Random

abstract class Creature(val attack: Int, val defense: Int, var health: Int) {
    open val damageRange: IntRange
        get() = 1..6

    abstract val name: String

    val isAlive: Boolean
        get() = health > 0

    abstract fun attack(target: Creature)

    fun takeDamage(damage: Int) {
        if (damage > 0) {
            health -= damage
            if (health < 0) {
                health = 0
            }
        }
    }

    protected fun rollDice(numDice: Int): Boolean {
        var success = false
        repeat(numDice) {
            val roll = Random.nextInt(1, 7)
            if (roll >= 5) {
                success = true
            }
        }
        return success
    }
}