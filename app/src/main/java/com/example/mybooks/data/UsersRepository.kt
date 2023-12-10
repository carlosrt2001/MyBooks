package com.example.mybooks.data

import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getAllUsersStream(): Flow<List<User>>

    fun getTotalUsers(): Flow<Int>

    fun getUserStream(username: String): Flow<User>

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun updateUser(user: User)

    fun getActiveUserStream(): Flow<List<User>>
}