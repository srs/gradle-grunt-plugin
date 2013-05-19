package com.moowork.gradle.grunt

import org.gradle.api.Plugin
import org.gradle.api.Project

class GruntPlugin implements Plugin<Project>
{
    @Override
    void apply( final Project project )
    {
        project.extensions.getExtraProperties().set('GruntTask', GruntTask.class);
        project.tasks.create( NpmInstallTask.NAME, NpmInstallTask );
    }
}
