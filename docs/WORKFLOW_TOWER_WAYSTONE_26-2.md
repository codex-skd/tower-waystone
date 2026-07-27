# Flujo de trabajo — Tower Waystone (NeoForge)

> **Versión del workflow**: 1.4.0 (codex-docs)
> Este archivo pertenece al proyecto **Tower Waystone**.

## Ramas

| Rama | Propósito |
|---|---|
| `minecraft/26.2/neoforge-26.2.0.32-beta/production` | Rama por defecto. Trabajo diario en Minecraft 26.2 |
| `minecraft/26.2/neoforge-26.2.0.32-beta/main` | Rama protegida. Código público para GitHub |

## Inicialización única de rama */main

```bash
git checkout minecraft/26.2/neoforge-26.2.0.32-beta/production
git checkout -b minecraft/26.2/neoforge-26.2.0.32-beta/main
git push origin minecraft/26.2/neoforge-26.2.0.32-beta/main
git checkout minecraft/26.2/neoforge-26.2.0.32-beta/production
```

## JAR naming

`tower_waystone-26.2-neoforge-<version>.jar`

## Tags

`26.2-neoforge-<version>`
