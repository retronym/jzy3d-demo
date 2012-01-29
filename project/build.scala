import sbt._
import Keys._

object build extends Plugin {
	
	/** Adds a dependency on a ZIP file, and modifies `unmanagedJars` to include the contents */
	def addZipJar(module: ModuleID, config: Configuration) = Seq[Project.Setting[_]](
		libraryDependencies += module,
		unmanagedJars in config <++= (update, cacheDirectory, target) map {
			(updateReport, cache, target) =>
				val moduleReports = updateReport.configuration(config.name).get.modules
				moduleReports.find(mr => (mr.module.organization, mr.module.name) == (module.organization, module.name)) match {
					case Some(x) => 
						val zipFile = x.artifacts.head._2						
						val cachedUnzip = FileFunction.cached(cache / "zipJar", inStyle = FilesInfo.lastModified, outStyle = FilesInfo.exists) { (in: Set[File]) =>
        				IO.unzip(in.head, target)
      				}
      			cachedUnzip(Set(zipFile)).toSeq
      		case None =>
      			sys.error("could not find artifact [%s] in [%s]".format(module, moduleReports.map(_.module).mkString("\n")))
				}
		}
	)
}
