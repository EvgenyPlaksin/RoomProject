package com.example.roomproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomproject.R
import com.example.roomproject.databinding.FragmentDetailBinding
import com.example.roomproject.databinding.FragmentStartBinding
import com.example.roomproject.model.NoteModel
import com.example.roomproject.utils.Constants.APP
import com.example.roomproject.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescription.text = currentNote.description

        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

    }

}