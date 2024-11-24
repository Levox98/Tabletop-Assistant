package com.tabletop_assistant.core_data.mappers

import com.tabletop_assistant.core_data.entity.RaceDataEntity
import com.tabletop_assistant.core_data.net.response.RaceListResponse
import com.tabletop_assistant.core_domain.entity.Race

fun RaceListResponse.RaceEntity.toData() =
    RaceDataEntity(
        index = index,
        name = name,
        url = url,
        speed = speed,
        abilityBonuses = abilityBonuses.map { it.toData() },
        alignment = alignment,
        age = age,
        size = size,
        sizeDescription = sizeDescription,
        startingProficiencies = startingProficiencies, // TODO
        languages = languages.map { it.toData() },
        languageDesc = languageDesc,
        traits = traits.map { it.toData() },
        subraces = subraces // TODO
    )

fun RaceListResponse.RaceEntity.AbilityBonusEntity.toData() =
    RaceDataEntity.AbilityBonusDataEntity(
        abilityScore = RaceDataEntity.AbilityBonusDataEntity.AbilityScoreDataEntity(abilityScore.index, abilityScore.name, abilityScore.url),
        bonus = bonus
    )

fun RaceListResponse.RaceEntity.LanguageEntity.toData() =
    RaceDataEntity.LanguageDataEntity(
        index = index,
        name = name,
        url = url
    )

fun RaceListResponse.RaceEntity.TraitEntity.toData() =
    RaceDataEntity.TraitDataEntity(
        index = index,
        name = name,
        url = url
    )

fun RaceDataEntity.toDomain() =
    Race(
        index = index,
        name = name,
        url = url,
        speed = speed,
        abilityBonuses = abilityBonuses.map { it.toDomain() },
        alignment = alignment,
        age = age,
        size = size,
        sizeDescription = sizeDescription,
        startingProficiencies = startingProficiencies, // TODO
        languages = languages.map { it.toDomain() },
        languageDesc = languageDesc,
        traits = traits.map { it.toDomain() },
        subraces = subraces // TODO
    )

fun RaceDataEntity.AbilityBonusDataEntity.toDomain() =
    Race.AbilityBonus(
        abilityScore = Race.AbilityBonus.AbilityScore(
            abilityScore.index,
            abilityScore.name,
            abilityScore.url
        ),
        bonus = bonus
    )

fun RaceDataEntity.LanguageDataEntity.toDomain() =
    Race.Language(
        index = index,
        name = name,
        url = url
    )

fun RaceDataEntity.TraitDataEntity.toDomain() =
    Race.Trait(
        index = index,
        name = name,
        url = url
    )