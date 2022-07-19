package com.ieltsjuice.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Dictionary")
data class DictionaryLocalDataClass(


    @PrimaryKey(autoGenerate = true)
    val id : Int? = null ,
    val word : String,
    val definition: String,
    val phonetics: String,
    val partOfSpeech: String

)