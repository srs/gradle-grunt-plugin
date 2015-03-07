package com.moowork.gradle.grunt

import org.gradle.api.Project

class GruntExtension
{
    final static String NAME = 'grunt'

    def File workDir

    GruntExtension( final Project project )
    {
        this.workDir = project.projectDir
    }
}
