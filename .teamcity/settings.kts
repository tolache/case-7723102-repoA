import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2025.07"

project {

    buildType(Tickets_Case7723102_ProjectA_BuildA)
}

object Tickets_Case7723102_ProjectA_BuildA : BuildType({
    id("BuildA")
    name = "Build A"

    artifactRules = "file_v*"

    vcs {
        root(DslContext.settingsRoot)

        cleanCheckout = true
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "echo %build.number% > file_v%build.number%"
        }
    }
})
