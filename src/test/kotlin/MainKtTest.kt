package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    // Рассмотрел все ветки функции calculateCommission(), а Missed Branches показывает 54%

    // Проверка ВЕТОК лимитов
    // --------------------
    // Операция отклонена -> Превышен лимит переводов за сутки "Mastercard"!
    @Test
    fun calculateCommission1() {
        val result = calculateCommission("Mastercard", 200_000, 0, 0)
        assertEquals(55.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за месяц "Mastercard"!
    @Test
    fun calculateCommission2() {
        val result = calculateCommission("Mastercard", 700_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за сутки "Maestro"!
    @Test
    fun calculateCommission111() {
        val result = calculateCommission("Maestro", 200_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за месяц "Maestro"!
    @Test
    fun calculateCommission222() {
        val result = calculateCommission("Maestro", 700_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за сутки "Visa"!
    @Test
    fun calculateCommission1111() {
        val result = calculateCommission("Visa", 200_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за месяц "Visa"!
    @Test
    fun calculateCommission2222() {
        val result = calculateCommission("Visa", 700_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за сутки "Mir"!
    @Test
    fun calculateCommission11111() {
        val result = calculateCommission("Mir", 200_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за месяц "Mir"!
    @Test
    fun calculateCommission22222() {
        val result = calculateCommission("Mir", 700_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }



    // Операция отклонена -> Превышен разовый лимит переводов для VK Pay
    @Test
    fun calculateCommission3() {
        val result = calculateCommission("VK Pay", 20_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Операция отклонена -> Превышен лимит переводов за месяц для VK Pay
    @Test
    fun calculateCommission4() {
        val result = calculateCommission("VK Pay", 50_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Неизвестный тип карты + Превышение лимитов.
    @Test
    fun calculateCommission5() {
        val result = calculateCommission("Рога и Копыта", 800_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }
    // --------------------



    // Проверка ВЕТОК расчета комиссии
    // --------------------
    // Комиссия не взимается "Mastercard"
    @Test
    fun calculateCommission6() {
        val result = calculateCommission("Mastercard", 310, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // 0.6% + 20 рублей "Mastercard"
    @Test
    fun calculateCommission7() {
        val result = calculateCommission("Mastercard", 80_000, 0, 0)
        assertEquals(500.0, result, 0.001)
    }

    // Комиссия не взимается "Maestro"
    @Test
    fun calculateCommission66() {
        val result = calculateCommission("Maestro", 310, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // 0.6% + 20 рублей "Maestro"
    @Test
    fun calculateCommission77() {
        val result = calculateCommission("Maestro", 80_000, 0, 0)
        assertEquals(500.0, result, 0.001)
    }



    // 0.75% "Visa"

    @Test
    fun calculateCommission8() {
        val result = calculateCommission("Visa", 20_000, 0, 0)
        assertEquals(150.0, result, 0.001)
    }

    // 35 руб "Visa"

    @Test
    fun calculateCommission9() {
        val result = calculateCommission("Visa", 1_000, 0, 0)
        assertEquals(35.0, result, 0.001)
    }

    // 0.75% "Mir"
    @Test
    fun calculateCommission88() {
        val result = calculateCommission("Mir", 20_000, 0, 0)
        assertEquals(150.0, result, 0.001)
    }

    // 35 руб "Mir"
    @Test
    fun calculateCommission99() {
        val result = calculateCommission("Mir", 1_000, 0, 0)
        assertEquals(35.0, result, 0.001)
    }



    // VK Pay
    @Test
    fun calculateCommission10() {
        val result = calculateCommission("VK Pay", 10_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }

    // Неизвестная карта
    @Test
    fun calculateCommission11() {
        val result = calculateCommission("Неизвестная карта", 5_000, 0, 0)
        assertEquals(0.0, result, 0.001)
    }
    // --------------------

}