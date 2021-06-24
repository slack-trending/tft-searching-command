plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.slack.api:bolt-socket-mode:1.8.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:3.4.2")
    implementation("com.squareup.okhttp3:logging-interceptor:3.11.0")
    implementation("javax.websocket:javax.websocket-api:1.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")
    implementation("org.glassfish.tyrus.bundles:tyrus-standalone-client:1.17")
    implementation("org.slf4j:slf4j-simple:1.7.30")
}

application {
    mainClass.set("TFTCommandAppKt") // add "Kt" suffix for main function source file
}
