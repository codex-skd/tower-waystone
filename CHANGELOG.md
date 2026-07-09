# Changelog

## 1.0.11 — 2026-07-09
### Removed
- StructureProcessor approach (`WaystoneNameProcessor`) — was blocking structure generation entirely
- `processor_list/waystone_name.json` — no longer needed

### Changed
- Template pools now use `"minecraft:empty"` processor instead of custom processor
- Waystone naming is now handled via `ChunkEvent.Load` event in `WaystoneNamer`

### Added
- `WaystoneNamer` — event-driven waystone naming on chunk load, assigns random fantasy names

## 1.0.10 — 2026-07-08
### Fixed
- Processor codec uses singleton MapCodec (matching NopProcessor pattern)

## 1.0.9 — 2026-07-08
### Fixed
- Override both `process()` and `processBlock()` to guard against method changes

## 1.0.8 — 2026-07-08
### Fixed
- Processor NBT logic, use Supplier for MapCodec

## 1.0.7 — 2026-07-08
### Changed
- No-op processor to isolate generation issue

## 1.0.6 — 2026-07-08
### Fixed
- Terrain adaptation to `none`, heightmap to `OCEAN_FLOOR_WG`
