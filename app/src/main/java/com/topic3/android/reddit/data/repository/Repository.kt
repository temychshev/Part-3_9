package com.topic3.android.reddit.data.repository

import androidx.lifecycle.LiveData
import com.topic3.android.reddit.domain.model.PostModel

interface Repository {

    fun getAllPosts(): LiveData<List<PostModel>>

    fun getAllOwnedPosts(): LiveData<List<PostModel>>

    fun insert(post: PostModel)

    fun deleteAll()
}