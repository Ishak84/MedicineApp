package com.geeks.medicineapp.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.medicineapp.data.local.entity.model.Model
import com.geeks.medicineapp.repository.PillsRepository

import kotlinx.coroutines.launch

class PillsGreenViewModel(
    private val pillsRepository: PillsRepository
) : ViewModel() {

    private val pillsList = MutableLiveData<List<Model>>()

    fun getAllPills() = pillsRepository.getAllPills()

    fun insert(pills: Model) = viewModelScope.launch {
        pillsRepository.insert(pills)
    }
    fun addPillToTop(pill: Model) {
        val currentList = pillsList.value ?: emptyList()
        val updatedList = listOf(pill) + currentList
        pillsList.value = updatedList
    }
}