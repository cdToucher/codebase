package cn.com.duiba.plugins

import org.gradle.api.Project
/**
 * Created by gyf .
 * 2017/12/18 .
 */
class ExcludeDependenciesPlugin {

    static void exclude(Project project) {
        // 所有子工程都排除相关依赖
        if (!project.rootProject.name.equals(project.name)) {
            project.configurations {
                compile.exclude group: 'log4j', module:'log4j'
                compile.exclude group: 'org.slf4j', module: 'slf4j-log4j12'
                compile.exclude group: 'javax.servlet', module: 'servlet-api' //servlet 2.5
            }
        }
    }
}
