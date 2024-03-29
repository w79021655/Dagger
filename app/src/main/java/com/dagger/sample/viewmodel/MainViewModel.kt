package com.dagger.sample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dagger.sample.model.Users
import com.dagger.sample.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(_repository: MainRepository) : ViewModel() {
    private val repository: MainRepository = _repository
    private val compositeDisposable = CompositeDisposable()
    private val users = MutableLiveData<Users>()

    fun fetchUsers(perPage: Int, since: Int) {
        compositeDisposable.add(
            repository.getUsers(perPage, since)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ mUsers ->
                    if (mUsers.isSuccessful) {
                        users.postValue(mUsers.body())
                    } else {
                        users.postValue(null)
                    }
                }, {
                    users.postValue(null)
                })
        )
    }

    fun getUsers(): LiveData<Users> {
        return users
    }
}