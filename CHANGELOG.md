# Registro de cambios


## [1.0.7] - 2026-08-15

### Fixed

- **Torres nuevas mal colocadas / apareciendo bajo el agua**: las NBT de `simply_waystone_tower`/`_ruins`/`_pillager` tienen el suelo (cobblestone) directamente en `y=0`, sin sótano de tierra como las torres propias del mod (que sí tienen 5 bloques de tierra bajo la planta y por eso usan `start_height.absolute = -6`). Al reutilizar ese mismo offset, las 3 familias nuevas quedaban hundidas ~6 bloques en el terreno. Corregido a `start_height.absolute = 0` en `simply_waystone_tower.json`, `simply_waystone_tower_ruins.json` y `simply_waystone_tower_pillager.json`.
- Quitados `minecraft:swamp` y `minecraft:mangrove_swamp` de la tag de biomas de `simply_waystone_tower_ruins` — esos biomas tienen charcas de agua superficial que hacían aparecer la torre bajo el agua incluso con el offset corregido.
- **Haz de luz demasiado corto**: el haz configurable añadido en 1.0.6 se cortaba a pocos bloques por encima del waystone (campo `height` del config, por defecto 6). Se ajusta el punto de inicio del haz a la parte superior del bloque de waystone (que ocupa 2 bloques de alto) y se sube el valor por defecto de `height` a **100** bloques, mucho más visible en la práctica. El campo sigue siendo configurable en `waystone_beacon.json` — un valor inválido (`<= 0`) cae de vuelta al valor por defecto.

## [1.0.6] - 2026-08-15

### Added

- **Haz de luz configurable sobre los waystones**: cada waystone generado por una torre del mod ahora renderiza un haz de luz vertical estilo beacon (client-side, puramente visual). Inspirado en el mod de referencia `waystonebeacons-1.0.0.jar`, pero implementado de forma independiente sin Mixin: usa el evento `net.neoforged.neoforge.client.event.SubmitCustomGeometryEvent` (pipeline de renderizado basado en "submission" de esta versión de NeoForge) y reutiliza `BeaconRenderer.submitBeaconBeam(...)` de vanilla para dibujar el haz.
- **Configuración real**: `config/tower_waystone/waystone_beacon.json` (mismo patrón Gson que `custom_dimensions.json`) con `enabled` (on/off), `color` (RGB 0-255) y `height` (altura del haz en bloques). A diferencia del mod de referencia, cuyos valores de haz estaban hardcodeados pese a tener una clase de config sin usar, aquí los parámetros se leen de verdad del archivo.
- Detección de waystones vía chunk load/unload (`WaystoneBeaconClientData`), independiente del renderer interno del mod Waystones — no se rompe si Waystones cambia su implementación de render.

### Notes
<blockquote>Cambio puramente client-side y visual. No afecta a la generación de mundo, guardado, ni comportamiento en servidor dedicado.</blockquote>

## [1.0.5] - 2026-08-14

### Added

- **3 nuevas familias de torres** portadas desde el mod `simply_waystone_tower` (Forge 1.20.1, MCreator), adaptadas al sistema de jigsaw/structure de este mod:
  - `simply_waystone_tower` (3 variantes): torres genéricas de piedra, biomas templados (plains, forest, savanna, windswept...).
  - `simply_waystone_tower_ruins` (4 variantes): torres en ruinas con mob spawner/loot en algunas, biomas boscosos/pantanosos (jungle, taiga, swamp, dark_forest).
  - `simply_waystone_tower_pillager` (2 variantes): torres temáticas de saqueadores, biomas de avanzadilla (plains, savanna, desert, snowy_plains, taiga).
  - Se excluyeron 2 variantes de ruinas del pack original (`broken_1`, `broken_6`) por no incluir un bloque waystone en su NBT original.

### Fixed

