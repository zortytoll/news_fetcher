package com.example.newsfetcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.newsfetcher.presentation.news_list_fragment.NewsListFragment
import com.example.newsfetcher.presentation.news_list_fragment.adapter.ArticleItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (ArticleItem(title = String(), abstract = String()))
        supportFragmentManager.commit {
            replace(android.R.id.content, NewsListFragment())
        }
    }
}