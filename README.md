# Smoke-Screen-1

## Generar el proyecto

Para generar el script de ejecucion del programa ejecutar el siguiente comando en la carpeta raiz del proyecto:
```shell
.\gradlew distZip
```
Esto va a generar un directorio `build`, donde se va a poder encontrar el archivo `.zip` para distribuir el programa. El mismo se encuentra en la carpeta `distributions` con el nombre `ClasificadorDeLunares-<version>.zip`.

## Ejecutar el programa

Se puede conseguir el zip con el programa en la seccion de releases o compilandolo como se indico en la seccion anterior. Una vez extraido se va a poder ejecutar desde los scripts en la carpeta `bin`.

### Linux

```shell
.\ClasificadorDeLunares
```

### Windows

Ejecutar el script

```shell
ClasificadorDeLunares.bat
```
