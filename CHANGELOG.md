# Changelog

## 1.0.17 — 2026-07-10
### Fixed
- Waystone naming no longer overwrites existing waystone names — skips waystones that already have a name or were placed by a player

## 1.0.16 — 2026-07-10
### Changed
- Refined biome tags per tower variant so each generates only in thematically appropriate biomes (sandy → desert/badlands, mossy → jungle/swamp/taiga, snowy → frozen, normal → temperate)

## 1.0.15 — 2026-07-10
### Changed
- Waystone naming rewritten to use Waystones API directly (`WaystonesAPI.getWaystoneAt` + `MutableWaystone.setName`) instead of NBT reflection — fixes naming in 1.21.4 Data Component system
- Added `waystones-neoforge-26.1.2-26.1.2.8.jar` as compile dependency from `libs/`

### Removed
- NBT injection approach (incompatible with 1.21.4 Data Components)

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
