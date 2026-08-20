# Graph Report - 26.2  (2026-08-20)

## Corpus Check
- 86 files · ~76,004 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 258 nodes · 316 edges · 79 communities (41 shown, 38 thin omitted)
- Extraction: 96% EXTRACTED · 4% INFERRED · 0% AMBIGUOUS · INFERRED: 14 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `f35c3997`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- WaystoneNamer
- WaystoneTowersMod.java
- gradlew
- settings.gradle
- CurseForge � Variables del proyecto
- Flujo de trabajo � Tower Waystone (NeoForge)
- Tower Waystone
- Registro de cambios
- 0.0.0-beta.2 — 2026-07-27
- 1.0.15 — 2026-07-10
- 0.0.0-beta.1 — 2026-07-27
- 1.0.10 — 2026-07-08
- 1.0.16 — 2026-07-10
- 1.0.17 — 2026-07-10
- .buildProcessor
- 0.0.0-beta.2 — 2026-07-27
- 1.0.15 — 2026-07-10
- 0.0.0-beta.1 — 2026-07-27
- project_description.md
- 0.0.0-beta.1.md
- 0.0.0-beta.2.md
- 1.0.10.md
- 1.0.17.md
- 1.0.18.md
- 0.0.0-beta.7 — 2026-07-28
- 1.0.0 — 2026-07-28
- 1.0.10 — 2026-07-08
- 1.0.16 — 2026-07-10
- 1.0.18 — 2026-07-11
- 1.0.7 — 2026-07-08
- 1.0.8 — 2026-07-08
- 1.0.9 — 2026-07-08
- 0.0.0-beta.6.md
- 0.0.0-beta.7.md
- 1.0.0.md
- project_description.md
- Logger
- 1.0.18 — 2026-07-11
- 1.0.1 — 2026-08-02
- 1.0.1 — 2026-08-02
- 1.0.2 — 2026-08-03
- 1.0.2 — 2026-08-03
- [1.0.3] - 2026-08-05
- 1.0.6 — 2026-07-08
- 1.0.7 — 2026-07-08
- 1.0.8 — 2026-07-08
- 1.0.9 — 2026-07-08
- 1.0.8 — 2026-07-08
- 1.0.9 — 2026-07-08
- Gson
- 1.0.8 — 2026-07-08
- 1.0.8 — 2026-07-08
- 1.0.9 — 2026-07-08
- 1.0.9 — 2026-07-08
- [1.0.9] - 2026-08-16
- [1.1.0] - 2026-08-19

## God Nodes (most connected - your core abstractions)
1. `Registro de cambios` - 49 edges
2. `DimensionEntry` - 17 edges
3. `DynamicStructureRegistry` - 15 edges
4. `CurseForge — Variables del proyecto` - 13 edges
5. `Flujo de trabajo — Tower Waystone (NeoForge)` - 11 edges
6. `Settings` - 8 edges
7. `WaystoneBeaconClientData` - 7 edges
8. `WaystoneNamer` - 7 edges
9. `Custom Dimensions — Tower Waystone` - 7 edges
10. `WaystoneBeaconConfig` - 6 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Import Cycles
- None detected.

## Communities (79 total, 38 thin omitted)

### Community 0 - "WaystoneNamer"
Cohesion: 0.30
Nodes (8): Entry, ServerLevel, BlockPos, Load, Post, SubscribeEvent, PendingWaystone, WaystoneNamer

### Community 1 - "WaystoneTowersMod.java"
Cohesion: 0.24
Nodes (6): FMLClientSetupEvent, CustomDimensionConfig, IEventBus, Mod, Logger, TowerWaystone

### Community 2 - "gradlew"
Cohesion: 0.23
Nodes (7): Gson, Logger, Settings, WaystoneBeaconConfig, SubscribeEvent, WaystoneBeaconRenderer, SubmitCustomGeometryEvent

### Community 4 - "settings.gradle"
Cohesion: 0.27
Nodes (6): BlockPos, Load, Post, SubscribeEvent, WaystoneBeaconClientData, Unload

### Community 5 - "CurseForge � Variables del proyecto"
Cohesion: 0.14
Nodes (13): Changelog, CurseForge — Variables del proyecto, Descripcion del proyecto, Estructura del changelog (HTML), Flujo completo, Parámetros del upload, Proyecto, Rama (+5 more)

### Community 6 - "Flujo de trabajo � Tower Waystone (NeoForge)"
Cohesion: 0.15
Nodes (12): Buenas prácticas, Commits (Conventional Commits), Convenciones de nomenclatura, Específico del mod, Estructura del proyecto, Flujo de trabajo — Tower Waystone (NeoForge), Flujo por tarea, Idioma (+4 more)

### Community 7 - "Tower Waystone"
Cohesion: 0.33
Nodes (5): Building, License, Requirements, Tower Waystone, Variants

