package com.moowork.gradle.grunt

import org.gradle.api.tasks.Exec

class GruntInstallTask extends Exec
{
    public GruntInstallTask( )
    {
        setGroup( "Grunt" );
        setExecutable( "npm" );
        setDescription( "Runs 'npm install grunt-cli grunt' to install grunt-cli" )
        setArgs( ["install", "grunt-cli", "grunt"] as List );
        getOutputs().dir( "node_modules/.bin/grunt" );
    }
}
