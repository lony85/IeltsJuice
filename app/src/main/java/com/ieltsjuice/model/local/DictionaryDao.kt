package com.ieltsjuice.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface DictionaryDao {

    @Insert
    fun insertWord(dictionaryLocalDataClass: DictionaryLocalDataClass)

    @Update
    fun update(dictionaryLocalDataClass: DictionaryLocalDataClass)

//    @Query("SELECT * FROM Dictionary")
//    fun getAllFavData(): Single<List<DictionaryLocalDataClass>>

    @Query("DELETE FROM Dictionary WHERE word = :wordName")
    fun deleteByWordName(wordName : String)


}