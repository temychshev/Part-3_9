package com.topic3.android.reddit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.topic3.android.reddit.viewmodel.MainViewModel
import com.topic3.android.reddit.viewmodel.MainViewModelFactory
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
  private val viewModel: MainViewModel by viewModels(factoryProducer = {
    MainViewModelFactory(
      this,
      (application as RedditApplication).dependencyInjector.repository
    )
  })

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      RedditApp(viewModel)
    }
  }
}