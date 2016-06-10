submitProjectName := "objsets"

scalaVersion := "2.11.5"

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-optimise",
  "-Yinline-warnings"
)

fork := true

javaOptions += "-Xmx2G"

parallelExecution in Test := false


// See documentation in ProgFunBuild.scala
projectDetailsMap := {
val currentCourseId = "progfun-005"
val depsQuickcheck = Seq(
    "org.scalacheck" %% "scalacheck" % "1.12.1"
  )
Map(
  "example" ->  ProjectDetails(
                  packageName = "example",
                  assignmentPartId = "gTzFogNk",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "recfun" ->     ProjectDetails(
                  packageName = "recfun",
                  assignmentPartId = "4Rarn9Ki",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "funsets" ->    ProjectDetails(
                  packageName = "funsets",
                  assignmentPartId = "gBXOL7Rd",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "objsets" ->    ProjectDetails(
                  packageName = "objsets",
                  assignmentPartId = "25dMMEz7",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "patmat" ->     ProjectDetails(
                  packageName = "patmat",
                  assignmentPartId = "6gPmpcif",
                  maxScore = 20d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "forcomp" ->    ProjectDetails(
                  packageName = "forcomp",
                  assignmentPartId = "gG3oZGIO",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "streams" ->    ProjectDetails(
                  packageName = "streams",
                  assignmentPartId = "1WKgCFCi",
                  maxScore = 20d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "quickcheck" -> ProjectDetails(
                  packageName = "quickcheck",
                  assignmentPartId = "02Vi5q7m",
                  maxScore = 10d,
                  styleScoreRatio = 0.0,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId,
                  dependencies=depsQuickcheck),
  "constraints"  -> ProjectDetails(
                  packageName = "constraints",
                  assignmentPartId = "kL1K2FAj",
                  maxScore = 10d,
                  styleScoreRatio = 0.0,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "interpreter"  -> ProjectDetails(
                  packageName = "interpreter",
                  assignmentPartId = "1SZhe1Ua283r87a7rd",
                  maxScore = 10d,
                  styleScoreRatio = 0.0,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId)
)}
