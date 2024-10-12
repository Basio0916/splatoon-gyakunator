package infrastructure.factories

import com.google.inject.Inject
import domain.factories.SourceFactory
import scala.io.Source

class JsonSubWeaponSourceFactory () extends SourceFactory {
  def createSource: Source = {
    Source.fromResource("SubWeapons.json")
  }
}