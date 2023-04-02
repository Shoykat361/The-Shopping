package com.shoykat.theshopping.Repos

import androidx.lifecycle.LiveData
import com.shoykat.theshopping.Dao.ProductDao
import com.shoykat.theshopping.Entity.ProductEntity

class CartRepo(private val productDao: ProductDao) {

    val allCartProducts: LiveData<List<ProductEntity>> = productDao.getAll()

    suspend fun insert(product: ProductEntity) {
        productDao.insert(product)
    }
    suspend fun delete(product: ProductEntity) {
        productDao.delete(product)
    }
    suspend fun update(product: ProductEntity) {
        productDao.update(product)
    }
}