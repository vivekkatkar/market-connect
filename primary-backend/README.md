Developer notes

This project requires Java 17 for compilation with Lombok and the annotation processor.

If your system default JDK is newer (e.g. JDK 21+), set the JAVA_17_HOME environment variable to a JDK 17 installation and build with the Maven wrapper.

Example (PowerShell):

```powershell
# Set JAVA_17_HOME to your JDK 17 installation
$env:JAVA_17_HOME = 'C:\Program Files\Java\jdk-17'
# Optionally set JAVA_HOME as well
$env:JAVA_HOME = $env:JAVA_17_HOME
# Verify
java -version
javac -version
# Build (tests are skipped by default)
.\mvnw.cmd -DskipTests clean package
```

If you prefer to run tests, remove or change the `skipTests` configuration in `pom.xml` or pass `-DskipTests=false` on the command line.

If Lombok still throws an ExceptionInInitializerError referring to `com.sun.tools.javac.code.TypeTag`, try updating `lombok.version` in `pom.xml` to a newer release that supports your JDK, or ensure compilation uses a JDK 17 `javac` as shown above.

