package com.wisal.android.rickandmorty.core.database.entity.mapper

import com.wisal.android.rickandmorty.core.database.entity.CharacterEntity
import com.wisal.android.rickandmorty.model.Character

object CharacterEntityMapper: EntityMapper<List<Character>,List<CharacterEntity>> {

    override fun asEntity(domain: List<Character>): List<CharacterEntity> {
        return domain.map { character ->
            CharacterEntity(
                id = character.id,
                name = character.name,
                image = character.image
            )
        }
    }

    override fun asDomain(entity: List<CharacterEntity>): List<Character> {
        return entity.map { characterEntity ->
            Character(
                id = characterEntity.id,
                name = characterEntity.name,
                image = characterEntity.image
            )
        }
    }
}

fun List<Character>.asEntity(): List<CharacterEntity> {
    return CharacterEntityMapper.asEntity(this)
}

fun List<CharacterEntity>.asDomain(): List<Character> {
    return CharacterEntityMapper.asDomain(this)
}
