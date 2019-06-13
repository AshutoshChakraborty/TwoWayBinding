package com.example.twowaybinding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MyViewModel(context: Application) : AndroidViewModel(context) {
    val name: MutableLiveData<String> = MutableLiveData()
    val age: MutableLiveData<String> = MutableLiveData()
    val person: MutableLiveData<Person> = MutableLiveData()
    val submitClick: SingleLiveEvent<Unit> = SingleLiveEvent()


    fun submit() {
        val mPerson = Person(name.value, age.value)
        person.value = mPerson
    }

    fun personUpdate(): MutableLiveData<Person> = person

    fun onSubmitClick() {
        submitClick.call()
    }

    fun callOnSubmitClick(): SingleLiveEvent<Unit> = submitClick


}