### Community 9 - "0.0.0-beta.2 — 2026-07-27"
Cohesion: 0.18
Nodes (8): Block, BlockState, DimensionEntry, Identifier, ProcessorRule, RegisterEvent, DynamicStructureRegistry, StructureProcessorList

### Community 10 - "1.0.15 — 2026-07-10"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.2 — 2026-07-27, Added, Changed

### Community 11 - "0.0.0-beta.1 — 2026-07-27"
Cohesion: 0.67
Nodes (3): 1.0.15 — 2026-07-10, Cambiado, Eliminado

### Community 12 - "1.0.10 — 2026-07-08"
Cohesion: 0.67
Nodes (3): [1.0.6] - 2026-08-15, Added, Notes

### Community 15 - ".buildProcessor"
Cohesion: 0.25
Nodes (7): Custom Dimensions — Tower Waystone, Example — The Aether, Example — Twilight Forest, Fallback behavior, How it works, Multiple dimensions, Structure

### Community 16 - "0.0.0-beta.2 — 2026-07-27"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.2 — 2026-07-27, Added, Changed

### Community 17 - "1.0.15 — 2026-07-10"
Cohesion: 0.67
Nodes (3): 1.0.15 — 2026-07-10, Cambiado, Eliminado

### Community 18 - "0.0.0-beta.1 — 2026-07-27"
Cohesion: 0.50
Nodes (3): CLAUDE.md — tower_waystone (26.2), Prioridad de instrucciones, Workflow del mod

### Community 20 - "0.0.0-beta.1.md"
Cohesion: 0.67
Nodes (3): [1.0.5] - 2026-08-14, Added, Fixed

### Community 26 - "1.0.0 — 2026-07-28"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 27 - "1.0.10 — 2026-07-08"
Cohesion: 0.15
Nodes (12): 1.0.10 — 2026-07-08, 1.0.16 — 2026-07-10, 1.0.1 — 2026-08-02, 1.0.2 — 2026-08-03, 1.0.6 — 2026-07-08, Cambiado, Corregido, Corregido (+4 more)

## Knowledge Gaps
- **88 isolated node(s):** `Workflow del mod`, `Prioridad de instrucciones`, `Change`, `Change`, `Fixed` (+83 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **38 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Registro de cambios` connect `1.0.10 — 2026-07-08` to `Registro de cambios`, `1.0.15 — 2026-07-10`, `0.0.0-beta.1 — 2026-07-27`, `1.0.10 — 2026-07-08`, `1.0.16 — 2026-07-10`, `1.0.17 — 2026-07-10`, `0.0.0-beta.2 — 2026-07-27`, `1.0.15 — 2026-07-10`, `project_description.md`, `0.0.0-beta.1.md`, `0.0.0-beta.2.md`, `1.0.10.md`, `1.0.17.md`, `1.0.18.md`, `0.0.0-beta.7 — 2026-07-28`, `1.0.16 — 2026-07-10`, `1.0.18 — 2026-07-11`, `1.0.7 — 2026-07-08`, `1.0.8 — 2026-07-08`, `1.0.9 — 2026-07-08`, `0.0.0-beta.6.md`, `0.0.0-beta.7.md`, `1.0.0.md`, `project_description.md`, `1.0.18 — 2026-07-11`, `1.0.1 — 2026-08-02`, `1.0.1 — 2026-08-02`, `1.0.2 — 2026-08-03`, `1.0.2 — 2026-08-03`, `[1.0.3] - 2026-08-05`, `1.0.6 — 2026-07-08`, `1.0.7 — 2026-07-08`, `1.0.8 — 2026-07-08`, `1.0.9 — 2026-07-08`, `1.0.8 — 2026-07-08`, `1.0.9 — 2026-07-08`, `1.0.8 — 2026-07-08`, `1.0.8 — 2026-07-08`, `1.0.9 — 2026-07-08`, `1.0.9 — 2026-07-08`, `[1.0.9] - 2026-08-16`, `[1.1.0] - 2026-08-19`?**
  _High betweenness centrality (0.155) - this node is a cross-community bridge._
- **Why does `WaystoneBeaconClientData` connect `settings.gradle` to `WaystoneTowersMod.java`?**
  _High betweenness centrality (0.014) - this node is a cross-community bridge._
- **Why does `WaystoneNamer` connect `WaystoneNamer` to `WaystoneTowersMod.java`?**
  _High betweenness centrality (0.011) - this node is a cross-community bridge._
- **What connects `Workflow del mod`, `Prioridad de instrucciones`, `Change` to the rest of the system?**
  _88 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `CurseForge � Variables del proyecto` be split into smaller, more focused modules?**
  _Cohesion score 0.14285714285714285 - nodes in this community are weakly interconnected._