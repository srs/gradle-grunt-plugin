package com.moowork.gradle.grunt

import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.Exec

class GruntTask extends Exec
{

    public GruntTask( )
    {
        setGroup( "Grunt" );
        determineExecutable();
    }

    private void determineExecutable( )
    {
        String gruntExec = "grunt";

        File localGrunt = project.file( "node_modules/.bin/${gruntExec}" );
        if ( ! localGrunt.isFile() )
        {
            String msg = "Grunt-CLI not installed in node_modules, please first run gradle ${GruntPlugin.GRUNT_INSTALL_NAME}"
            logger.warn("WARNING: " + msg)
            gruntExec = localGrunt.toString();
            if ( Os.isFamily( Os.FAMILY_WINDOWS ) )
            {
                gruntExec = gruntExec + ".cmd";
            }
        }
        setExecutable( gruntExec );
    }


}
