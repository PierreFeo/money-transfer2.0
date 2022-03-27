package ru.netology

const val MASTERCARD = "MASTERCARD"
const val MAESTRO = "MAESTRO"
const val VISA = "VISA"
const val MIR = "MIR"
const val VK = "VK"

fun main() {
    val transfer = 250000
    val sumMonth = 324000
    val paymentType = "MASTERCARD"
    val maxSumMonthMasterCard = 75000 * 100
    val result = transferMoney(transfer, sumMonth, paymentType, maxSumMonthMasterCard)
    println("Комиссия за перевод: ${result / 100} рублей ${result % 100} копеек.")
}

fun transferMoney(transfer: Int, sumMonth: Int = 0, paymentType: String = "VK", maxSumMonthMasterCard: Int): Int {

    val level = when (paymentType) {
        MASTERCARD, MAESTRO -> if (transfer + sumMonth < maxSumMonthMasterCard) 0 else (transfer / 100 * 0.6 + 2000)
        VISA, MIR -> if (transfer / 100 * 0.75 < 3500) 3500 else transfer / 100 * 0.75
        VK -> 0
        else -> error("Карта не поддерживается")
    }
    return level.toInt()

}









