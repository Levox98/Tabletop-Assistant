package com.tabletop_assistant.core_data.repository

import com.tabletop_assistant.core_domain.repository.CharacterRepository
import com.tabletop_assistant.core_data.net.api.CharacterApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
	private val characterApi: CharacterApi
) : CharacterRepository {

	override fun createCharacter() {
		TODO("Not yet implemented")
	}

	override fun getCharacter() {
		TODO("Not yet implemented")
	}

	override fun updateCharacter() {
		TODO("Not yet implemented")
	}

	override fun deleteCharacter() {
		TODO("Not yet implemented")
	}
}