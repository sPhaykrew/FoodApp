package com.homework.food.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.homework.food.data.model.FoodItem

@Dao
interface FoodDAO {
    @Query("SELECT * FROM food_table")
    fun getAll(): LiveData<List<FoodItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(foodItem: List<FoodItem>)

    @Query("UPDATE food_table SET favorite = :isFavorite WHERE id = :id")
    suspend fun setFavorite(id : String , isFavorite : Boolean = true)

    @Query("UPDATE food_table SET favorite = :isFavorite WHERE id = :id")
    suspend fun unsetFavorite(id : String , isFavorite : Boolean = false)

}