- **Waystone inexistente en las 4 torres originales**: `waystone_tower.nbt`, `mossy_waystone_tower.nbt`, `sandy_waystone_tower.nbt` y `snowy_waystone_tower.nbt` referenciaban el bloque legacy `waystones:waystone` / `waystones:mossy_waystone` / `waystones:sandy_waystone`, IDs que ya no existen en la versión de Waystones usada por el proyecto (`26.2.0.5`, que solo registra variantes con nombre de material). Como consecuencia, esas torres generaban sin ningún waystone real (el juego trata el bloque desconocido como aire). Se remapearon a los IDs vigentes: `andesite_waystone`, `mossy_andesite_waystone`, `sandstone_waystone`.

## [1.0.4] - 2026-08-12

### Change

- **Nombre de JAR con versión del cargador**: el artefacto ahora se compila como `tower_waystone-26.2-neoforge-26.2.0.37-beta-1.0.4.jar` (se añade la versión de cargador/NeoForge al nombre del archivo). Empaquetado y documentación; sin cambios de funcionalidad.

## 1.0.2 — 2026-08-03
### Fixed
- Nombrado automático de waystones: el reintento usaba `level.getServer().execute(...)`, que en el hilo del servidor se ejecuta de forma síncrona e inmediata en vez de esperar ticks reales — los 10 reintentos se consumían al instante y las waystones generadas por worldgen (en lo alto de las torres) podían quedar sin nombre. Ahora el reintento se procesa en `ServerTickEvent.Post`, un intento por tick real.

## 1.0.1 — 2026-08-02
### Refactor
- Clase principal `WaystoneTowersMod` → `TowerWaystone` para cumplir la convención de nomenclatura del proyecto. Sin cambios de config ni de generación.

## 1.0.0 — 2026-07-28
### Added
- Primera versión estable para Minecraft 26.2
- 8 variantes de torre: 4 Overworld + 2 Nether + 2 End
- Soporte de dimensiones custom vía archivo de configuración
- Nombrado automático de waystones con nombres fantásticos

## 0.0.0-beta.7 — 2026-07-28
### Fixed
- Custom dimensions del config ahora usan `UniformHeight` (rango 20-60) en vez de `project_start_to_heightmap` — evita torres flotantes en dimensiones tipo End

## 0.0.0-beta.6 — 2026-07-28
### Fixed
- End towers ya no aparecen flotando en el vacío — removido `project_start_to_heightmap` y ajustado `start_height` a rango uniforme 30-60 para islas del End

## 0.0.0-beta.5 — 2026-07-28
### Added
- **Custom dimension support**: add `config/tower_waystone/custom_dimensions.json` to generate towers in any modded dimension
- Block validation with automatic fallback — invalid blocks fall back to defaults, server won't crash
- Documentation in `docs/custom_dimensions.md`

## 0.0.0-beta.4 — 2026-07-28
### Fixed
- Corregido `end_purpur_processor.json`: `minecraft:purpur_wall` no existe — reemplazado por `end_stone_brick_wall`
- El servidor ya no falla al cargar el procesador de la torre de púrpura del End

## 0.0.0-beta.3 — 2026-07-27
### Fixed
- Corregido el nombre del JAR en el script de subida a CurseForge — el `{version}` ahora se interpola correctamente como f-string

## 0.0.0-beta.2 — 2026-07-27
### Added
- **Nether blackstone towers** — generate in Nether biomes using polished blackstone
- **Nether brick towers** — generate in Nether biomes using nether bricks
- **End stone towers** — generate in End biomes using end stone bricks
- **End purpur towers** — generate in End biomes using purpur blocks
- All new variants reuse the existing tower NBT with block-replacement processors

### Changed
- Updated README with 8 tower variants (4 Overworld + 2 Nether + 2 End)

## 0.0.0-beta.1 — 2026-07-27
### Cambiado
- Portado de Minecraft 26.1.2 a **26.2** (NeoForge 26.2.0.32-beta)
- Adaptado el esqueleto del proyecto al template `26.2-26.2.0.32-beta`
- Actualizado `build.gradle`: NeoGradle `2.0.142`, Java 25
- Actualizada dependencia de Waystones a `26.2-26.2.0.5`

