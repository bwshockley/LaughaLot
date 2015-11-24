# LaughaLot
Laugh A Lot is a demonstration Android app for linking a Java library, an Android Library, and the GCE modules together.  This application also has a free and paid variant to demonstrate building different flavors of the app.

## The Java Library: jokelibrary

The joke library has one key method to use: getRandomJoke().  This will provide one random joke out of the ten available
in the form of a joke object.  The joke has two fields: Title and Content.  Each has a getter and setter method provided.

## Motivation

This app was built as part of my Android nanodegree program through Udacity.  It was made as a demonstration of using Gradle, building
a java library module, building an Android library module, and finally connecting it together with a Google Compute Engine.

This application is currently set to pull jokes from "https://laughs-a-lot.appspot.com/_ah/api/"

## Installation

Import the application into Android Studio and install on device.

## API Reference

For additional information on the GCE componenets, please see this example: https://cloud.google.com/tools/android-studio/messaging/add_module

## Tests

You can run tests via Gradle with the following command: `gradle doAll`.  This will start a local server for Google Cloud Messenging, run the async connection test, then close the local server.

## Contributors

Benjamin Shockley
