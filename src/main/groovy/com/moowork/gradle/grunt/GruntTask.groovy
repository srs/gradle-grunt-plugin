package com.moowork.gradle.grunt

import com.moowork.gradle.node.task.NodeTask
import org.gradle.api.GradleException

class GruntTask
    extends NodeTask
{
    private final static String GRUNT_SCRIPT = 'node_modules/grunt-cli/bin/grunt';

    public GruntTask()
    {
        this.group = 'Grunt';
    }

    @Override
    void exec()
    {
        def localGrunt = this.project.file( new File( this.project.node.nodeModulesDir, GRUNT_SCRIPT ) )
        if ( !localGrunt.isFile() )
        {
            throw new GradleException(
                "Grunt-CLI not installed in node_modules, please first run 'gradle ${GruntPlugin.GRUNT_INSTALL_NAME}'" )
        }

        setWorkingDir( this.project.grunt.workDir )
        setScript( localGrunt )
        super.exec()
    }
}
