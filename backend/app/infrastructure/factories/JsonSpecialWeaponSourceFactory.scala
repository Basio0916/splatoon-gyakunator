package infrastructure.factories

import com.google.inject.Inject
import domain.factories.SourceFactory
import scala.io.Source

class JsonSpecialWeaponSourceFactory () extends SourceFactory {
  def createSource: Source = {
    Source.fromResource("SpecialWeapons.json")
  }
}