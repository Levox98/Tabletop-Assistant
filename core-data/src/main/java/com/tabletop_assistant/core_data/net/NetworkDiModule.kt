package com.tabletop_assistant.core_data.net

import com.tabletop_assistant.core_data.net.service.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkDiModule {

	@Provides
	fun provideOkHttpClient() =
		OkHttpClient.Builder()
			.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
			.build()

	@Provides
	fun provideRetrofitService(okHttpClient: OkHttpClient): Retrofit =
		Retrofit.Builder()
			.baseUrl("https://www.dnd5eapi.co/api/")
			.addConverterFactory(GsonConverterFactory.create())
			.client(okHttpClient)
			.build()

	@Provides
	fun provideCharacterService(retrofit: Retrofit): CharacterService =
		retrofit.create(CharacterService::class.java)
}