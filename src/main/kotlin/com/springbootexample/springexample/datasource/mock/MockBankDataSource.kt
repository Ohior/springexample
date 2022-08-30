package com.springbootexample.springexample.datasource.mock

import com.springbootexample.springexample.datasource.BankDataSource
import com.springbootexample.springexample.models.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource:BankDataSource {
    val banks = listOf(
        Bank(accountNumber = "1234", trust = 1.5, transactionFee = 12),
        Bank(accountNumber = "5678", trust = 5.0, transactionFee = 5),
        Bank(accountNumber = "1597", trust = 10.0, transactionFee = 100),
    )

    override fun retrieveBanks(): Collection<Bank>  = banks

}