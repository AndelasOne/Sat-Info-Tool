# Satellite Tool

DBHW Project for Software Engineering lectures.

## Authors

Matrikelnummern:

- 1540399
- 3306922
- 4249633

## Used Tools

- Java 15
- IntelliJ
- Maven

## Used Programming Pattern

- Composite Pattern
  - AbstractNode
  - ArrayNode
  - StructNode
  - Leaf
- FactoryPattern
  - ClassLoader
  - ConfigData
  - ReadJSON
- Model-View-Controller
  - App
  - GUIOutput
  - PrimaryController
- Reflection
  - ClassLoader
  - CreateTree
  - GermanChannels
  - ProgramCounter
- JavaFX

## Setup

1. install java 15
2. Build project with all dependencies (or use the Prebuild jar)
3. Execute Jar with path to configuration file

   `java -jar /path/to/config`

## The Configuration File

```json
{
  "data": "example/satelites.json", // path to a json file containing the satellite info
  "plugins": {
    "classname": "plugins.ProgramCounter", // classname / classpath of the plugin class
    "path": "ProgramCounter.jar" // path to the jar containg the class
  },
  "output": {
    "classname": "plugins.JSON_Output", // classname / classpath of the plugin class
    "path": "JSON_Output.jar" // path to the jar containg the class
  }
}
```

## Example

Navigato to the example folder
Execute the prebuild jar with the GUIConfig.json

```
java -jar ./Sat_Tool.jar ./GUIConfig.json
```
