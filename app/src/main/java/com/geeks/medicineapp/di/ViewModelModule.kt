package com.geeks.medicineapp.di

import com.geeks.medicineapp.ui.fragments.PillsGreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {

    viewModel { PillsGreenViewModel(get()) }

}
