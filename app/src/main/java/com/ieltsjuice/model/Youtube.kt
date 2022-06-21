package com.ieltsjuice.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Youtube(
    @SerializedName("etag")
    val etag: String?,

    @SerializedName("items")
    val items: List<Item?>?,

    @SerializedName("kind")
    val kind: String?,
    @SerializedName("nextPageToken")
    val nextPageToken: String?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?,
    @SerializedName("regionCode")
    val regionCode: String?
) : Parcelable {

    @Parcelize
    data class Item(
        @SerializedName("etag")
        val etag: String?,
        @SerializedName("id")
        val id: Id?,
        @SerializedName("kind")
        val kind: String?,
        @SerializedName("snippet")
        val snippet: Snippet?
    ) : Parcelable {
        @Parcelize
        data class Id(
            @SerializedName("kind")
            val kind: String?,
            @SerializedName("playlistId")
            val playlistId: String?,
            @SerializedName("videoId")
            val videoId: String?
        ) : Parcelable

        @Parcelize
        data class Snippet(
            @SerializedName("channelId")
            val channelId: String?,
            @SerializedName("channelTitle")
            val channelTitle: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("liveBroadcastContent")
            val liveBroadcastContent: String?,
            @SerializedName("publishTime")
            val publishTime: String?,
            @SerializedName("publishedAt")
            val publishedAt: String?,
            @SerializedName("thumbnails")
            val thumbnails: Thumbnails?,
            @SerializedName("title")
            val title: String?
        ) : Parcelable {
            @Parcelize
            data class Thumbnails(
                @SerializedName("default")
                val default: Default?,
                @SerializedName("high")
                val high: High?,
                @SerializedName("medium")
                val medium: Medium?
            ) : Parcelable {
                @Parcelize
                data class Default(
                    @SerializedName("height")
                    val height: Int?,
                    @SerializedName("url")
                    val url: String?,
                    @SerializedName("width")
                    val width: Int?
                ) : Parcelable

                @Parcelize
                data class High(
                    @SerializedName("height")
                    val height: Int?,
                    @SerializedName("url")
                    val url: String?,
                    @SerializedName("width")
                    val width: Int?
                ) : Parcelable

                @Parcelize
                data class Medium(
                    @SerializedName("height")
                    val height: Int?,
                    @SerializedName("url")
                    val url: String?,
                    @SerializedName("width")
                    val width: Int?
                ) : Parcelable
            }
        }
    }

    @Parcelize
    data class PageInfo(
        @SerializedName("resultsPerPage")
        val resultsPerPage: Int?,
        @SerializedName("totalResults")
        val totalResults: Int?
    ) : Parcelable
}