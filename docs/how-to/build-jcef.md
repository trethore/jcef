# Build JCEF

Use this guide when you already understand the basic workflow and need the
commands for a particular configuration.

## Requirements

The common baseline is:

- CMake 3.21 or newer
- JDK 17 or newer
- Python 3
- A supported native toolchain

See [Supported platforms](../reference/supported-platforms.md) for platform and
architecture details.

## Select Java and Python

Set `JAVA_HOME` when CMake cannot locate the intended JDK. Set
`PYTHON_EXECUTABLE` to explicitly select Python when required.

## Create the required build directory

```sh
mkdir jcef_build
cd jcef_build
```

Do not use a different directory name. The JCEF run and distribution scripts
expect `jcef_build`.

## Configure and compile

### Linux with Ninja

```sh
cmake -G Ninja -DCMAKE_BUILD_TYPE=Release ..
ninja
```

### macOS with Ninja

```sh
cmake -G Ninja -DPROJECT_ARCH=arm64 -DCMAKE_BUILD_TYPE=Release ..
ninja
```

Use `-DPROJECT_ARCH=x86_64` for an Intel build.

### Windows with Visual Studio

```bat
cmake -G "Visual Studio 17 2022" -A x64 ..
cmake --build . --config Release
```

### Debug builds

For a single-configuration generator such as Ninja, replace `Release` with
`Debug` in `CMAKE_BUILD_TYPE`. For Visual Studio, pass `--config Debug` when
building.

## Compile Java sources

On Linux and Windows, compile Java after the native build:

```sh
cd ../tools
./compile.sh linux64
```

```bat
cd ..\tools
compile.bat win64
```

## Run samples and tests

```sh
./run.sh linux64 Release simple
./run.sh linux64 Release detailed
./run_tests.sh linux64 Release
```

Use the corresponding `.bat` scripts and platform identifier on Windows.

## Create a distribution

```sh
./make_distrib.sh linux64
```

```bat
make_distrib.bat win64
```

The output is written to `binary_distrib/`.

For release builds, use `trethore/jcefbuild` rather than manually publishing a
local distribution. It provides the pinned environments, cross-compilation,
macOS signing, and release metadata expected by `trethore/jcefgithub`.
