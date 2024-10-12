package infrastructure.factories

import com.google.inject.Inject
import domain.factories.SourceFactory
import scala.io.Source

class JsonWeaponSourceFactory () extends SourceFactory {
  def createSource: Source = {
    Source.fromFile("path/to/your/json/file")
  }
}