## 1.0.18 — 2026-07-11
### Cambiado
- Reestructurado el repositorio siguiendo el flujo de trabajo definido en `docs/WORKFLOW.md`:
  - Rama `minecraft/26.1.2/neoforge-26.1.2.78/production` para desarrollo activo
  - Formato de JAR: `<mod_id>-<mc_version>-neoforge-<version>.jar`
  - Formato de tags: `<mc_version>-neoforge-<version>`
- Actualizado `docs/WORKFLOW.md`: secciones de Ramas, Tags y formato de JAR
- Actualizado `build.gradle` para el nuevo formato de nombre de JAR

## 1.0.17 — 2026-07-10
### Corregido
- El nombrado de waystones ya no sobreescribe nombres existentes — ignora waystones que ya tienen nombre o fueron colocadas por un jugador

## 1.0.16 — 2026-07-10
### Cambiado
- Refinadas las etiquetas de bioma por variante para que cada torre solo se genere en biomas temáticamente apropiados (arenosa → desierto/badlands, musgosa → jungla/pantano/taiga, nevada → congelado, normal → templado)

## 1.0.15 — 2026-07-10
### Cambiado
- Nombrado de waystones reescrito para usar la API de Waystones directamente (`WaystonesAPI.getWaystoneAt` + `MutableWaystone.setName`) en lugar de reflexión NBT — corrige el nombrado en el sistema de Data Components de 1.21.4
- Agregado `waystones-neoforge-26.1.2-26.1.2.8.jar` como dependencia de compilación desde `libs/`

### Eliminado
- Enfoque de inyección NBT (incompatible con Data Components de 1.21.4)

## 1.0.10 — 2026-07-08
### Corregido
- El codec del procesador usa MapCodec singleton (siguiendo el patrón de NopProcessor)

## 1.0.9 — 2026-07-08
### Corregido
- Sobrescritos ambos `process()` y `processBlock()` para protegerse contra cambios de método

## 1.0.8 — 2026-07-08
### Corregido
- Lógica NBT del procesador, uso de Supplier para MapCodec

## 1.0.7 — 2026-07-08
### Cambiado
- Procesador no-op para aislar el problema de generación

