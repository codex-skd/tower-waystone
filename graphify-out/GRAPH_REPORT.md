# Graph Report - 26.1.2  (2026-08-03)

## Corpus Check
- 61 files · ~72,538 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 230 nodes · 302 edges · 35 communities (34 shown, 1 thin omitted)
- Extraction: 94% EXTRACTED · 6% INFERRED · 0% AMBIGUOUS · INFERRED: 18 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `0ce3110c`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

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
- CustomDimensionConfig
- Logger

## God Nodes (most connected - your core abstractions)
1. `DimensionEntry` - 19 edges
2. `Registro de cambios` - 18 edges
3. `Flujo de trabajo — Tower Waystone (NeoForge)` - 18 edges
4. `DimensionEntry` - 17 edges
5. `DynamicStructureRegistry` - 15 edges
6. `CurseForge — Variables del proyecto` - 13 edges
7. `Publicación a GitHub (CI/CD)` - 11 edges
8. `WaystoneNamer` - 8 edges
9. `Custom Dimensions — Tower Waystone` - 7 edges
10. `Formato de descripciones CurseForge` - 7 edges

## Surprising Connections (you probably didn't know these)
- `CustomDimensionConfig` --references--> `Gson`  [EXTRACTED]
  src/main/java/com/skd/towerwaystone/CustomDimensionConfig.java →   _Bridges community 1 → community 9_

## Import Cycles
- None detected.

## Communities (35 total, 1 thin omitted)

### Community 0 - "WaystoneNamer"
Cohesion: 0.33
Nodes (8): BlockPos, Entry, Load, Post, ServerLevel, PendingWaystone, WaystoneNamer, SubscribeEvent

### Community 1 - "WaystoneTowersMod.java"
Cohesion: 0.24
Nodes (6): CustomDimensionConfig, IEventBus, Mod, Logger, TowerWaystone, WaystoneTowersMod

### Community 2 - "Registro de cambios"
Cohesion: 0.05
Nodes (45): 1.0.10 — 2026-07-08, 1.0.15 — 2026-07-10, 1.0.16 — 2026-07-10, 1.0.17 — 2026-07-10, 1.0.18 — 2026-07-11, 1.0.6 — 2026-07-08, 1.0.7 — 2026-07-08, 1.0.8 — 2026-07-08 (+37 more)

### Community 4 - "Flujo de trabajo — Tower Waystone (NeoForge)"
Cohesion: 0.05
Nodes (37): Archivos de CurseForge, Buenas prácticas, Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, ¿Cuándo incrementar versión?, Ejemplo de estructura HTML para release notes, Ejemplos (+29 more)

### Community 5 - "CurseForge — Variables del proyecto"
Cohesion: 0.14
Nodes (13): Changelog, CurseForge — Variables del proyecto, Descripcion del proyecto, Estructura del changelog (HTML), Flujo completo, Parámetros del upload, Proyecto, Rama (+5 more)

### Community 6 - "Publicación a GitHub (CI/CD)"
Cohesion: 0.18
Nodes (11): 1. Desarrollo, 2. Copiar a instancia de pruebas, 3. Probar en instancia, 4. Preparar versión para CurseForge, 5. Release estable, 6. Actualizar Knowledge Graph (Graphify), Archivos que pasan a GitHub, .gitlab-ci.yml (+3 more)

### Community 7 - "Formato de descripciones CurseForge"
Cohesion: 0.25
Nodes (7): Custom Dimensions — Tower Waystone, Example — The Aether, Example — Twilight Forest, Fallback behavior, How it works, Multiple dimensions, Structure

### Community 8 - "Tower Waystone"
Cohesion: 0.33
Nodes (5): Building, License, Requirements, Tower Waystone, Variants

### Community 9 - "Ramas"
Cohesion: 0.13
Nodes (11): Block, BlockState, DimensionEntry, Gson, Identifier, ProcessorRule, RegisterEvent, CustomDimensionConfig (+3 more)

### Community 10 - "Versionado"
Cohesion: 0.25
Nodes (7): Custom Dimensions — Tower Waystone, Example — The Aether, Example — Twilight Forest, Fallback behavior, How it works, Multiple dimensions, Structure

### Community 11 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 18 - "CustomDimensionConfig"
Cohesion: 0.50
Nodes (3): CLAUDE.md — tower_waystone (26.1.2), Prioridad de instrucciones, Workflow del mod

## Knowledge Gaps
- **92 isolated node(s):** `Workflow del mod`, `Prioridad de instrucciones`, `Refactor`, `Fixed`, `Fixed` (+87 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **1 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Flujo de trabajo — Tower Waystone (NeoForge)` connect `Flujo de trabajo — Tower Waystone (NeoForge)` to `Publicación a GitHub (CI/CD)`?**
  _High betweenness centrality (0.039) - this node is a cross-community bridge._
- **Why does `Publicación a GitHub (CI/CD)` connect `Publicación a GitHub (CI/CD)` to `Flujo de trabajo — Tower Waystone (NeoForge)`?**
  _High betweenness centrality (0.016) - this node is a cross-community bridge._
- **What connects `Workflow del mod`, `Prioridad de instrucciones`, `Refactor` to the rest of the system?**
  _92 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Registro de cambios` be split into smaller, more focused modules?**
  _Cohesion score 0.04541062801932367 - nodes in this community are weakly interconnected._
- **Should `Flujo de trabajo — Tower Waystone (NeoForge)` be split into smaller, more focused modules?**
  _Cohesion score 0.05405405405405406 - nodes in this community are weakly interconnected._
- **Should `CurseForge — Variables del proyecto` be split into smaller, more focused modules?**
  _Cohesion score 0.14285714285714285 - nodes in this community are weakly interconnected._
- **Should `Ramas` be split into smaller, more focused modules?**
  _Cohesion score 0.12624584717607973 - nodes in this community are weakly interconnected._