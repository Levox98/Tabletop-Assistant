package com.tabletop_assistant.feature_character

import com.tabletop_assistant.core_domain.repository.CharacterRepository
import com.tabletop_assistant.core_domain.usecase.character.LoadCharacterClassIndicesFlowUseCase
import com.tabletop_assistant.core_domain.usecase.character.GetCharacterRacesFlowUseCase
import com.tabletop_assistant.core_domain.usecase.character.LoadRaceInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CharacterModule {

    @Provides
    fun provideLoadRacesUseCase(repository: CharacterRepository) =
        GetCharacterRacesFlowUseCase(repository)

    @Provides
    fun provideLoadRaceInfoUseCase(repository: CharacterRepository) =
        LoadRaceInfoUseCase(repository)

    @Provides
    fun provideLoadClassesUseCase(repository: CharacterRepository) =
        LoadCharacterClassIndicesFlowUseCase(repository)
}