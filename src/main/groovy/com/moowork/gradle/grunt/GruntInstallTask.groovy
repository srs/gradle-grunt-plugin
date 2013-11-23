package com.moowork.gradle.grunt

import org.gradle.api.tasks.Exec
import org.apache.tools.ant.taskdefs.condition.Os

class GruntInstallTask extends Exec
{
    public GruntInstallTask( )
    {
        setGroup( "Grunt" );
        setDescription( "Runs 'npm install grunt-cli grunt' to install grunt-cli" )
        if ( Os.isFamily( Os.FAMILY_WINDOWS ) ) {
            setExecutable( "cmd" );
            setArgs( ["/c", "npm", "install", "grunt-cli", "grunt"] as List );
        } else {
            setExecutable( "npm" );
            setArgs( ["install", "grunt-cli", "grunt"] as List );
        }

        getOutputs().dir( "node_modules/.bin/grunt" );
    }
}
