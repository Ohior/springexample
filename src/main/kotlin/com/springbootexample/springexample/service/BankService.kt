package com.springbootexample.springexample.service

import com.springbootexample.springexample.datasource.BankDataSource
import com.springbootexample.springexample.models.Bank
import org.springframework.stereotype.Service

@Service
class BankService(val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
}