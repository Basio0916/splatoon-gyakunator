package infrastructure.modules

import domain.repositories._
import domain.factories.SourceFactory
import infrastructure.persistence.json._
import infrastructure.factories._
import com.google.inject.AbstractModule
import com.google.inject.name.Names
import domain.services.JwtService
import infrastructure.services.JwtServiceImpl

/**
 * DIモジュール
 */
class Module extends AbstractModule {
  override def configure() = {
    bind(classOf[SourceFactory]).annotatedWith(Names.named("Weapon")).to(classOf[JsonWeaponSourceFactory])
    bind(classOf[SourceFactory]).annotatedWith(Names.named("MainWeapon")).to(classOf[JsonMainWeaponSourceFactory])
    bind(classOf[SourceFactory]).annotatedWith(Names.named("SubWeapon")).to(classOf[JsonSubWeaponSourceFactory])
    bind(classOf[SourceFactory]).annotatedWith(Names.named("SpecialWeapon")).to(classOf[JsonSpecialWeaponSourceFactory])
    bind(classOf[WeaponRepository]).to(classOf[JsonWeaponRepository])
    bind(classOf[MainWeaponRepository]).to(classOf[JsonMainWeaponRepository])
    bind(classOf[SubWeaponRepository]).to(classOf[JsonSubWeaponRepository])
    bind(classOf[SpecialWeaponRepository]).to(classOf[JsonSpecialWeaponRepository])
    bind(classOf[JwtService]).to(classOf[JwtServiceImpl])
  }
}