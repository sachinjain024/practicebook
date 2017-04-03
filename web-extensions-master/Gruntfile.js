/**
 *  @References
 * [0] http://gruntjs.com/getting-started to install grunt-cli
 * [1]: https://github.com/01org/grunt-zipup
 * [2]: https://github.com/gruntjs/grunt-contrib-handlebars
 * [3]: http://gruntjs.com/configuring-tasks#files
 **/

module.exports = function (grunt) {

  grunt.initConfig({
    connect: {
      server: {
        options: {
          port: 7070,
          hostname: 'localhost',
          keepalive: true
        }
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-connect');

  grunt.registerTask('serve', ['connect']);
};
