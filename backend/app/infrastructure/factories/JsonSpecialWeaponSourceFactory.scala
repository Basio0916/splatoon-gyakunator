package infrastructure.factories

import domain.factories.SourceFactory
import scala.io.Source
import scala.io.Codec

class JsonSpecialWeaponSourceFactory () extends SourceFactory {
  def createSource: Source = {
    implicit val codec = Codec("UTF-8")
    Source.fromResource("SpecialWeapons.json")
  }
}