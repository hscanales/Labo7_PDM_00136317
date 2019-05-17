package tech.visuallatam.myapplication.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.visuallatam.myapplication.Database.GithubRepo
import tech.visuallatam.myapplication.Database.RoomDB
import tech.visuallatam.myapplication.Repository.GitHubRepoRepository

class GithubRepoViewModel(app:Application): AndroidViewModel(app) {

    private val repository : GitHubRepoRepository

    init{
        val repoDao = RoomDB.getInstance(app).repoDAO()
        repository = GitHubRepoRepository(repoDao)
    }



    fun insert(repo : GithubRepo) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(repo)
    }

    fun todos():LiveData<List<GithubRepo>> = repository.all()

    fun nuke() = repository.nuke()

}