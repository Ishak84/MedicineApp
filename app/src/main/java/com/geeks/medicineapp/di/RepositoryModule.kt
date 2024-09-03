package com.geeks.medicineapp.di

import com.geeks.medicineapp.repository.PillsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule : Module = module {

    single { PillsRepository(get()) }

}