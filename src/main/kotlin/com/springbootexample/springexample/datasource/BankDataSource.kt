package com.springbootexample.springexample.datasource

import com.springbootexample.springexample.models.Bank

interface BankDataSource {
    fun retrieveBanks():Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
}