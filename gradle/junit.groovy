apply plugin: 'java' // adds 'test' task

dependencies {
    testImplementation 'junit:junit:4.13.1'
}

test {
   include 'org/foo/**'
   exclude 'org/boo/**'
   
   // show standard out and standard error of the test JVM(s) on the console
   testLogging.showStandardStreams = true
   
   // listen to events in the test execution lifecycle
   beforeTest { 
      descriptor → logger.lifecycle("Running test: " + descriptor)
   }

   // listen to standard out and standard error of the test JVM(s)
   onOutput { 
      descriptor, event → logger.lifecycle
         ("Test: " + descriptor + " produced standard out/err: " 
         + event.message )
   }
}