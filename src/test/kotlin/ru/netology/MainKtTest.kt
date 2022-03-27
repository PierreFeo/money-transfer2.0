package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferMoney_commissionMasterAndMaestroBeforeLimit() {
        //arrange
        val transfer = 250000
        val sumMonth = 324000
        val paymentType = "MASTERCARD"
        val maxSumMonthMasterCard = 75000 * 100
        //act
        val result = transferMoney(
            transfer = transfer,
            sumMonth = sumMonth,
            paymentType = paymentType,
            maxSumMonthMasterCard = maxSumMonthMasterCard
        )
        //assert
        assertEquals(0, result)
    }

    @Test
    fun transferMoney_commissionMasterAndMaestroAfterLimit() {
        //arrange
        val transfer = 250000
        val sumMonth = 75000 * 100
        val paymentType = "MAESTRO"
        val maxSumMonthMasterCard = 75000 * 100
        //act
        val result = transferMoney(
            transfer = transfer,
            sumMonth = sumMonth,
            paymentType = paymentType,
            maxSumMonthMasterCard = maxSumMonthMasterCard
        )
        //assert
        assertEquals(3500, result)
    }

    @Test
    fun transferMoney_commissionVisaAndMir() {
        //arrange
        val transfer = 500000
        val sumMonth = 75000 * 100
        val paymentType = "VISA"
        val maxSumMonthMasterCard = 75000 * 100

        //act
        val result = transferMoney(
            transfer = transfer,
            sumMonth = sumMonth,
            paymentType = paymentType,
            maxSumMonthMasterCard = maxSumMonthMasterCard
        )
        //assert
        assertEquals(3750, result)
    }
    @Test
    fun transferMoney_commissionVisaAndMirMinCommission() {
        //arrange
        val transfer = 35000
        val sumMonth = 75000 * 100
        val paymentType = "MIR"
        val maxSumMonthMasterCard = 75000 * 100

        //act
        val result = transferMoney(
            transfer = transfer,
            sumMonth = sumMonth,
            paymentType = paymentType,
            maxSumMonthMasterCard = maxSumMonthMasterCard
        )
        //assert
        assertEquals(3400, result)
    }
    @Test
    fun transferMoney_commissionVkPay() {
        //arrange
        val transfer = 35000
        val sumMonth = 75000 * 100
        val paymentType = "VK"
        val maxSumMonthMasterCard = 75000 * 100

        //act
        val result = transferMoney(
            transfer = transfer,
            sumMonth = sumMonth,
            paymentType = paymentType,
            maxSumMonthMasterCard = maxSumMonthMasterCard
        )
        //assert
        assertEquals(0, result)
    }
}