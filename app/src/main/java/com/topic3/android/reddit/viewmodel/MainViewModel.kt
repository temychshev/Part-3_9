package com.topic3.android.reddit.viewmodel

import androidx.lifecycle.ViewModel
import com.topic3.android.reddit.data.repository.Repository
class MainViewModel(private val repository: Repository) : ViewModel() {
    val allPosts by lazy { repository.getAllPosts() }

    val myPosts by lazy { repository.getAllOwnedPosts() }
}