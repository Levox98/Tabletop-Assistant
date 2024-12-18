package com.tabletop_assistant.core_data.di

import com.tabletop_assistant.core_data.repository.CharacterRepositoryImpl
import com.tabletop_assistant.core_data.repository.RandomRepositoryImpl
import com.tabletop_assistant.core_domain.repository.CharacterRepository
import com.tabletop_assistant.core_domain.repository.RandomRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataDiModule {

	@Provides
	fun provideRandomRepository(repositoryImpl: RandomRepositoryImpl): RandomRepository = repositoryImpl

	@Provides
	fun provideCharacterRepository(repositoryImpl: CharacterRepositoryImpl): CharacterRepository = repositoryImpl
}