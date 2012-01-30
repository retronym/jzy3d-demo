package org.jzy3d.demos.surface

import java.awt.Dimension
import org.jzy3d.chart.Chart
import org.jzy3d.colors.Color
import org.jzy3d.colors.ColorMapper
import org.jzy3d.colors.colormaps.ColorMapRainbow
import org.jzy3d.demos.AbstractDemo
import org.jzy3d.demos.Launcher
import org.jzy3d.maths.Range
import org.jzy3d.plot3d.builder.Builder
import org.jzy3d.plot3d.builder.Mapper
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid
import org.jzy3d.plot3d.primitives.Shape
import org.jzy3d.plot3d.rendering.canvas.Quality
import org.jzy3d.plot3d.rendering.legends.colorbars.ColorbarLegend

object WireSurfaceDemo {
  def main(args: Array[String]) {
    Launcher.openDemo(new WireSurfaceDemo)
  }
}

class WireSurfaceDemo extends AbstractDemo {

  def init() {
    val mapper: Mapper = new Mapper {
      def f(x: Double, y: Double): Double = {
        return 10 * math.sin(x / 10) * math.cos(y / 20) * x
      }
    }
    val range = new Range(-150, 150)
    val steps = 50
    val surface: Shape = Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper).asInstanceOf[Shape]
    import surface._
    setColorMapper(new ColorMapper(new ColorMapRainbow, getBounds.getZmin, getBounds.getZmax, new Color(1, 1, 1, .5f)))
    setFaceDisplayed(true)
    setWireframeDisplayed(true)
    setWireframeColor(Color.BLACK)
    chart = new Chart(Quality.Advanced)
    chart.getScene.getGraph.add(surface)
    val cbar: ColorbarLegend = new ColorbarLegend(surface, chart.getView.getAxe.getLayout)
    cbar.setMinimumSize(new Dimension(100, 600))
    surface.setLegend(cbar)
  }
}