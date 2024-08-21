package com.tabletop_assistant.data.di

import com.tabletop_assistant.data.repostitory.RandomizeRepositoryImpl
import com.tabletop_assistant.domain.repository.RandomizeRepository
import dagger.Module
import javax.inject.Singleton

@Module
@Singleton
class DataDiModule {

	/* Repos */
	fun provideRandomizeRepository(impl: RandomizeRepositoryImpl): RandomizeRepository = impl
}