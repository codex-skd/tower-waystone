# Graph Report - 26.1.2  (2026-07-27)

## Corpus Check
- 51 files · ~73,758 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 113 nodes · 110 edges · 18 communities
- Extraction: 99% EXTRACTED · 1% INFERRED · 0% AMBIGUOUS · INFERRED: 1 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- WaystoneNamer
- WaystoneTowersMod.java
- Registro de cambios
- Flujo de trabajo — Tower Waystone (NeoForge)
- CurseForge — Variables del proyecto
- Publicación a GitHub (CI/CD)
- Formato de descripciones CurseForge
- Tower Waystone
- Ramas
- Versionado
- gradlew

## God Nodes (most connected - your core abstractions)
1. `Flujo de trabajo — Tower Waystone (NeoForge)` - 13 edges
2. `CurseForge — Variables del proyecto` - 13 edges
3. `Registro de cambios` - 11 edges
4. `Publicación a GitHub (CI/CD)` - 11 edges
5. `Formato de descripciones CurseForge` - 7 edges
6. `WaystoneNamer` - 5 edges
7. `Tower Waystone` - 5 edges
8. `Ramas` - 5 edges
9. `WaystoneTowersMod` - 4 edges
10. `Versionado` - 4 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Import Cycles
- None detected.

## Communities (18 total, 0 thin omitted)

### Community 0 - "WaystoneNamer"
Cohesion: 0.43
Nodes (5): BlockPos, Load, ServerLevel, WaystoneNamer, SubscribeEvent

### Community 1 - "WaystoneTowersMod.java"
Cohesion: 0.53
Nodes (4): IEventBus, Logger, Mod, WaystoneTowersMod

### Community 2 - "Registro de cambios"
Cohesion: 0.08
Nodes (23): 1.0.10 — 2026-07-08, 1.0.15 — 2026-07-10, 1.0.16 — 2026-07-10, 1.0.17 — 2026-07-10, 1.0.18 — 2026-07-11, 1.0.6 — 2026-07-08, 1.0.7 — 2026-07-08, 1.0.8 — 2026-07-08 (+15 more)

### Community 4 - "Flujo de trabajo — Tower Waystone (NeoForge)"
Cohesion: 0.13
Nodes (14): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Ejemplos, Ejemplos, Ficheros de documentación, Flujo de trabajo — Tower Waystone (NeoForge), Formato del tag (+6 more)

### Community 5 - "CurseForge — Variables del proyecto"
Cohesion: 0.14
Nodes (13): Changelog, CurseForge — Variables del proyecto, Descripcion del proyecto, Estructura del changelog (HTML), Flujo completo, Parámetros del upload, Proyecto, Rama (+5 more)

### Community 6 - "Publicación a GitHub (CI/CD)"
Cohesion: 0.18
Nodes (11): 1. Desarrollo, 2. Copiar a instancia de pruebas, 3. Probar en instancia, 4. Preparar versión para CurseForge, 5. Release estable, 6. Actualizar Knowledge Graph (Graphify), Archivos que pasan a GitHub, .gitlab-ci.yml (+3 more)

### Community 7 - "Formato de descripciones CurseForge"
Cohesion: 0.22
Nodes (9): Archivos de CurseForge, Buenas prácticas, Ejemplo de estructura HTML para release notes, Elementos HTML disponibles, Elementos HTML permitidos, Estructura de la descripción general, Estructura del proyecto, Formato de descripciones CurseForge (+1 more)

### Community 8 - "Tower Waystone"
Cohesion: 0.33
Nodes (5): Building, License, Requirements, Tower Waystone, Variants

### Community 9 - "Ramas"
Cohesion: 0.40
Nodes (5): Ejemplos, Esquema de publicación, Estructura, Inicialización única de cada rama `*/main`, Ramas

### Community 10 - "Versionado"
Cohesion: 0.50
Nodes (4): ¿Cuándo incrementar versión?, Esquema, Nombre del JAR, Versionado

### Community 11 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

## Knowledge Gaps
- **62 isolated node(s):** `Added`, `Changed`, `Cambiado`, `Corregido`, `Cambiado` (+57 more)
  These have ≤1 connection - possible missing edges or undocumented components.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Flujo de trabajo — Tower Waystone (NeoForge)` connect `Flujo de trabajo — Tower Waystone (NeoForge)` to `Ramas`, `Versionado`, `Publicación a GitHub (CI/CD)`, `Formato de descripciones CurseForge`?**
  _High betweenness centrality (0.127) - this node is a cross-community bridge._
- **Why does `Publicación a GitHub (CI/CD)` connect `Publicación a GitHub (CI/CD)` to `Flujo de trabajo — Tower Waystone (NeoForge)`?**
  _High betweenness centrality (0.060) - this node is a cross-community bridge._
- **Why does `Estructura del proyecto` connect `Formato de descripciones CurseForge` to `Flujo de trabajo — Tower Waystone (NeoForge)`?**
  _High betweenness centrality (0.046) - this node is a cross-community bridge._
- **What connects `Added`, `Changed`, `Cambiado` to the rest of the system?**
  _62 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Registro de cambios` be split into smaller, more focused modules?**
  _Cohesion score 0.08333333333333333 - nodes in this community are weakly interconnected._
- **Should `Flujo de trabajo — Tower Waystone (NeoForge)` be split into smaller, more focused modules?**
  _Cohesion score 0.13333333333333333 - nodes in this community are weakly interconnected._
- **Should `CurseForge — Variables del proyecto` be split into smaller, more focused modules?**
  _Cohesion score 0.14285714285714285 - nodes in this community are weakly interconnected._