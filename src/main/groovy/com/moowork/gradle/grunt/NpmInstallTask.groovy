package com.moowork.gradle.grunt

import org.gradle.api.tasks.Exec

class NpmInstallTask extends Exec
{
    public NpmInstallTask( )
    {
        setGroup( "Npm" );
        setExecutable( "npm" );
        setDescription( "Runs 'npm install' to install all packages declared in package.json" )
        setArgs( ["install"] as List );
        getInputs().file( "package.json" );
        getOutputs().dir( "node_modules" );
    }
}
