# Demo Project

This is a sample project aimed at demonstrating publishing to Sonatype Central using the plugin available at: 
> Plugin portal : https://plugins.gradle.org/plugin/eu.kakde.gradle.sonatype-maven-central-publisher
> Source code: https://github.com/ani2fun/sonatype-maven-central-publisher

Some useful commands:

```bash
./gradlew :plugin-demo:clean
```

```bash
./gradlew :plugin-demo:publishToSonatype
```

```bash
./gradlew :plugin-demo:getDeploymentStatus  -PdeploymentId=<Deployment-ID>
```

```bash
./gradlew :plugin-demo:tasks
```


> [!NOTE]
> You can explore published projects utilizing the [plugin](https://plugins.gradle.org/plugin/eu.kakde.gradle.sonatype-maven-central-publisher) by visiting the following link:
https://repo1.maven.org/maven2/eu/kakde/plugindemo/