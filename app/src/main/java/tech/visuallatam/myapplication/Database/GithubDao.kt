package tech.visuallatam.myapplication.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GithubDao {

    @Query(value = "SELECT * FROM repos")
     fun getAllRepos():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)


    @Query("DELETE FROM REPOS")
    fun nukeTown()
}