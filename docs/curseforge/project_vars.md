# CurseForge — Variables del proyecto

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | `1601435` |
| `mod_id` | `tower_waystone` |
| `display_name` | `Tower Waystone` (separado, no junto) |

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | `ee776b0a-ee95-4850-b554-06be02a8657f` | Subir archivos JAR |
| Core (GET) | `$2a$10$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO` | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

## Versión actual

| Variable | Valor |
|----------|-------|
| `minecraft_version` | `26.2` |
| `framework` | `neoforge` |
| `java_version` | `25` |
| `environment` | `Client`, `Server` |

## Rama

```
minecraft/26.2/neoforge-26.2.0.32-beta/production
```

## Tag

Formato: `<mc-version>-<framework>-<version>`
Ejemplo: `26.2-neoforge-1.0.18`

## Parámetros del upload

| Campo | Valor | Notas |
|-------|-------|-------|
| `displayName` | `Tower Waystone (1.0.X)` | Nombre visible: `display_name (version)` |
| `changelog` | HTML (no Markdown) | Ver estructura abajo |
| `changelogType` | `html` | Obligatorio para que se vea bien |
| `releaseType` | `release` o `beta` | Según el tipo de versión |
| `gameVersionNames` | `["Client", "Server", "26.2", "NeoForge"]` | Entorno + MC + modloader |

## Estructura del changelog (HTML)

```html
<h2>v1.0.X - Titulo descriptivo</h2>

<h3>Fix</h3>
<ul>
<li><strong>Problema</strong>: descripcion con <code>codigo</code>.</li>
<li><strong>Otro</strong>: descripcion.</li>
</ul>

<h3>Changed</h3>
<ul>
<li><code>Clase/metodo()</code> — descripcion.</li>
</ul>

<h3>Notes</h3>
<blockquote>Nota importante para servidores.</blockquote>

<hr>

<p><strong>JAR</strong>: <code>tower_waystone-26.2-neoforge-1.0.X.jar</code></p>
```

## Subir archivo (JAR) con Python

```python
import json, uuid, urllib.request

boundary = uuid.uuid4().hex
version = "1.0.X"

metadata = {
    "displayName": f"Tower Waystone ({version})",
    "changelog": "<h2>v1.0.X - Titulo</h2>",
    "changelogType": "html",
    "gameVersionNames": ["Client", "Server", "26.2", "NeoForge"],
    "releaseType": "release"
}

with open(f"build/libs/tower_waystone-26.2-neoforge-{version}.jar", "rb") as f:
    jar_data = f.read()

meta_bytes = json.dumps(metadata, ensure_ascii=False).encode("utf-8")

body = b""
body += f"--{boundary}
".encode()
body += b'Content-Disposition: form-data; name="metadata"
'
body += b"Content-Type: application/json

"
body += meta_bytes + b"
"
body += f"--{boundary}
".encode()
body += b'Content-Disposition: form-data; name="file"; filename="tower_waystone-26.2-neoforge-{version}.jar"
'
body += b"Content-Type: application/java-archive

"
body += jar_data + b"
"
body += f"--{boundary}--
".encode()

req = urllib.request.Request(
    f"https://minecraft.curseforge.com/api/projects/1601435/upload-file",
    data=body,
    headers={
        "X-Api-Token": "ee776b0a-ee95-4850-b554-06be02a8657f",
        "Content-Type": f"multipart/form-data; boundary={boundary}"
    },
    method="POST"
)

resp = urllib.request.urlopen(req)
print(resp.read().decode())
```

## Descripcion del proyecto

No hay endpoint API para actualizar la descripcion. Se edita manualmente desde la web de CurseForge pegando el HTML de `docs/curseforge/project_description.md`.
