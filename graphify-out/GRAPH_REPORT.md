# Graph Report - 26.2  (2026-07-28)

## Corpus Check
- 58 files · ~71,120 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 137 nodes · 188 edges · 37 communities (24 shown, 13 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 9 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

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
- 1.0.6 — 2026-07-08
- 1.0.7 — 2026-07-08
- 1.0.8 — 2026-07-08
- 1.0.9 — 2026-07-08

## God Nodes (most connected - your core abstractions)
1. `DimensionEntry` - 19 edges
2. `Registro de cambios` - 18 edges
3. `DynamicStructureRegistry` - 15 edges
4. `CurseForge — Variables del proyecto` - 13 edges
5. `Custom Dimensions — Tower Waystone` - 7 edges
6. `CustomDimensionConfig` - 6 edges
7. `WaystoneNamer` - 5 edges
8. `Tower Waystone` - 5 edges
9. `Flujo de trabajo � Tower Waystone (NeoForge)` - 5 edges
10. `WaystoneTowersMod` - 4 edges

## Surprising Connections (you probably didn't know these)
- `CustomDimensionConfig` --references--> `DimensionEntry`  [EXTRACTED]
  src/main/java/com/skd/towerwaystone/CustomDimensionConfig.java → src/main/java/com/skd/towerwaystone/CustomDimensionConfig.java  _Bridges community 11 → community 9_

## Import Cycles
- None detected.

## Communities (37 total, 13 thin omitted)

### Community 0 - "WaystoneNamer"
Cohesion: 0.43
Nodes (5): BlockPos, Load, ServerLevel, WaystoneNamer, SubscribeEvent

### Community 1 - "WaystoneTowersMod.java"
Cohesion: 0.53
Nodes (4): IEventBus, Mod, Logger, WaystoneTowersMod

### Community 2 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 5 - "CurseForge � Variables del proyecto"
Cohesion: 0.14
Nodes (13): Changelog, CurseForge — Variables del proyecto, Descripcion del proyecto, Estructura del changelog (HTML), Flujo completo, Parámetros del upload, Proyecto, Rama (+5 more)

### Community 6 - "Flujo de trabajo � Tower Waystone (NeoForge)"
Cohesion: 0.33
Nodes (5): Flujo de trabajo � Tower Waystone (NeoForge), Inicializaci�n �nica de rama */main, JAR naming, Ramas, Tags

### Community 7 - "Tower Waystone"
Cohesion: 0.33
Nodes (5): Building, License, Requirements, Tower Waystone, Variants

### Community 8 - "Registro de cambios"
Cohesion: 0.33
Nodes (5): 0.0.0-beta.3 — 2026-07-27, 1.0.17 — 2026-07-10, Corregido, Fixed, Registro de cambios

### Community 9 - "0.0.0-beta.2 — 2026-07-27"
Cohesion: 0.38
Nodes (4): Identifier, RegisterEvent, DimensionEntry, DynamicStructureRegistry

### Community 10 - "1.0.15 — 2026-07-10"
Cohesion: 0.25
Nodes (7): Custom Dimensions — Tower Waystone, Example — The Aether, Example — Twilight Forest, Fallback behavior, How it works, Multiple dimensions, Structure

### Community 11 - "0.0.0-beta.1 — 2026-07-27"
Cohesion: 0.60
Nodes (3): Gson, CustomDimensionConfig, Logger

### Community 15 - ".buildProcessor"
Cohesion: 0.20
Nodes (4): Block, BlockState, ProcessorRule, StructureProcessorList

### Community 16 - "0.0.0-beta.2 — 2026-07-27"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.2 — 2026-07-27, Added, Changed

### Community 17 - "1.0.15 — 2026-07-10"
Cohesion: 0.67
Nodes (3): 1.0.15 — 2026-07-10, Cambiado, Eliminado

## Knowledge Gaps
- **45 isolated node(s):** `Added`, `Fixed`, `Fixed`, `Added`, `Fixed` (+40 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **13 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Registro de cambios` connect `Registro de cambios` to `1.0.8 — 2026-07-08`, `1.0.9 — 2026-07-08`, `0.0.0-beta.2 — 2026-07-27`, `1.0.15 — 2026-07-10`, `0.0.0-beta.1 — 2026-07-27`, `1.0.10.md`, `1.0.17.md`, `1.0.18.md`, `0.0.0-beta.7 — 2026-07-28`, `1.0.0 — 2026-07-28`, `1.0.10 — 2026-07-08`, `1.0.16 — 2026-07-10`, `1.0.18 — 2026-07-11`, `1.0.6 — 2026-07-08`, `1.0.7 — 2026-07-08`?**
  _High betweenness centrality (0.070) - this node is a cross-community bridge._
- **Why does `DimensionEntry` connect `0.0.0-beta.2 — 2026-07-27` to `0.0.0-beta.1 — 2026-07-27`, `.buildProcessor`?**
  _High betweenness centrality (0.035) - this node is a cross-community bridge._
- **Why does `DynamicStructureRegistry` connect `0.0.0-beta.2 — 2026-07-27` to `.buildProcessor`?**
  _High betweenness centrality (0.014) - this node is a cross-community bridge._
- **What connects `Added`, `Fixed`, `Fixed` to the rest of the system?**
  _45 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `CurseForge � Variables del proyecto` be split into smaller, more focused modules?**
  _Cohesion score 0.14285714285714285 - nodes in this community are weakly interconnected._