package com.shoykat.theshopping.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.shoykat.theshopping.Db.AppDatabase
import com.shoykat.theshopping.Entity.ProductEntity
import com.shoykat.theshopping.Repos.CartRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  CartViewModel(application: Application) : AndroidViewModel(application){

    private val repository: CartRepo
    val allproducts: LiveData<List<ProductEntity>>

    init {
        val productDao = AppDatabase.getInstance(application).productDao()
        repository = CartRepo(productDao)
        allproducts = repository.allCartProducts
    }

    fun insert(product: ProductEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(product)
    }

    fun deleteCart(product: ProductEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(product)
    }

    fun updateCart(product: ProductEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(product)
    }
}