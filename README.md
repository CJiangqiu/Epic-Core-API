This is an API mod I created for my other mods. A total of 5 main materials have been added: Silver, Steel, Black Copper, Mithril, and Orichalcum, along with their related secondary materials and blocks. In addition, it also introduces a new type of damage: Soul Damage, and a combat system inspired by “The Elder Scrolls: Skyrim”.
My CurseForge website:https://www.curseforge.com/minecraft/mc-mods/epic-core-api
# How to Use My API?
Firstly:You need add the JitPack repository to your build file
```java
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
Secondly: Add the dependency
```java
dependencies {
	        implementation 'com.github.CJiangqiu：Epic-Core-API：0.1.6'
	}
 ```
## The Battle System(WIP)
