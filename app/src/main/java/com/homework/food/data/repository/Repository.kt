package com.homework.food.data.repository

import com.homework.food.data.api.FoodApi
import com.homework.food.data.local.FoodDAO
import com.homework.food.data.model.FoodItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository(private val foodApi : FoodApi , private val foodDAO: FoodDAO) {

    suspend fun getFoodsAPI() = foodApi.getFoods()

    suspend fun deleteFoods() = foodDAO.deleteAll()

    suspend fun storeLocalData(foodItem: List<FoodItem>){
        foodDAO.deleteAll()
        foodDAO.insert(foodItem)
    }

    suspend fun setFavorite(id : String) = foodDAO.setFavorite(id)

    suspend fun unsetFavorite(id : String) = foodDAO.unsetFavorite(id)

    suspend fun updateData(foods : List<FoodItem>) = foodDAO.updateData(foods)

    fun getFoodsLocal() = foodDAO.getAll()


}