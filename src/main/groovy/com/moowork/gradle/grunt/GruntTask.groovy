package com.moowork.gradle.grunt

import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.Exec

class GruntTask extends Exec
{
    public GruntTask( )
    {
        setGroup( "Grunt" );
        setDependsOn( [] );
        determineExecutable();
    }

    private void determineExecutable( )
    {
        String gruntExec = "grunt";
        if ( Os.isFamily( Os.FAMILY_WINDOWS ) )
        {
            gruntExec = gruntExec + ".cmd";
        }

        File localGrunt = project.file( "node_modules/grunt-cli/bin/${gruntExec}" );
        if ( localGrunt.isFile() )
        {
            gruntExec = localGrunt.toString();
        }

        setExecutable( gruntExec );
    }

    @Override
    void setDependsOn( final Iterable<?> dependsOn )
    {
        List list = dependsOn as List;
        list.add( NpmInstallTask.NAME );

        super.setDependsOn( list )
    }
}
