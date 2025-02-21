package ru.netology

//
// Задача №1. Максимальное покрытие
/*
Комиссия:
за переводы с карт Mastercard и Maestro - комиссия не берется от 300 рублей до 75000,
            в иных случаях - комиссия 0,6%+20 рублей;
За переводы с карт Visa и Мир - комиссия 0,75%, но минимум 35 рублей;
За переводы на счет VK Pay - комиссия не взмается.

Лимиты:
Максимальная сумма переводов по одной карте - 150000 рублей в сутки и 600000 рублей в месяц
            раздельно на отправку и на получение, комиссия в лимитах не учитывается;
Максиальная сумма переводов со счета VK Pay - 15000 за один раз и 40000 рублей в месяц.
*/

// функция расчёта комиссии
// ====================
fun calculateCommission(cardType: String, amount: Int, dailyTransfer: Int, monthTransfer: Int ): Double {

    // Объявляем переменные
    val limitSutki = 150_000
    val limitMonth = 600_000
    val vkPayLimitOne = 15_000
    val vkPayLimitMonth= 40_000

    // Проверка лимитов
    // --------------------
    when (cardType) {
        "Mastercard", "Maestro", "Visa", "Mir" -> {
            if (dailyTransfer + amount > limitSutki) {
                println("Операция отклонена -> Превышен лимит переводов за сутки!")
                return 0.0
            }
            if (monthTransfer + amount > limitMonth) {
                println("Операция отклонена -> Превышен лимит переводов за месяц!")
                return 0.0
            }
        }
        "VK Pay" -> {
            if (amount > vkPayLimitOne) {
                println("Операция отклонена -> Превышен разовый лимит переводов для VK Pay.")
                return 0.0
            }
            if (monthTransfer + amount > vkPayLimitMonth) {
                println("Операция отклонена -> Превышен лимит переводов за месяц для VK Pay.")
                return 0.0
            }
        }
        else -> {
            println("Неизвестный тип карты + Превышение лимитов.")
            return 0.0
        }
    }
    // --------------------


    // Расчет комиссии
    // --------------------
    when (cardType) {
        "Mastercard", "Maestro" -> {
            if (amount in 300..75000) {
                return 0.0 // Комиссия не взимается
            } else {
                return amount * 0.006 + 20 // 0.6% + 20 рублей
            }
        }

        "Visa", "Mir" -> {
            val commission = amount * 0.0075 // 0.75%
            if (commission < 35) {
                return 35.0   // Минимум 35 рублей
            } else return commission
        }

        "VK Pay" -> {
            return 0.0 // Комиссия не взимается
        }

        else -> {
            print("Неизвестная карта")
            return 0.0
        }
    }
    // --------------------
}
// ====================

fun main() {
    // Проверка данных
    // --------------------
    println("Комиссия Mastercard: ${calculateCommission("Mastercard", 100_000, 0, 200_000)} рублей")
    println("Комиссия Visa: ${calculateCommission("Visa", 1000, 10000, 300_000)} рублей")
    println("Комиссия VK Pay: ${calculateCommission("VK Pay", 20000, 0, 35000)} рублей")
    // --------------------
}
