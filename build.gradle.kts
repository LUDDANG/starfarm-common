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

tasks.named("test") {
    enabled = false
}
