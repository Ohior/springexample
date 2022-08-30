package com.springbootexample.springexample.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest{
    val baseUrl = "/api/banks"

    @Autowired
    lateinit var mockMvc: MockMvc

    @Nested
    @DisplayName("getBanks()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBanks{
        @Test
        fun `should return all banks`() {
            //when/
            mockMvc.get(baseUrl)
                .andDo { println() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].accountNumber") {
                        value("1234")
                    }
                    jsonPath("$[1].trust") {
                        value("5.0")
                    }
                    jsonPath("$[0].transactionFee") {
                        value("12")
                    }
                }
        }
    }

    @Nested
    @DisplayName("getBank()")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBank{
        @Test
        fun `should return bank with given account number`() {
            //given
            val accountNumber = 1234
            //when
            mockMvc.get("$baseUrl/${accountNumber}")
                //then
                .andDo { println() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.trust"){value(1.5)}
                }
        }
    }

    @Test
    fun `should return not found if account number does not exit`() {
        //given
        val accountNumber = "does_not_exist"
        //when
        mockMvc.get("$baseUrl/${accountNumber}")
            //then
            .andDo { println() }
            .andExpect {
                status { isNotFound() }
//                content { contentType(MediaType.APPLICATION_JSON) }
//                jsonPath("$.trust") {
//                    value(1.5)
//                }
            }
    }
}