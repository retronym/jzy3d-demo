An [SBT](http://scala-sbt.org) project to demonstrate the excellent [JZY3D](http://jzy3d.org)
scientific plotting library.

Edit `build.sbt` to pick your machine architecture.

Then you can run the code samples provided by JZY3D, which I've
converted to Scala.

Note that you can't run more than one sample from a single SBT session,
as the native code loading mechanism in SBT doesn't allow for this.

```
$ sbt run
[info] Loading global plugins from /Users/jason/.sbt/plugins
[info] Loading project definition from /Users/jason/code/scratch/20120129/project
[info] Set current project to jzy-demo (in build file:/Users/jason/code/scratch/20120129/)

Multiple main classes detected, select one to run:

 [1] org.jzy3d.demos.surface.WireSurfaceDemo
 [2] org.jzy3d.demos.surface.MexicanDemo
 [3] org.jzy3d.demos.surface.ColorWaveDemo
 [4] org.jzy3d.demos.surface.BuildSurfaceDemo

Enter number: 2

[info] Running org.jzy3d.demos.surface.MexicanDemo 
Rotate     : Left click and drag mouse
```
