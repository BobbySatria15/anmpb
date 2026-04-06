package com.ubayadev.studentproject.view

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubayadev.studentproject.R
import com.ubayadev.studentproject.databinding.ActivityMainBinding
import com.ubayadev.studentproject.databinding.FragmentStudentDetailBinding
import com.ubayadev.studentproject.databinding.FragmentStudentListBinding
import com.ubayadev.studentproject.viewmodel.DetailViewModel
import com.ubayadev.studentproject.viewmodel.ListViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        displayStudent()
    }

    fun displayStudent() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer{
            binding.txtStudentID.setText(it.id)
            binding.txtName.setText(it.name)
            binding.txtBod.setText(it.bod)
            binding.txtPhone.setText(it.phone)
        })
    }
}