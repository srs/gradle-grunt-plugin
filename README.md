Gradle plugin for Grunt [![Build Status](https://drone.io/github.com/srs/gradle-grunt-plugin/status.png)](https://drone.io/github.com/srs/gradle-grunt-plugin/latest)
=======================

This is a very simple Gradle plugin for running Grunt tasks part of the build.
It merely wraps calls to "grunt xyz" as "gradle grunt_xyz" tasks.
Grunt may either be installed globally, or locally using npm.

Installing the plugin
---------------------

Releases of this plugin are hosted at BinTray (http://bintray.com) and is part of jcentral repository.
Setup the plugin like this:

	buildscript {
		repositories {
			jcenter()
		}
    	dependencies {
			classpath 'com.moowork.gradle:gradle-grunt-plugin:0.2'
    	}
	}

Include the plugin in your build.gradle file like this:

    apply plugin: 'grunt'

Using the plugin
----------------

You can run grunt tasks using this syntax:

    $ gradle grunt_build    # this runs grunt build
    $ gradle grunt_compile  # this runs grunt compile

... and so on.

These tasks do not appear explicitly in `gradle tasks`, they only appear as task rule.
Your Gruntfile.js defines what grunt_* tasks exist (see `grunt --help`, or `gradle grunt_--help`).

Also (more importantly), you can depend on those tasks, e.g.

    // runs "grunt build" as part of your gradle build
    build.dependsOn grunt_build

This is the main advantage of this plugin, to allow build
scripts (and grunt agnostics) to run grunt tasks via gradle.

Extended Usage
--------------

If you need to supply grunt with options, you have to create GruntTasks:

    task gruntBuildWithOpts(type: GruntTask) {
       args = ["build", "arg1", "arg2"]
    }


NPM helpers
-----------

The plugin also provides two fixed helper tasks to run once per project, which
however require npm (https://npmjs.org/) to be installed:

 - installGrunt: This installs grunt and grunt-cli to the project folder, using "npm install grunt grunt-cli"
 - npmInstall: This just runs "npm install" (possibly useful for scripting)

Since grunt will only be installed in your project folder, it will not
interact with the rest of your system, and can easily be removed later by
deleting the node_modules folders.

So as an example, you can make sure a local version of grunt exists using this:

    // makes sure on each build that grunt is installed
    grunt_build.dependsOn installGrunt
    // processes your package.json before running grunt build
    grunt_build.dependsOn npmInstall
    // runs "grunt build" as part of your gradle build
    build.dependsOn grunt_build


Getting latest npm on Ubuntu
----------------------------

See https://github.com/creationix/nvm on how to install npm via nvm.

Building the Plugin
-------------------

To build the plugin, just type the following commmand:

    ./gradlew clean build

