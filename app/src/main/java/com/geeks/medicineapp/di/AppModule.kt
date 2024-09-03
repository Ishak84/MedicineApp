package com.example.pillstime.di

import com.geeks.medicineapp.di.networkModule
import com.geeks.medicineapp.di.repositoryModule
import com.geeks.medicineapp.di.viewModelModule

val appModule = listOf(
    networkModule,
    repositoryModule,
    viewModelModule
)