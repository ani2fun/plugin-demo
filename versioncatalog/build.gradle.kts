plugins {
    `java-library`
    id("eu.kakde.gradle.sonatype-maven-central-publisher") version "1.0.0"
}

group = "eu.kakde.plugindemo"
version = "1.0.0"

catalog {
    versionCatalog {
        from(files("./libs.versions.toml"))
    }
}

// signing {
//    val signingKey: String? by project
//    val signingPassword: String? by project
//    useInMemoryPgpKeys(signingKey, signingPassword)
// }

object Meta {
    const val COMPONENT_TYPE = "versionCatalog"

    const val GROUP = "eu.kakde.plugindemo"
    const val ARTIFACT_ID = "samplecatalog"
    const val VERSION = "1.0.0"
    const val PUBLISHING_TYPE = "USER_MANAGED" // USER_MANAGED or AUTOMATIC

    const val DESC = "GitHub Version Catalog Repository for Personal Projects based on Gradle"
    const val LICENSE = "Apache-2.0"
    const val LICENSE_URL = "https://opensource.org/licenses/Apache-2.0"
    const val GITHUB_REPO = "ani2fun/plugin-demo.git"
    const val DEVELOPER_ID = "ani2fun"
    const val DEVELOPER_NAME = "Aniket Kakde"
    const val DEVELOPER_ORGANIZATION = "kakde.eu"
    const val DEVELOPER_ORGANIZATION_URL = "https://www.kakde.eu"
}

val sonatypeUsername: String? by project // this is defined in ~/.gradle/gradle.properties
val sonatypePassword: String? by project // this is defined in ~/.gradle/gradle.properties

sonatypeCentralPublishExtension {
    groupId.set(Meta.GROUP)
    artifactId.set(Meta.ARTIFACT_ID)
    version.set(Meta.VERSION)
    componentType.set(Meta.COMPONENT_TYPE)
    publishingType.set(Meta.PUBLISHING_TYPE)
    username.set(System.getenv("SONATYPE_USERNAME") ?: sonatypeUsername)
    password.set(System.getenv("SONATYPE_PASSWORD") ?: sonatypePassword)

    pom {
        name.set(Meta.ARTIFACT_ID)
        description.set(Meta.DESC)
        url.set("https://github.com/${Meta.GITHUB_REPO}")
        licenses {
            license {
                name.set(Meta.LICENSE)
                url.set(Meta.LICENSE_URL)
            }
        }
        developers {
            developer {
                id.set(Meta.DEVELOPER_ID)
                name.set(Meta.DEVELOPER_NAME)
                organization.set(Meta.DEVELOPER_ORGANIZATION)
                organizationUrl.set(Meta.DEVELOPER_ORGANIZATION_URL)
            }
        }
        scm {
            url.set("https://github.com/${Meta.GITHUB_REPO}")
            connection.set("scm:git:https://github.com/${Meta.GITHUB_REPO}")
            developerConnection.set("scm:git:https://github.com/${Meta.GITHUB_REPO}")
        }
        issueManagement {
            system.set("GitHub")
            url.set("https://github.com/${Meta.GITHUB_REPO}/issues")
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
}
