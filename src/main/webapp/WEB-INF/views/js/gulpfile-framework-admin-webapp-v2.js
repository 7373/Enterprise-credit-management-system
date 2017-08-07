//项目发布构建工具
var gulp = require('gulp'),
    runSequence = require('run-sequence'),
    uglify = require('gulp-uglify'),
    autoprefixer = require('gulp-autoprefixer'),
    rev = require('gulp-rev'),
    revCollector = require('gulp-rev-collector'),
    requirejsOptimize = require('gulp-requirejs-optimize'),
    clean = require('gulp-clean'),
    cleanCss = require('gulp-clean-css');

//每次构建前先清空dist/rev
gulp.task("clean", function () {
    return gulp.src(['dist', 'rev'])
        .pipe(clean());
});

//打包到对应的文件目录
var cssSrc = ['views/css/**'],
    cssDest = 'dist/css',
    cssRev = 'rev/css',
    jsSrc = 'views/js/**/*_main.js',
    jsDest = 'dist/js',
    jsRev = 'rev/js',
    fontSrc = 'views/font/**',
    fontDest = 'dist/font',
    imgSrc = 'views/img/**',
    imgDest = 'dist/img';


//字体发布
gulp.task('fontDist', function () {
    return gulp.src(fontSrc)
        .pipe(gulp.dest(fontDest))
});

//图片发布
gulp.task('imgDist', function () {
    return gulp.src(imgSrc)
        .pipe(gulp.dest(imgDest))
});

//css压缩
gulp.task('miniCss', function () {
    return gulp.src('views/css/**/*.css')
        .pipe(cleanCss({compatibility: 'ie8'}))
        .pipe(gulp.dest('views/css'))
})
//css拷贝至发布目录
gulp.task('cssCopy', function () {
        return gulp.src(cssSrc)
            .pipe(gulp.dest(cssDest));
    }
);

//CSS生成版本号
gulp.task('revCssDist', function () {
    return gulp.src(['views/css/**/*.css', '!views/css/bootstrap.css', '!views/css/bootstrap-theme.min.css', '!views/css/font-awesome.min.css'])
        .pipe(rev())
        .pipe(gulp.dest(cssDest))
        .pipe(rev.manifest())
        .pipe(gulp.dest(cssRev));
});

// css发布
gulp.task('cssDist', function (done) {
    runSequence('miniCss', 'cssCopy', 'revCssDist', done);
});


//第三方插件拷贝至发布目录
gulp.task('pluginCopy', function () {
    return gulp.src('views/js/lib/**/*')
        .pipe(gulp.dest('dist/js/lib/'))
});

//config.js拷贝压缩至发布目录
gulp.task('configJsCopy', function () {
    return gulp.src('views/js/config.js')
        .pipe(uglify())
        .pipe(gulp.dest('dist/js/'))
});

//合并requirejs依赖
gulp.task('rjs', function () {
    return gulp.src(jsSrc)
        .pipe(requirejsOptimize({
            mainConfigFile: 'views/js/config.js',
            exclude: ['jquery', 'handlebars', 'layer1', 'laydate', 'pagination',
                'jquery.validate', 'jquery.layout', 'jquery.dataTables', 'dataTables.bootstrap',
                'ztree', 'ztreeCheck', 'dataTables.fixedHeader', 'bootstrap', 'html5shiv.min',
                'respond.min', 'jquery.serialize', 'metisMenu', 'contabs', 'pace', 'select2', 'jquery.nanoscroller']
        }))
        .pipe(gulp.dest(jsDest));
});

//压缩JS/生成版本号
gulp.task('revJsDist', function () {
    return gulp.src(['dist/js/**/*.js', '!dist/js/lib/**/*.js'])
        .pipe(rev())
        .pipe(gulp.dest(jsDest))
        .pipe(rev.manifest())
        .pipe(gulp.dest(jsRev));
});

// js发布
gulp.task('jsDist', function (done) {
    runSequence('pluginCopy', 'configJsCopy', 'rjs', 'revJsDist', done);
});

//html发布
gulp.task('htmlDist', function () {
    return gulp.src(['rev/**/*.json', 'views/**/*.jsp', 'views/**/*.html'])
        .pipe(revCollector())
        .pipe(gulp.dest('dist/'));
});

//正式构建
gulp.task('build', function (done) {
    runSequence(
        'clean', 'fontDist', 'imgDist', 'cssDist', 'jsDist', 'htmlDist', done);
});

