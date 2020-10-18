task unpackLibsDirectory(type: Copy) {
    from(zipTree("src/resources/thirdPartyResources.zip")) {
        include "libs/**"  
        eachFile { fcd ->
            fcd.relativePath = new RelativePath(true, fcd.relativePath.segments.drop(1))  
        }
        includeEmptyDirs = false  
    }
    into "$buildDir/resources"
}