package com.ieltsjuice.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

class Dictionary : ArrayList<Dictionary.DictionaryItem>(){
    @Parcelize
    data class DictionaryItem(
        @SerializedName("license")
        val license: License?,
        @SerializedName("meanings")
        val meanings: List<Meaning?>?,
        @SerializedName("phonetic")
        val phonetic: String?,
        @SerializedName("phonetics")
        val phonetics: List<Phonetic?>?,
        @SerializedName("sourceUrls")
        val sourceUrls: List<String?>?,
        @SerializedName("word")
        val word: String?
    ) : Parcelable {
        @Parcelize
        data class License(
            @SerializedName("name")
            val name: String?,
            @SerializedName("url")
            val url: String?
        ) : Parcelable
    
        @Parcelize
        data class Meaning(
            @SerializedName("antonyms")
            val antonyms: List<String?>?,
            @SerializedName("definitions")
            val definitions: List<Definition?>?,
            @SerializedName("partOfSpeech")
            val partOfSpeech: String?,
            @SerializedName("synonyms")
            val synonyms: List<String?>?
        ) : Parcelable {
            @Parcelize
            data class Definition(
                @SerializedName("antonyms")
                val antonyms: List<String?>?,
                @SerializedName("definition")
                val definition: String?,
                @SerializedName("example")
                val example: String?,
                @SerializedName("synonyms")
                val synonyms: List<String?>?
            ) : Parcelable
        }
    
        @Parcelize
        data class Phonetic(
            @SerializedName("audio")
            val audio: String?,
            @SerializedName("license")
            val license: License?,
            @SerializedName("sourceUrl")
            val sourceUrl: String?,
            @SerializedName("text")
            val text: String?
        ) : Parcelable {
            @Parcelize
            data class License(
                @SerializedName("name")
                val name: String?,
                @SerializedName("url")
                val url: String?
            ) : Parcelable
        }
    }
}