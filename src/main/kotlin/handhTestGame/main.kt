import kotlin.random.Random

fun main() {
    val maxPlayerHealth = 30
    val percent = 30.0

    val player = Player(20, 7, maxPlayerHealth)
    val monster = Monster(15, 5, 25, 1..6)

    while (player.isAlive && monster.isAlive) {
        if (player.isAlive && player.health < maxPlayerHealth * percent / 100) {
            player.heal()
        }
        player.attack(monster)
        if (monster.isAlive) {
            monster.attack(player)
        }
    }

    println(if (player.isAlive) "Поздравляю, вы выиграли!" else "Вы проиграли.")
}

