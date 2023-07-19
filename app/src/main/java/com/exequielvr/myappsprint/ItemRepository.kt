package com.exequielvr.myappsprint

import android.util.Log
import androidx.lifecycle.MutableLiveData


class ItemRepository (private val itemsDao: ItemsDao) {

    private val networkService = RetrofitClient.retrofitInstance()
    val itemsListLiveData = itemsDao.getAllItems()
    val itemDetailLiveData = MutableLiveData<ItemsDetailEntity>()

    suspend fun  fechItems(){
        val service = kotlin.runCatching { networkService.fecthItemsList()}
        service.onSuccess {
            when(it.code()){
                in 200..299-> it.body()?.let {
                    itemsDao.insertAllItems(fromInternetToItemsEntity(it))
                }
                else -> Log.d("REPOSITORY: ", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("ERROR: ","${it.message}")
            }
        }
    }

    suspend fun fetchItemDetail(id: String): ItemsDetailEntity? {
        val service = kotlin.runCatching { networkService.fechItemDetail(id) }
        return service.getOrNull()?.body()?.let { itemDetail ->
            val itemDetailEntity = fromInternetToItemDetailEntity(itemDetail)
            itemsDao.insertItemDetail(itemDetailEntity)
            itemDetailEntity
        }
    }
}