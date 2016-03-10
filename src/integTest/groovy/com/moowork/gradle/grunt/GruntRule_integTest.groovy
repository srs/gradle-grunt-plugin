package com.moowork.gradle.grunt

class GruntRule_integTest
    extends AbstractIntegTest
{
    def 'execute simple task'()
    {
        given:
        writeBuild( '''
            apply plugin: 'com.moowork.grunt'

            node {
                download = true
            }
        ''' )
        writeFile( 'Gruntfile.js', '''
            module.exports = function(grunt) {
                grunt.registerTask('simple', []);
            }
        ''' )

        when:
        def result = runTasks( 'installGrunt', 'grunt_simple' )

        then:
        result.wasExecuted( 'installGrunt' )
        result.wasExecuted( 'grunt_simple' )
    }
}
