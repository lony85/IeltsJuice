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
    @SerializedName("pageInfo")
    val pageInfo: PageInfo?
) : Parcelable {
    @Parcelize
    data class Item(
        @SerializedName("etag")
        val etag: String?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("kind")
        val kind: String?,
        @SerializedName("snippet")
        val snippet: Snippet?,
        @SerializedName("status")
        val status: Status?
    ) : Parcelable {
        @Parcelize
        data class Snippet(
            @SerializedName("channelId")
            val channelId: String?,
            @SerializedName("channelTitle")
            val channelTitle: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("playlistId")
            val playlistId: String?,
            @SerializedName("position")
            val position: Int?,
            @SerializedName("publishedAt")
            val publishedAt: String?,
            @SerializedName("resourceId")
            val resourceId: ResourceId?,
            @SerializedName("thumbnails")
            val thumbnails: Thumbnails?,
            @SerializedName("title")
            val title: String?,
            @SerializedName("videoOwnerChannelId")
            val videoOwnerChannelId: String?,
            @SerializedName("videoOwnerChannelTitle")
            val videoOwnerChannelTitle: String?
        ) : Parcelable {
            @Parcelize
            data class ResourceId(
                @SerializedName("kind")
                val kind: String?,
                @SerializedName("videoId")
                val videoId: String?
            ) : Parcelable

            @Parcelize
            data class Thumbnails(
                @SerializedName("default")
                val default: Default?,
                @SerializedName("high")
                val high: High?,
                @SerializedName("maxres")
                val maxres: Maxres?,
                @SerializedName("medium")
                val medium: Medium?,
                @SerializedName("standard")
                val standard: Standard?
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
                data class Maxres(
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

                @Parcelize
                data class Standard(
                    @SerializedName("height")
                    val height: Int?,
                    @SerializedName("url")
                    val url: String?,
                    @SerializedName("width")
                    val width: Int?
                ) : Parcelable
            }
        }

        @Parcelize
        data class Status(
            @SerializedName("privacyStatus")
            val privacyStatus: String?
        ) : Parcelable
    }

    @Parcelize
    data class PageInfo(
        @SerializedName("resultsPerPage")
        val resultsPerPage: Int?,
        @SerializedName("totalResults")
        val totalResults: Int?
    ) : Parcelable
}