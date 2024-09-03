package com.geeks.medicineapp.ui.fragments

import androidx.navigation.fragment.findNavController
import com.geeks.medicineapp.R
import com.geeks.medicineapp.base.BaseFragment
import com.geeks.medicineapp.databinding.FragmentPillsBinding
import com.geeks.medicineapp.ui.adapteres.PillsGreenAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PillsFragment : BaseFragment<FragmentPillsBinding>(FragmentPillsBinding::inflate) {

    private lateinit var pillsGreenAdapter: PillsGreenAdapter
    private val viewModel: PillsGreenViewModel by viewModel()

    override fun setupViews() {
        setupRecyclerView()
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.getAllPills().observe(viewLifecycleOwner) {
            pillsGreenAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        pillsGreenAdapter = PillsGreenAdapter()
        binding.rvPills.adapter = pillsGreenAdapter
    }
    override fun initClickListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addPillsFragment)
        }
    }

}
