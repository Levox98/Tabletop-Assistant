package com.tabletop_assistant.data.di

import com.tabletop_assistant.data.repostitory.RandomizeRepositoryImpl
import com.tabletop_assistant.domain.repository.RandomizeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataDiModule {

	/* Repos */

	@Provides
	@Singleton
	fun provideRandomizeRepository(impl: RandomizeRepositoryImpl): RandomizeRepository = impl
}