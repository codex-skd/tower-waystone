# Custom Dimensions — Tower Waystone

Tower Waystone can generate towers in any dimension from any modpack. Configure via JSON.

## How it works

The mod reads `config/tower_waystone/custom_dimensions.json`. Each entry defines:

- **`dimension`**: The dimension ID (e.g. `twilightforest:twilight_forest`)
- **`biomes`**: List of biome IDs where towers should generate in that dimension
- **`block`**: Main building block (replaces andesite). Default: `minecraft:stone_bricks`
- **`lightBlock`**: Light source block (replaces sea lantern). Default: `minecraft:sea_lantern`
- **`accentBlock`**: Accent block (replaces dark prismarine). Default: `minecraft:dark_prismarine`
- **`groundBlock`**: Ground block (replaces dirt/grass). Default: `minecraft:dirt`

> If a block does not exist in the game, the mod falls back to the default block and logs a warning. The server WILL NOT crash.

## Example — Twilight Forest

```json
[
  {
    "dimension": "twilightforest:twilight_forest",
    "biomes": ["twilightforest:twilight_forest", "twilightforest:clearing"],
    "block": "twilightforest:castle_brick",
    "lightBlock": "minecraft:glowstone",
    "accentBlock": "twilightforest:castle_pillar",
    "groundBlock": "minecraft:grass_block"
  }
]
```

## Example — The Aether

```json
[
  {
    "dimension": "aether:the_aether",
    "biomes": ["aether:aether_highlands", "aether:aether_plains"],
    "block": "aether:heliosite_stonebrick",
    "lightBlock": "aether:ambrosium_torch",
    "accentBlock": "aether:heliosite_pillar",
    "groundBlock": "aether:aether_grass_block"
  }
]
```

## Multiple dimensions

Add multiple entries:

```json
[
  {
    "dimension": "twilightforest:twilight_forest",
    "biomes": ["twilightforest:twilight_forest"],
    "block": "twilightforest:castle_brick"
  },
  {
    "dimension": "aether:the_aether",
    "biomes": ["aether:aether_highlands"],
    "block": "aether:heliosite_stonebrick"
  }
]
```

## Fallback behavior

If a block ID is invalid or missing:
1. The mod logs a warning with the dimension and block name
2. Falls back to `minecraft:stone_bricks` (or the default for that slot)
3. The server continues normally

## Structure

The tower uses the same `waystone_tower.nbt` structure from the Overworld, with blocks replaced by your configured blocks via `minecraft:rule` processors. Slab, stair, and wall variants are detected automatically if they exist.
