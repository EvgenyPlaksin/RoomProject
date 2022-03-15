package com.example.roomproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomproject.R
import com.example.roomproject.adapter.NoteAdapter
import com.example.roomproject.databinding.FragmentStartBinding
import com.example.roomproject.model.NoteModel
import com.example.roomproject.utils.Constants.APP
import com.example.roomproject.viewmodel.StartViewModel

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding =  FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.initDatabase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner, {listNotes ->

            adapter.setList(listNotes.asReversed())
        })

        binding.btnNext.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_addFragment)
        }

    }

companion object{
    fun clickNote(noteModel: NoteModel){
        val bundle = Bundle()
        bundle.putSerializable("note", noteModel)
        APP.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
    }
}

}