package com.moowork.gradle.grunt

import org.gradle.api.tasks.Exec
import org.apache.tools.ant.taskdefs.condition.Os

class NpmInstallTask extends Exec
{
    public NpmInstallTask( )
    {
        setGroup( "Npm" );
        setDescription( "Runs 'npm install' to install all packages declared in package.json" )
	if ( Os.isFamily( Os.FAMILY_WINDOWS ) ) {
            setExecutable( "cmd" );
            setArgs( ["/c", "npm", "install"] as List );
        } else {
            setExecutable( "npm" );
            setArgs( ["install"] as List );
        }
        getInputs().file( "package.json" );
        getOutputs().dir( "node_modules" );
    }
}
