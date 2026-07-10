# Minecraft integration

## Motivation

The original motivation for this fork is embedding Chromium-based interfaces
inside Minecraft Java projects. JCEF makes it possible to combine Java game or
mod code with modern web rendering and browser capabilities.

Potential uses include:

- In-game web interfaces and rich UI.
- Authentication or account-management flows.
- Documentation, dashboards, and remote content.
- Off-screen rendering into a game texture.

## Why this affects JCEF

Minecraft integrations place unusual demands on browser lifecycle, off-screen
rendering, input forwarding, and native distribution. Some capabilities are
best implemented as reusable JCEF fixes or APIs instead of being duplicated in
every mod or launcher integration.

## Integration constraints

JCEF is not a pure Java dependency. An integration must account for:

- Selecting and extracting the correct native bundle for the current OS and
  architecture.
- Configuring the native library path before JCEF initialization.
- Shipping CEF resources and the subprocess executable.
- Managing Chromium lifecycle independently from Minecraft screens.
- Moving off-screen pixel data into the game renderer.
- Translating input, focus, scaling, and window lifecycle behavior.
- Supplying JVM module access flags required by modern Java versions.
- Respecting macOS initialization and application-thread requirements.

## Project boundaries

Reusable JCEF fixes and APIs belong in this repository. Native compilation and
platform packaging belong in `trethore/jcefbuild`. Maven dependency handling
and native extraction belong in `trethore/jcefgithub`.

Minecraft-version-specific mod code should live elsewhere. This keeps the JCEF
fork reusable and allows it to continue tracking upstream without coupling the
source tree to a particular game loader or version.
