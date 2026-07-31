# Flujo de trabajo — Tower Waystone (NeoForge)

> **Versión del workflow**: 1.13.0 (codex-docs)
> Este archivo pertenece al proyecto **Tower Waystone**. Cada proyecto tiene su propio `WORKFLOW_<MOD_ID>_<MC-VERSION>.md`.
> No es un archivo central ni template compartido. Los cambios aquí solo afectan a este proyecto.
> Es una **copia fina**: delega en `codex-docs/WORKFLOW_GENERIC.md` y los `reference/`. No se re-sincroniza copiando contenido — solo se actualiza si cambia la estructura del genérico o los datos específicos del mod.

## Delegación

Todo lo que no sea específico del mod se lee de:
- `codex-docs/WORKFLOW_GENERIC.md` — convenciones, workspace, ramas, versionado, commits, tags, CI/CD, flujo, buenas prácticas, idioma
- `codex-docs/reference/CURSEFORGE.md` — formato HTML de CurseForge (solo al publicar)
- `codex-docs/reference/GRAPHIFY.md` — backend LLM de Graphify (solo al montar `extract`/`label`)
- `codex-docs/reference/REPO_SETUP.md` — setup único de ramas/CI (solo al iniciar el repo)

## Específico del mod

| Dato | Valor |
|---|---|
| Mod ID (`gradle.properties`) | `tower_waystone` |
| Clase principal | `WaystoneTowersMod` |
| Display name (Title Case) | `Tower Waystone` |
| Versiones de Minecraft | `26.1.2 y 26.2` |

### Notas específicas de este mod

- **Rama 26.2**: `minecraft/26.2/neoforge-26.2.0.32-beta/production` (+ `main` hermana). JAR: `tower_waystone-26.2-neoforge-<version>.jar`. Tags: `26.2-neoforge-<version>`.
