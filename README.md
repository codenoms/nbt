# NBT
### Introduction
NBT, or **n**amed **b**inary **t**ags, is the format developed and used by Minecraft to store and transmit various different complex data types.
Namely, NBT is used for the Anvil world format, as well as for the communication of item data between Minecraft servers and clients.
This library aims to provide a lightweight and intuitive way to interact with NBT while using minimal resources.

### Features
* **No "tag" classes.**
All tag values communicated as their original types in Java.
* **Adapters.**
You can put types not supported by the NBT specification into any compound tag and have them be serialized as their own NBT compound tag.
Additionally, after registering your adapter you can get your objects straight out of a compound (even as a list)!

### Download
**Using Maven:**
1. Open your project's pom.xml.
2. Add the Jitpack repository:
   ```xml
   <repositories>
     <repository>
       <id>jitpack.io</id>
       <url>https://jitpack.io</url>
     </repository>
   </repositories>
   ```
3. Add the dependency:
   ```xml
   <dependencies>
     <dependency>
       <groupId>com.github.codenoms</groupId>
       <artifactId>nbt</artifactId>
       <version>1.2.0</version>
     </dependency>
   </dependencies>
   ```

**Using Gradle:**
1. Open your project's build.gradle.
2. Add the Jitpack repository:
   ```gradle
   repositories {
     maven { url 'https://jitpack.io/' }
   }
   ```
3. Add the dependency:
   ```gradle
   dependencies {
     compile 'com.github.codenoms:nbt:1.2.0'
   }
   ```

### License
Released under the MIT license.
> For good or evil, for anyone anywhere.<sup>[1](#foot1)</sup>

<b id="foot1">1</b>:
Please read the [exact verbiage](https://github.com/codenoms/nbt/blob/master/LICENSE).
