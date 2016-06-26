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

## Ejecucion de ejemplo

```shell
Ingrese la cantidad de lunares a evaluar:2
***************************************
Evaluando: Lunar 1
El lunar presenta:
	1) Forma Asimetrica
	2) Forma Simetrica
1
El lunar presenta:
	1) Borde regular
	2) Borde irregular
2
El lunar tiene:
	1) Color unico
	2) Color variado
2
El lunar tiene un diametro menor a 7mm? [S/N]: S
El lunar tiene relieve? [S/N]: S
El lunar presento alteraciones en el ultimo mes? [S/N]: S
El lunar genera comezon? [S/N]: S
El lunar fue expuesto al sol ultimamente? [S/N]: S

***************Resultado***************

El lunar Lunar 1 se diagnostica como un lunar sin diagnostico

***************************************
Evaluando: Lunar 2
El lunar presenta:
	1) Forma Asimetrica
	2) Forma Simetrica
1
El lunar presenta:
	1) Borde regular
	2) Borde irregular
2
El lunar tiene:
	1) Color unico
	2) Color variado
2
El lunar tiene un diametro menor a 7mm? [S/N]: N
El lunar tiene relieve? [S/N]: S
El lunar presento alteraciones en el ultimo mes? [S/N]: S
El lunar genera comezon? [S/N]: S
El lunar fue expuesto al sol ultimamente? [S/N]: N

***************Resultado***************

El lunar Lunar 2 se diagnostica como un Melanoma maligno
```
