package com.example.roomproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomproject.model.NoteModel
import com.example.roomproject.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    fun delete(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            Constants.REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }

    fun update(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            Constants.REPOSITORY.updateNote(noteModel){
                onSuccess()
            }
        }
}