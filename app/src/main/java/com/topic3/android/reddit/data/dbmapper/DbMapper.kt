package com.topic3.android.reddit.data.dbmapper

import com.topic3.android.reddit.data.database.model.PostDbModel
import com.topic3.android.reddit.domain.model.PostModel

interface DbMapper {

    fun mapPost(dbPostDbModel: PostDbModel): PostModel

    fun mapDbPost(postModel: PostModel): PostDbModel
}