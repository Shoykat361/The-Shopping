package com.shoykat.theshopping.Repos

import androidx.lifecycle.LiveData
import com.shoykat.theshopping.Dao.CardDao
import com.shoykat.theshopping.Entity.CardEntity

class CardRepo(private val cardDao: CardDao) {

    val allCards: LiveData<List<CardEntity>> = cardDao.getAll()

    suspend fun insert(cardEntity: CardEntity) {
        cardDao.insert(cardEntity)
    }
    suspend fun delete(cardEntity: CardEntity) {
        cardDao.delete(cardEntity)
    }
    suspend fun update(cardEntity: CardEntity) {
        cardDao.update(cardEntity)
    }
}