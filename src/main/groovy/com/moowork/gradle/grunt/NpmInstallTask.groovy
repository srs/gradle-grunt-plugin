package com.moowork.gradle.grunt

import org.gradle.api.tasks.Exec

class NpmInstallTask extends Exec
{
    public final static NAME = 'npmInstall';

    public NpmInstallTask( )
    {
        setGroup( "Grunt" );
        setExecutable( "npm" );
        setArgs( ["install"] as List );
        getInputs().file( "package.json" );
        getOutputs().dir( "node_modules" );
    }
}
