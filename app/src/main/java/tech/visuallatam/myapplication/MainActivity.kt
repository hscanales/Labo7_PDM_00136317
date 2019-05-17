package tech.visuallatam.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import tech.visuallatam.myapplication.ViewModel.GithubRepoViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =  ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)


    }
}
