# Graph Report - 26.2  (2026-08-03)

## Corpus Check
- 60 files · ~72,014 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 209 nodes · 281 edges · 48 communities (47 shown, 1 thin omitted)
- Extraction: 94% EXTRACTED · 6% INFERRED · 0% AMBIGUOUS · INFERRED: 18 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `80ee824b`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- WaystoneNamer
- WaystoneTowersMod.java
- gradlew
- CurseForge � Variables del proyecto
- Flujo de trabajo � Tower Waystone (NeoForge)
- Tower Waystone
- Registro de cambios
- 0.0.0-beta.2 — 2026-07-27
- 1.0.15 — 2026-07-10
- 0.0.0-beta.1 — 2026-07-27
- .buildProcessor
- 0.0.0-beta.2 — 2026-07-27
- 1.0.15 — 2026-07-10
- 0.0.0-beta.1 — 2026-07-27
- 1.0.10.md
- 1.0.17.md
- 1.0.18.md
- 0.0.0-beta.7 — 2026-07-28
- 1.0.0 — 2026-07-28
- 1.0.10 — 2026-07-08
- 1.0.16 — 2026-07-10
- 1.0.18 — 2026-07-11
- 1.0.7 — 2026-07-08
- 1.0.9 — 2026-07-08
- Logger

## God Nodes (most connected - your core abstractions)
1. `Registro de cambios` - 20 edges
2. `DimensionEntry` - 19 edges
3. `DimensionEntry` - 17 edges
4. `DynamicStructureRegistry` - 15 edges
5. `Flujo de trabajo — Tower Waystone (NeoForge)` - 14 edges
6. `CurseForge — Variables del proyecto` - 13 edges
7. `WaystoneNamer` - 8 edges
8. `Custom Dimensions — Tower Waystone` - 7 edges
9. `Custom Dimensions — Tower Waystone` - 7 edges
10. `CustomDimensionConfig` - 6 edges

## Surprising Connections (you probably didn't know these)
- `CustomDimensionConfig` --references--> `DimensionEntry`  [EXTRACTED]
  src/main/java/com/skd/towerwaystone/CustomDimensionConfig.java → src/main/java/com/skd/towerwaystone/CustomDimensionConfig.java  _Bridges community 11 → community 9_

## Import Cycles
- None detected.

## Communities (48 total, 1 thin omitted)

### Community 0 - "WaystoneNamer"
Cohesion: 0.33
Nodes (8): BlockPos, Entry, Load, Post, ServerLevel, PendingWaystone, WaystoneNamer, SubscribeEvent

### Community 1 - "WaystoneTowersMod.java"
Cohesion: 0.39
Nodes (5): IEventBus, Mod, Logger, TowerWaystone, WaystoneTowersMod

### Community 2 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 5 - "CurseForge � Variables del proyecto"
Cohesion: 0.14
Nodes (13): Changelog, CurseForge — Variables del proyecto, Descripcion del proyecto, Estructura del changelog (HTML), Flujo completo, Parámetros del upload, Proyecto, Rama (+5 more)

### Community 6 - "Flujo de trabajo � Tower Waystone (NeoForge)"
Cohesion: 0.12
Nodes (15): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Tower Waystone (NeoForge), Flujo por tarea, Idioma (+7 more)

### Community 7 - "Tower Waystone"
Cohesion: 0.33
Nodes (5): Building, License, Requirements, Tower Waystone, Variants

### Community 8 - "Registro de cambios"
Cohesion: 0.15
Nodes (12): 0.0.0-beta.1 — 2026-07-27, 1.0.0 — 2026-07-28, 1.0.17 — 2026-07-10, 1.0.18 — 2026-07-11, 1.0.1 — 2026-08-02, Added, Cambiado, Cambiado (+4 more)

### Community 9 - "0.0.0-beta.2 — 2026-07-27"
Cohesion: 0.15
Nodes (9): Block, BlockState, DimensionEntry, Identifier, ProcessorRule, RegisterEvent, DimensionEntry, DynamicStructureRegistry (+1 more)

### Community 10 - "1.0.15 — 2026-07-10"
Cohesion: 0.25
Nodes (7): Custom Dimensions — Tower Waystone, Example — The Aether, Example — Twilight Forest, Fallback behavior, How it works, Multiple dimensions, Structure

