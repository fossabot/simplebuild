# Build README

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

After a basic `build.sh` v1 script, here is the v2 `build.sh` script. It is now allowing you to build any java project with
the maven inspired file structure below. It is particularly adapted to very light machine : ARM architecture based ones a.k.a. RaspberryPi, OrangePi, BananaPi, etc ... or any simple projects.

It is using only `bash`, `javac`, `java`,`jar` and `git` command line instructions.
For this created executable `.run` file run... just be sure that a [Java JDK](https://www.oracle.com/java/technologies/java-se-glance.html "Go to the Java source and choose your favorite flavour from 8 to 15 !") is installed and a correct `JAVA_HOME` is set.

## Project Structure

```text
${projectfolder}/
 |_ lib
 |  |_ options.sh
 |  |_ stub.sh
 |_ src
 |  |_ main
 |     |_ java
 |     |  |_ my
 |     |     |_ program
 |     |        |_ package
 |     |           |_ MyMainClass.java
 |     |_ resources
 |        |_ res
 |        |  |_ images
 |        |  |  |_ mylogo.png
 |        |  |_ message.properties
 |_ .gitignore
 |_ build.sh
 |_ LICENSE
 |_ README.md
 (|_ pom.xml <= if any need to go back to too serious things :P )
```

## Configuration

The first variables must be adapted to your needs:

- `PROGRAM_NAME` Your program name,
- `PROGRAM_TITLE` Your program name,
- `PROGRAM_VERSION` The version of your program,
- `MAINCLASS` canonical name of your JAR entry point class,
- `VENDOR_NAME` the vendor for this program,
- `AUTHOR_NAME` the author of this program.

The manifest is generated by the `build2.sh` script.

Then just do a

```bash
$> build a
```

And a few seconds later, you'll got some beatifull `$PROGRAM_NAME.run` and `$PROGRAM_NAME.jar` file in the `target` directory.

Execute the `.run` file to start your well packaged jar file in an autorun format.

## Some help on usage

To get some simple entry point, just do :

```bash
$> build.sh -h
build2 command line usage :
---------------------------
$> build [options]
where:
 - h|H|?|*     : display this simple help
 - a|A|all     : perform all following operations
 - c|C|compile : compile all sources project
 - j|J|jar     : build JAR with all resources
 - w|W|wrap    : Build and wrap jar as a shell script

 (c)2020 MIT License Frederic Delorme (@McGivrer) fredericDOTdelormeATgmailDOTcom
 --
```

McG.

> Thanks to https://github.com/maynooth/CS210/wiki/Convert-Java-Executable-to-Linux-Executable
> for creating a linux executable with concatenated sh and jar file.