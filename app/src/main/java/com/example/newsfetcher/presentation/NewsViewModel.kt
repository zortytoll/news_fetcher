package com.example.newsfetcher.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsfetcher.RepositoryProvider
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.interactor.NewsInteractor
import com.example.newsfetcher.presentation.news_list_fragment.DataEvent
import com.example.newsfetcher.presentation.news_list_fragment.UiEvent
import com.example.newsfetcher.presentation.news_list_fragment.ViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val liveData = MutableLiveData<ViewState>(ViewState())

    init {
        val newsListInteractor = NewsInteractor(RepositoryProvider.newRepositoryInstance())
        liveData.value = ViewState()
        compositeDisposable.add(newsListInteractor.getNews("all")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data, error ->
                proccessDataEvent(DataEvent.ListAcquired(data))
            }
        )
    }

    fun proccessUiEvent(event: UiEvent) = reduce(event)

    fun proccessDataEvent(event: DataEvent) {
        reduce(event)
    }

    private fun reduce(partialChanges: Event) {
        val newsViewState = copyPreviousViewState(partialChanges, liveData.value!!)
        newsViewState?.let {
            if (it != liveData.value) {
                liveData.value = it
            }
        }
    }

    private fun copyPreviousViewState(event: Event, prev: ViewState): ViewState? =
        when (event) {
            is DataEvent.ListAcquired -> {
                prev.copy(
                    newsList = event.list
                )
            }
            else -> null
        }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}