### Community 11 - "0.0.0-beta.1 — 2026-07-27"
Cohesion: 0.27
Nodes (3): CustomDimensionConfig, Gson, CustomDimensionConfig

### Community 15 - ".buildProcessor"
Cohesion: 0.25
Nodes (7): Custom Dimensions — Tower Waystone, Example — The Aether, Example — Twilight Forest, Fallback behavior, How it works, Multiple dimensions, Structure

### Community 16 - "0.0.0-beta.2 — 2026-07-27"
Cohesion: 0.50
Nodes (4): 0.0.0-beta.2 — 2026-07-27, Added, Added, Changed

### Community 17 - "1.0.15 — 2026-07-10"
Cohesion: 0.50
Nodes (4): 1.0.15 — 2026-07-10, Cambiado, Cambiado, Eliminado

### Community 18 - "0.0.0-beta.1 — 2026-07-27"
Cohesion: 0.50
Nodes (3): CLAUDE.md — tower_waystone (26.2), Prioridad de instrucciones, Workflow del mod

### Community 22 - "1.0.10.md"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.4 — 2026-07-28, Fixed, Fixed

### Community 23 - "1.0.17.md"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.5 — 2026-07-28, Added, Added

### Community 24 - "1.0.18.md"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.6 — 2026-07-28, Fixed, Fixed

### Community 25 - "0.0.0-beta.7 — 2026-07-28"
Cohesion: 0.50
Nodes (4): 0.0.0-beta.7 — 2026-07-28, 1.0.2 — 2026-08-03, Fixed, Fixed

### Community 26 - "1.0.0 — 2026-07-28"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 27 - "1.0.10 — 2026-07-08"
Cohesion: 0.29
Nodes (7): 1.0.10 — 2026-07-08, 1.0.6 — 2026-07-08, 1.0.8 — 2026-07-08, Corregido, Corregido, Corregido, Corregido

### Community 28 - "1.0.16 — 2026-07-10"
Cohesion: 0.67
Nodes (3): 1.0.16 — 2026-07-10, Cambiado, Cambiado

### Community 29 - "1.0.18 — 2026-07-11"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.3 — 2026-07-27, Fixed, Fixed

### Community 31 - "1.0.7 — 2026-07-08"
Cohesion: 0.67
Nodes (3): 1.0.7 — 2026-07-08, Cambiado, Cambiado

### Community 33 - "1.0.9 — 2026-07-08"
Cohesion: 0.67
Nodes (3): 1.0.9 — 2026-07-08, Corregido, Corregido

## Knowledge Gaps
- **72 isolated node(s):** `Workflow del mod`, `Prioridad de instrucciones`, `Refactor`, `Added`, `Fixed` (+67 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **1 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Registro de cambios` connect `Registro de cambios` to `1.0.9 — 2026-07-08`, `0.0.0-beta.2 — 2026-07-27`, `1.0.15 — 2026-07-10`, `1.0.10.md`, `1.0.17.md`, `1.0.18.md`, `0.0.0-beta.7 — 2026-07-28`, `1.0.10 — 2026-07-08`, `1.0.16 — 2026-07-10`, `1.0.18 — 2026-07-11`, `1.0.7 — 2026-07-08`?**
  _High betweenness centrality (0.059) - this node is a cross-community bridge._
- **Why does `DimensionEntry` connect `0.0.0-beta.2 — 2026-07-27` to `0.0.0-beta.1 — 2026-07-27`?**
  _High betweenness centrality (0.018) - this node is a cross-community bridge._
- **Why does `DimensionEntry` connect `0.0.0-beta.2 — 2026-07-27` to `0.0.0-beta.1 — 2026-07-27`?**
  _High betweenness centrality (0.015) - this node is a cross-community bridge._
- **What connects `Workflow del mod`, `Prioridad de instrucciones`, `Refactor` to the rest of the system?**
  _72 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `CurseForge � Variables del proyecto` be split into smaller, more focused modules?**
  _Cohesion score 0.14285714285714285 - nodes in this community are weakly interconnected._
- **Should `Flujo de trabajo � Tower Waystone (NeoForge)` be split into smaller, more focused modules?**
  _Cohesion score 0.125 - nodes in this community are weakly interconnected._