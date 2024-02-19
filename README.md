# Demo Project

This is the sample project to demonstrate publishing to Sonatype Central using the plugin 

https://github.com/ani2fun/sonatype-maven-central-publisher


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
