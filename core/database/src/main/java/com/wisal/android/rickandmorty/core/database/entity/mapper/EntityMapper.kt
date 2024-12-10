package com.wisal.android.rickandmorty.core.database.entity.mapper

interface EntityMapper<Domain,Entity> {

    fun asDomain(entity: Entity): Domain
    fun asEntity(domain: Domain): Entity

}