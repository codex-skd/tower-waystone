# Graph Report - 26.2  (2026-07-27)

## Corpus Check
- 52 files · ~69,416 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 75 nodes · 71 edges · 25 communities (17 shown, 8 thin omitted)
- Extraction: 99% EXTRACTED · 1% INFERRED · 0% AMBIGUOUS · INFERRED: 1 edges (avg confidence: 0.8)
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
- 1.0.10 — 2026-07-08
- 1.0.16 — 2026-07-10
- 1.0.17 — 2026-07-10
- 1.0.18 — 2026-07-11
- 1.0.7 — 2026-07-08
- 1.0.8 — 2026-07-08
- 1.0.9 — 2026-07-08

## God Nodes (most connected - your core abstractions)
1. `Registro de cambios` - 12 edges
2. `CurseForge � Variables del proyecto` - 10 edges
3. `WaystoneNamer` - 5 edges
4. `Tower Waystone` - 5 edges
5. `Flujo de trabajo � Tower Waystone (NeoForge)` - 5 edges
6. `WaystoneTowersMod` - 4 edges
7. `0.0.0-beta.2 — 2026-07-27` - 3 edges
8. `1.0.15 — 2026-07-10` - 3 edges
9. `0.0.0-beta.1 — 2026-07-27` - 2 edges
10. `1.0.18 — 2026-07-11` - 2 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Import Cycles
- None detected.

## Communities (25 total, 8 thin omitted)

### Community 0 - "WaystoneNamer"
Cohesion: 0.43
Nodes (5): BlockPos, Load, ServerLevel, WaystoneNamer, SubscribeEvent

### Community 1 - "WaystoneTowersMod.java"
Cohesion: 0.53
Nodes (4): IEventBus, Logger, Mod, WaystoneTowersMod

### Community 2 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 5 - "CurseForge � Variables del proyecto"
Cohesion: 0.18
Nodes (10): CurseForge � Variables del proyecto, Descripcion del proyecto, Estructura del changelog (HTML), Par�metros del upload, Proyecto, Rama, Subir archivo (JAR) con Python, Tag (+2 more)

### Community 6 - "Flujo de trabajo � Tower Waystone (NeoForge)"
Cohesion: 0.33
Nodes (5): Flujo de trabajo � Tower Waystone (NeoForge), Inicializaci�n �nica de rama */main, JAR naming, Ramas, Tags

### Community 7 - "Tower Waystone"
Cohesion: 0.33
Nodes (5): Building, License, Requirements, Tower Waystone, Variants

### Community 8 - "Registro de cambios"
Cohesion: 0.50
Nodes (3): 1.0.6 — 2026-07-08, Corregido, Registro de cambios

### Community 9 - "0.0.0-beta.2 — 2026-07-27"
Cohesion: 0.67
Nodes (3): 0.0.0-beta.2 — 2026-07-27, Added, Changed

### Community 10 - "1.0.15 — 2026-07-10"
Cohesion: 0.67
Nodes (3): 1.0.15 — 2026-07-10, Cambiado, Eliminado

## Knowledge Gaps
- **30 isolated node(s):** `Added`, `Changed`, `Cambiado`, `Cambiado`, `Corregido` (+25 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **8 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Registro de cambios` connect `Registro de cambios` to `0.0.0-beta.2 — 2026-07-27`, `1.0.15 — 2026-07-10`, `0.0.0-beta.1 — 2026-07-27`, `1.0.10 — 2026-07-08`, `1.0.16 — 2026-07-10`, `1.0.17 — 2026-07-10`, `1.0.18 — 2026-07-11`, `1.0.7 — 2026-07-08`, `1.0.8 — 2026-07-08`, `1.0.9 — 2026-07-08`?**
  _High betweenness centrality (0.106) - this node is a cross-community bridge._
- **Why does `0.0.0-beta.2 — 2026-07-27` connect `0.0.0-beta.2 — 2026-07-27` to `Registro de cambios`?**
  _High betweenness centrality (0.017) - this node is a cross-community bridge._
- **Why does `1.0.15 — 2026-07-10` connect `1.0.15 — 2026-07-10` to `Registro de cambios`?**
  _High betweenness centrality (0.017) - this node is a cross-community bridge._
- **What connects `Added`, `Changed`, `Cambiado` to the rest of the system?**
  _30 weakly-connected nodes found - possible documentation gaps or missing edges._