package com.wisal.android.rickandmorty.core.database.entity.mapper

import com.wisal.android.rickandmorty.core.database.entity.CharacterInfoEntity
import com.wisal.android.rickandmorty.model.CharacterInfo

object CharacterInfoEntityMapper: EntityMapper<CharacterInfo,CharacterInfoEntity> {

    override fun asDomain(entity: CharacterInfoEntity): CharacterInfo {
        return CharacterInfo(
            created = entity.created,
            episode =  entity.episode,
            gender = entity.gender,
            id = entity.id,
            image = entity.image,
            location = entity.location,
            name = entity.name,
            origin = entity.origin,
            species = entity.species,
            status = entity.status,
            type = entity.type,
            url = entity.url
        )
    }

    override fun asEntity(domain: CharacterInfo): CharacterInfoEntity {
        return CharacterInfoEntity(
            created = domain.created,
            episode =  domain.episode,
            gender = domain.gender,
            id = domain.id,
            image = domain.image,
            location = domain.location,
            name = domain.name,
            origin = domain.origin,
            species = domain.species,
            status = domain.status,
            type = domain.type,
            url = domain.url
        )
    }
}


fun CharacterInfo.asEntity(): CharacterInfoEntity {
    return CharacterInfoEntityMapper.asEntity(this)
}

fun CharacterInfoEntity.asDomain(): CharacterInfo {
    return CharacterInfoEntityMapper.asDomain(this)
}


