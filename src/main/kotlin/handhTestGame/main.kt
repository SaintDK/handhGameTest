import kotlin.random.Random

fun main() {
    val player = Player(20, 7, 30)
    val monster = Monster(25, 5, 25, 1..6)

    while (player.isAlive && monster.isAlive) {
        if (player.isAlive && Random.nextDouble() < 0.3) {
            player.heal()
        }
        player.attack(monster)
        if (monster.isAlive) {
            monster.attack(player)
        }
    }

    println(if (player.isAlive) "Поздравляю, вы выиграли!" else "Вы проиграли.")
}

