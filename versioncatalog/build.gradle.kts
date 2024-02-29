plugins {
    `java-library`
    id("eu.kakde.gradle.sonatype-maven-central-publisher") version "1.0.5"
}

group = "eu.kakde.plugindemo"
version = "1.0.0"

catalog {
    versionCatalog {
        from(files("./libs.versions.toml"))
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

// ------------------------------------
// PUBLISHING TO SONATYPE CONFIGURATION
// ------------------------------------
object Meta {
    val COMPONENT_TYPE = "versionCatalog" // "java" or "versionCatalog"
    val GROUP = "eu.kakde.plugindemo"
    val ARTIFACT_ID = "samplecatalog"
    val VERSION = "1.0.0" // THIS IS THE VERSION OF THE LIBRARY THAT WILL BE PUBLISHED TO REPO. DON'T CONFUSE IT WITH THE VERSION MENTIONED ABOVE which is, version = "1.0.0
    val PUBLISHING_TYPE = "AUTOMATIC" // USER_MANAGED or AUTOMATIC
    val SHA_ALGORITHMS =
        listOf("SHA-512") // sha256 and sha512 are supported but not mandatory. Only sha1 is mandatory but it is supported by default in the plugin.
    val DESC = "GitHub Version Catalog Repository for Personal Projects based on Gradle"
    val LICENSE = "Apache-2.0"
    val LICENSE_URL = "https://opensource.org/licenses/Apache-2.0"
    val GITHUB_REPO = "ani2fun/plugin-demo.git"
    val DEVELOPER_ID = "ani2fun"
    val DEVELOPER_NAME = "Aniket Kakde"
    val DEVELOPER_ORGANIZATION = "kakde.eu"
    val DEVELOPER_ORGANIZATION_URL = "https://www.kakde.eu"
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