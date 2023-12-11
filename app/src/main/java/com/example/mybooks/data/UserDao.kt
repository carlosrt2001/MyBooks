package com.example.mybooks.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * from user_table ORDER BY username ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT MAX(id) AS max_id FROM user_table")
    fun getTotalUsers(): Flow<Int>

    @Query("SELECT * from user_table WHERE username = :username")
    fun getUser(username: String): Flow<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user_table WHERE isActive == 1 LIMIT 1")
    fun getActiveUser(): User
}
