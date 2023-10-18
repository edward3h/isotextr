plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.0.4"
}

version = "0.1"
group = "org.ethelred.isotextr"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("info.picocli:picocli-codegen")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("info.picocli:picocli")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    runtimeOnly("org.slf4j:slf4j-simple")
    runtimeOnly("org.yaml:snakeyaml")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}


application {
    mainClass.set("org.ethelred.isotextr.IsotextrCommand")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("org.ethelred.isotextr.*")
    }
}



