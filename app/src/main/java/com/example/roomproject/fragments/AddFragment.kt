package com.example.roomproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomproject.R
import com.example.roomproject.databinding.FragmentAddBinding
import com.example.roomproject.databinding.FragmentStartBinding
import com.example.roomproject.model.NoteModel
import com.example.roomproject.utils.Constants.APP
import com.example.roomproject.viewmodel.AddNoteViewModel

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]
        binding.btnAddNote.setOnClickListener{
            val title = binding.edittextTitle.text.toString()
            val description = binding.edittextDescription.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)

        }
    }

}