## 1.0.6 — 2026-07-08
### Corregido
- Terrain adaptation a `none`, heightmap a `OCEAN_FLOOR_WG---

## [1.0.3] - 2026-08-05

### Change

- **Recompilado contra NeoForge `26.2.0.37-beta`**: bump de `neo_version` en `gradle.properties` (`26.2.0.32-beta` -> `26.2.0.37-beta`). Verificado con `runServer` (arranque sin errores).
- **Added balm and shogi jars to libs/ (Waystones dev-time dependencies) so the dev server can load Waystones.**

## [gistro de cambios

## 1.0.2 — 2026-08-03
### Fixed
- Nombrado automático de waystones: el reintento usaba `level.getServer().execute(...)`, que en el hilo del servidor se ejecuta de forma síncrona e inmediata en vez de esperar ticks reales — los 10 reintentos se consumían al instante y las waystones generadas por worldgen (en lo alto de las torres) podían quedar sin nombre. Ahora el reintento se procesa en `ServerTickEvent.Post`, un intento por tick real.

## 1.0.1 — 2026-08-02
### Refactor
- Clase principal `WaystoneTowersMod` → `TowerWaystone` para cumplir la convención de nomenclatura del proyecto. Sin cambios de config ni de generación.

## 1.0.0 — 2026-07-28
### Added
- Primera versión estable para Minecraft 26.2
- 8 variantes de torre: 4 Overworld + 2 Nether + 2 End
- Soporte de dimensiones custom vía archivo de configuración
- Nombrado automático de waystones con nombres fantásticos

## 0.0.0-beta.7 — 2026-07-28
### Fixed
- Custom dimensions del config ahora usan `UniformHeight` (rango 20-60) en vez de `project_start_to_heightmap` — evita torres flotantes en dimensiones tipo End

## 0.0.0-beta.6 — 2026-07-28
### Fixed
- End towers ya no aparecen flotando en el vacío — removido `project_start_to_heightmap` y ajustado `start_height` a rango uniforme 30-60 para islas del End

## 0.0.0-beta.5 — 2026-07-28
### Added
- **Custom dimension support**: add `config/tower_waystone/custom_dimensions.json` to generate towers in any modded dimension
- Block validation with automatic fallback — invalid blocks fall back to defaults, server won't crash
- Documentation in `docs/custom_dimensions.md`

## 0.0.0-beta.4 — 2026-07-28
### Fixed
- Corregido `end_purpur_processor.json`: `minecraft:purpur_wall` no existe — reemplazado por `end_stone_brick_wall`
- El servidor ya no falla al cargar el procesador de la torre de púrpura del End

## 0.0.0-beta.3 — 2026-07-27
### Fixed
- Corregido el nombre del JAR en el script de subida a CurseForge — el `{version}` ahora se interpola correctamente como f-string

## 0.0.0-beta.2 — 2026-07-27
### Added
- **Nether blackstone towers** — generate in Nether biomes using polished blackstone
- **Nether brick towers** — generate in Nether biomes using nether bricks
- **End stone towers** — generate in End biomes using end stone bricks
- **End purpur towers** — generate in End biomes using purpur blocks
- All new variants reuse the existing tower NBT with block-replacement processors

### Changed
- Updated README with 8 tower variants (4 Overworld + 2 Nether + 2 End)

## 0.0.0-beta.1 — 2026-07-27
### Cambiado
- Portado de Minecraft 26.1.2 a **26.2** (NeoForge 26.2.0.32-beta)
- Adaptado el esqueleto del proyecto al template `26.2-26.2.0.32-beta`
- Actualizado `build.gradle`: NeoGradle `2.0.142`, Java 25
- Actualizada dependencia de Waystones a `26.2-26.2.0.5`

## 1.0.18 — 2026-07-11
### Cambiado
- Reestructurado el repositorio siguiendo el flujo de trabajo definido en `docs/WORKFLOW.md`:
  - Rama `minecraft/26.1.2/neoforge-26.1.2.78/production` para desarrollo activo
  - Formato de JAR: `<mod_id>-<mc_version>-neoforge-<version>.jar`
  - Formato de tags: `<mc_version>-neoforge-<version>`
- Actualizado `docs/WORKFLOW.md`: secciones de Ramas, Tags y formato de JAR
- Actualizado `build.gradle` para el nuevo formato de nombre de JAR

## 1.0.17 — 2026-07-10
### Corregido
- El nombrado de waystones ya no sobreescribe nombres existentes — ignora waystones que ya tienen nombre o fueron colocadas por un jugador

## 1.0.16 — 2026-07-10
### Cambiado
- Refinadas las etiquetas de bioma por variante para que cada torre solo se genere en biomas temáticamente apropiados (arenosa → desierto/badlands, musgosa → jungla/pantano/taiga, nevada → congelado, normal → templado)

## 1.0.15 — 2026-07-10
### Cambiado
- Nombrado de waystones reescrito para usar la API de Waystones directamente (`WaystonesAPI.getWaystoneAt` + `MutableWaystone.setName`) en lugar de reflexión NBT — corrige el nombrado en el sistema de Data Components de 1.21.4
- Agregado `waystones-neoforge-26.1.2-26.1.2.8.jar` como dependencia de compilación desde `libs/`

### Eliminado
- Enfoque de inyección NBT (incompatible con Data Components de 1.21.4)

## 1.0.10 — 2026-07-08
### Corregido
- El codec del procesador usa MapCodec singleton (siguiendo el patrón de NopProcessor)

## 1.0.9 — 2026-07-08
### Corregido
- Sobrescritos ambos `process()` y `processBlock()` para protegerse contra cambios de método

## 1.0.8 — 2026-07-08
### Corregido
- Lógica NBT del procesador, uso de Supplier para MapCodec

## 1.0.7 — 2026-07-08
### Cambiado
- Procesador no-op para aislar el problema de generación

## 1.0.6 — 2026-07-08
### Corregido
- Terrain adaptation a `none`, heightmap a `OCEAN_FLOOR_WG`
