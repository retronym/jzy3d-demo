name := "jzy-demo"

libraryDependencies += "org.jzy3d" % "jzy3d" % "0.9" from "http://www.jzy3d.org/release/0.9a3/org.jzy3d-0.9.jar"

addZipJar("org.jzy3d" % "jzy3d-deps" % "0.9" from "http://www.jzy3d.org/release/0.9a3/org.jzy3d-0.9-dependencies.zip", Compile)

{
val arch = "macosx" // "windows-amd64" "windows-i586" "linux-amd64" "linux-i586"
addZipJar("org.jzy3d" % "jzy3d-native" % "0.9" from "http://www.jzy3d.org/release/0.9a3/org.jzy3d-0.9-binaries-%s.zip".format(arch), Compile)
}
