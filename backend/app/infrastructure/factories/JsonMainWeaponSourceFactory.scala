package infrastructure.factories

import com.google.inject.Inject
import domain.factories.SourceFactory
import scala.io.Source

class JsonMainWeaponSourceFactory () extends SourceFactory {
  def createSource: Source = {
    Source.fromResource("MainWeapons.json")
  }
}