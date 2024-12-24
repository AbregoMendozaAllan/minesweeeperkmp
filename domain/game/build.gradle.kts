import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

//Copy from composeApp Gradle file
//add include(":domain:game") to settings.gradle.kts
//does not need android specific blocks because it wont handle any android specific logic
//delete android specific blocks
plugins {
    alias(libs.plugins.kotlinMultiplatform)

}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DomainGame"//change to Module name
            isStatic = true
        }
    }

    jvm("desktop")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "domainGame"//change to Module name
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "domainGame.js"//change to Module name
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets{
        commonMain.dependencies {
            implementation(projects.data.game)
            implementation(projects.data.settings)
            implementation(libs.koin.core)
        }
    }
}