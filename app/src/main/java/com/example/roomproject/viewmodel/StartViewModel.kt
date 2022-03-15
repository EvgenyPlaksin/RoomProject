package com.example.roomproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomproject.db.NoteDatabase
import com.example.roomproject.db.repository.NoteRealization
import com.example.roomproject.model.NoteModel
import com.example.roomproject.utils.Constants.REPOSITORY

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}