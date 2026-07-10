# Your first local JCEF build

This tutorial walks through a local Release build using Java 17 and CMake. It
is intended to establish a working development environment, not to reproduce
the complete multi-platform release pipeline.

## What you will build

By the end of the tutorial, you will have:

- Downloaded the matching CEF binary distribution.
- Compiled the native JCEF library.
- Compiled the Java classes.
- Launched a JCEF sample application.

## Before you start

Install:

- Git
- CMake 3.21 or newer
- JDK 17 or newer
- Python 3
- Ninja
- Your platform's C++ development toolchain

Platform-specific requirements are listed in the [supported platforms
reference](../reference/supported-platforms.md).

Set `JAVA_HOME` to the JDK you want to use:

```sh
export JAVA_HOME=/path/to/jdk-17
```

On Windows, set the equivalent environment variable through PowerShell, the
command prompt, or system settings.

## 1. Create the build directory

From the repository root:

```sh
mkdir jcef_build
cd jcef_build
```

The directory must be named `jcef_build`; upstream JCEF scripts rely on that
path.

## 2. Configure JCEF

On Linux:

```sh
cmake -G Ninja -DCMAKE_BUILD_TYPE=Release ..
```

On macOS ARM64:

```sh
cmake -G Ninja -DPROJECT_ARCH=arm64 -DCMAKE_BUILD_TYPE=Release ..
```

On macOS x64, replace `arm64` with `x86_64`.

On Windows, run this from a Visual Studio 2022 developer environment:

```bat
cmake -G Ninja -DCMAKE_BUILD_TYPE=Release ..
```

CMake downloads the matching CEF binary distribution into `third_party/cef/`
and generates the native build.

## 3. Compile the native targets

```sh
ninja
```

Resolve any missing platform dependencies reported by CMake or the compiler
before continuing.

## 4. Compile the Java classes

On Linux:

```sh
cd ../tools
./compile.sh linux64
```

On Windows x64:

```bat
cd ..\tools
compile.bat win64
```

The macOS CMake build handles the Java application as part of its normal build
workflow.

## 5. Run a sample

On Linux:

```sh
./run.sh linux64 Release simple
```

On Windows:

```bat
run.bat win64 Release simple
```

You can replace `simple` with `detailed` to launch the larger demonstration
application.

## Next steps

- Consult [Build JCEF](../how-to/build-jcef.md) for other generators,
  architectures, tests, and packaging.
- Read the [repository layout](../reference/repository-layout.md) before making
  source changes.
- Use `trethore/jcefbuild` for reproducible release artifacts.
