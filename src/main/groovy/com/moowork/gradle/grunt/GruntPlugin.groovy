package com.moowork.gradle.grunt


import org.gradle.api.Task;
import org.gradle.api.Plugin
import org.gradle.api.Project

class GruntPlugin implements Plugin<Project>
{
    public static final String NPM_INSTALL_NAME = "npmInstall";
    public static final String GRUNT_INSTALL_NAME = "installGrunt";

    @Override
    void apply( final Project project )
    {
        project.extensions.getExtraProperties().set('GruntTask', GruntTask.class);
        project.getTasks().create(NPM_INSTALL_NAME, NpmInstallTask.class)
        project.getTasks().create(GRUNT_INSTALL_NAME, GruntInstallTask.class)

        // note this rule also makes it possible to specify e.g. "dependsOn grunt_install"
        project.getTasks().addRule("Pattern: grunt_<ID>") { String taskName ->
            if (taskName.startsWith("grunt_")) {
                Task gruntTask = project.getTasks().create(taskName, com.moowork.gradle.grunt.GruntTask.class);
                gruntTask.args = [(taskName - 'grunt_')];
                return gruntTask;
            }
        }
    }
}
