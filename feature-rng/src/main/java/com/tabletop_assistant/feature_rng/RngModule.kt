package com.tabletop_assistant.feature_rng

import com.tabletop_assistant.core_domain.repository.RandomRepository
import com.tabletop_assistant.core_domain.usecase.RollDiceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RngModule {

	@Provides
	fun provideRollDiceUseCase(repository: RandomRepository): RollDiceUseCase =
		RollDiceUseCase(repository)
}