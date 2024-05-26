plugins {
    id("java")
}

group = "live.luya.starfarm.common"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

}

java {
    withSourcesJar()
}

tasks.compileJava.get().options.encoding = "UTF-8"

tasks.named("test") {
    enabled = false
}
