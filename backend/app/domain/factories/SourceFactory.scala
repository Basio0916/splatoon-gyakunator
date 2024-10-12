package domain.factories

import scala.io.Source

trait SourceFactory {
  def createSource: Source
}
