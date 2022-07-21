package com.ieltsjuice.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface DictionaryDao {

    @Insert
    fun insertWord(dictionaryLocalDataClass: DictionaryLocalDataClass)

    @Update
    fun update(dictionaryLocalDataClass: DictionaryLocalDataClass)

    @Query("SELECT * FROM Dictionary")
    fun getAllFavData(): LiveData<List<DictionaryLocalDataClass>>

    @Query("DELETE FROM Dictionary WHERE definition = :wordDefinition")
    fun deleteByWordDefinition(wordDefinition : String)


}