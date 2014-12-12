package org.jzy3d.demos.surface

import org.jzy3d.chart.factories.AWTChartComponentFactory
import org.jzy3d.colors.{Color, ColorMapper}
import org.jzy3d.colors.colormaps.ColorMapRainbow
import org.jzy3d.demos.{AbstractDemo, Launcher}
import org.jzy3d.maths.Range
import org.jzy3d.plot3d.builder.{Builder, Mapper}
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid
import org.jzy3d.plot3d.primitives.Shape
import org.jzy3d.plot3d.rendering.canvas.Quality
import org.jzy3d.plot3d.rendering.legends.colorbars.AWTColorbarLegend

object MexicanDemo {
  def main(args: Array[String]) {
    Launcher.openDemo(new MexicanDemo)
  }
}

class MexicanDemo extends AbstractDemo {

  def init() {
    val sigma = 10
    val mapper: Mapper = (x: Double, y: Double) => math.exp(-(x * x + y * y) / sigma) * math.abs(math.cos(2 * math.Pi * (x * x + y * y)))
    val range = new Range(-0.5, .5)
    val steps = 50
    val surface: Shape = Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper)
    import surface._
    setColorMapper(new ColorMapper(new ColorMapRainbow, getBounds.getZmin, getBounds.getZmax))
    setFaceDisplayed(true)
    setWireframeDisplayed(true)
    setWireframeColor(Color.BLACK)
    chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt")
    chart.getScene.getGraph.add(surface)
    setLegend(new AWTColorbarLegend(surface, chart.getView.getAxe.getLayout))
  }
}