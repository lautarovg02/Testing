# Testing Repository - Tecnicas de Validacion

Este repositorio contiene los ejercicios de Testing de la materia Tecnicas de Validacion, junto con la documentación asociada a mi carrera. Se abarcan aspectos como test de unidad, JUnit y TestNG. El objetivo principal es proporcionar un conjunto de ejemplos prácticos para entender y aplicar técnicas de testing en el desarrollo de software.

## Contenido

- **/src**: Carpeta que contiene los códigos fuente de los ejercicios de Testing.


## Implementación en IntelliJ IDEA

Para implementar JUnit y TestNG en IntelliJ IDEA, sigue estos pasos:

1. **Configuración del Proyecto:**
    - Abre IntelliJ IDEA y carga tu proyecto.
    - Asegúrate de tener configurado tu proyecto como un proyecto Java.

2. **Agregar Dependencias:**
    - Para JUnit: Agrega la dependencia JUnit a tu archivo `pom.xml` o `build.gradle`. Por ejemplo, para Maven:
      ```xml
      <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>5.7.2</version>
          <scope>test</scope>
      </dependency>
      ```
    - Para TestNG: Agrega la dependencia TestNG de manera similar.

3. **Creación de Tests:**
    - Crea tus clases de prueba (test classes) y métodos de prueba utilizando las anotaciones proporcionadas por JUnit o TestNG.

4. **Ejecución de Tests:**
    - Puedes ejecutar los tests haciendo clic derecho en la clase o el método de prueba y seleccionando "Run".

## Configuración del Proyecto con Archivo de Configuración

Además de las instrucciones previas, es esencial incluir un archivo de configuración para gestionar las bibliotecas y dependencias en IntelliJ IDEA. Agrega el siguiente contenido al archivo `.iml` de tu proyecto:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4">
  <component name="NewModuleRootManager" inherit-compiler-output="true">
    <exclude-output />
    <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
    </content>
    <orderEntry type="inheritedJdk" />
    <orderEntry type="sourceFolder" forTests="false" />
    <!-- JUnit -->
    <orderEntry type="module-library">
      <library name="JUnit4">
        <CLASSES>
          <root url="jar://$MAVEN_REPOSITORY$/junit/junit/4.13.1/junit-4.13.1.jar!/" />
          <root url="jar://$MAVEN_REPOSITORY$/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar!/" />
        </CLASSES>
        <JAVADOC />
        <SOURCES />
      </library>
    </orderEntry>
    <!-- TestNG -->
    <orderEntry type="module-library">
      <library name="testng">
        <CLASSES>
          <!-- Lista de dependencias de TestNG -->
          <root url="jar://$MAVEN_REPOSITORY$/org/testng/testng/7.1.0/testng-7.1.0.jar!/" />
          <!-- Otras dependencias de TestNG -->
        </CLASSES>
        <JAVADOC />
        <SOURCES />
      </library>
    </orderEntry>
    <!-- JUnit 5 -->
    <orderEntry type="module-library">
      <library name="JUnit5.8.1">
        <CLASSES>
          <!-- Lista de dependencias de JUnit 5 -->
          <root url="jar://$MAVEN_REPOSITORY$/org/junit/jupiter/junit-jupiter/5.8.1/junit-jupiter-5.8.1.jar!/" />
          <!-- Otras dependencias de JUnit 5 -->
        </CLASSES>
        <JAVADOC />
        <SOURCES />
      </library>
    </orderEntry>
  </component>
</module>
```

Este archivo de configuración especifica las bibliotecas necesarias para JUnit 4, TestNG y JUnit 5. Asegúrate de modificar las versiones según tus necesidades.

Este archivo `.iml` es fundamental para que IntelliJ IDEA reconozca las dependencias y las incluya en el classpath de tu proyecto.

## Implementación en Eclipse

Para implementar JUnit y TestNG en Eclipse, sigue estos pasos:

1. **Configuración del Proyecto:**
    - Abre Eclipse y carga tu proyecto.
    - Asegúrate de que el proyecto esté configurado como un proyecto Java.

2. **Agregar Dependencias:**
    - Para JUnit: Agrega la biblioteca JUnit al proyecto desde las configuraciones del proyecto.
    - Para TestNG: Agrega la biblioteca TestNG de manera similar.

3. **Creación de Tests:**
    - Crea tus clases de prueba y métodos de prueba utilizando las anotaciones proporcionadas por JUnit o TestNG.

4. **Ejecución de Tests:**
    - Puedes ejecutar los tests haciendo clic derecho en la clase o el método de prueba y seleccionando "Run as" > "JUnit Test" o "TestNG Test".


Contribuciones
¡Las contribuciones son bienvenidas! Si encuentras errores, mejoras o deseas agregar más ejemplos, no dudes en enviar un pull request.
