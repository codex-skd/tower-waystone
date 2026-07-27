# Graph Report - G:\Proyectos\Mods_Minecraft\tower_waystone\26.2  (2026-07-27)

## Corpus Check
- cluster-only mode — file stats not available

## Summary
- 20 nodes · 26 edges · 5 communities
- Extraction: 96% EXTRACTED · 4% INFERRED · 0% AMBIGUOUS · INFERRED: 1 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- WaystoneNamer
- WaystoneTowersMod.java
- gradlew

## God Nodes (most connected - your core abstractions)
1. `WaystoneNamer` - 5 edges
2. `WaystoneTowersMod` - 4 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Import Cycles
- None detected.

## Communities (5 total, 0 thin omitted)

### Community 0 - "WaystoneNamer"
Cohesion: 0.43
Nodes (5): BlockPos, Load, ServerLevel, WaystoneNamer, SubscribeEvent

### Community 1 - "WaystoneTowersMod.java"
Cohesion: 0.53
Nodes (4): IEventBus, Logger, Mod, WaystoneTowersMod

### Community 2 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `WaystoneNamer` connect `WaystoneNamer` to `WaystoneTowersMod.java`?**
  _High betweenness centrality (0.259) - this node is a cross-community bridge._