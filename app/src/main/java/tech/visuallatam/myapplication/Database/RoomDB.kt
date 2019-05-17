package tech.visuallatam.myapplication.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GithubRepo::class],version = 1, exportSchema = false)
public  abstract  class RoomDB : RoomDatabase(){
    abstract fun repoDAO(): GithubDao

    companion object {
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context):RoomDB{

            val temp = INSTANCE

            if(temp!=null){
                return temp
            }
            synchronized(this){
                val instance  = Room.databaseBuilder(context,RoomDB::class.java,"RepoDB").build()
                INSTANCE = instance
                return instance
            }

        }
    }
}