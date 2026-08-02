# Registro de cambios

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