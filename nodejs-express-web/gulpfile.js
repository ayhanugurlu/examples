var gulp = require('gulp');
var jshint = require('gulp-jshint');

var jsFiles = ['*.js','src/**/*.js'];

gulp.tast('style',function(){
    gulp.src(jsFiles).pipe(jshint);
});