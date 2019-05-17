package tech.visuallatam.myapplication.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import tech.visuallatam.myapplication.Database.GithubDao
import tech.visuallatam.myapplication.Database.GithubRepo

class GitHubRepoRepository(private val repoDao: GithubDao) {

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun all() :  LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTown()

}